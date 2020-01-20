package com.boc.wms.blacklist.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boc.api.ApiResult;
import com.boc.api.ApiResultCode;
import com.boc.exception.BusException;
import com.boc.util.FtpUtil;
import com.boc.util.ftpConfig.FileServerFtpConfiger;
import com.boc.wms.blacklist.domain.BlacklistStat;
import com.boc.wms.blacklist.service.BlacklistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 黑名单管理controller
 * 
 * @author st-wg-hzw14176
 *
 */
@Api(tags = "黑名单管理模块接口")
@RequestMapping("/blacklist")
@RestController
public class BlacklistController {
	/**
	 * 文件服务器配置
	 */
	@Autowired
	private FileServerFtpConfiger fileServerFtpConfiger;
	
	@Autowired
	private BlacklistService blacklistService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 黑名单模板下载
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping("/downloadBlackListTmp")
	public Object downloadBlackListTmp(HttpServletResponse response) {
		OutputStream os = null;
		response.setCharacterEncoding("UTF-8");
		response.reset();
		response.setContentType("application/vnd.ms-csv");
		response.setHeader("Content-Disposition", "attachment; filename=reportClct.csv");
		try {
			os = response.getOutputStream();
			StringBuffer sb = new StringBuffer();
			sb.append("手机号").append(",");
			sb.append("卡号").append(",");
			sb.append("证件类型").append(",");
			sb.append("证件号").append(",");
			sb.append("分期业务种类-1账单|2消费|3现金|4自动").append(",");
			sb.append("起始日期（不填为永久）").append(",");
			sb.append("操作-1新增|2删除").append(",");
			os.write(sb.toString().getBytes("GBK"));
			os.flush();
			os.close();
		} catch (IOException e) {
			logger.error("BlacklistController-->downloadBlackListTmp", e);
			return ApiResult.fail("-1", "文件下载失败");
		}
		return ApiResult.success();

	}

	/**
	 * 目前是一个文件上传
	 * 
	 * @param orgCode
	 * @param file
	 * @return
	 */
	@PostMapping("/uploadBlacklistFile")
	public Object uploadBlacklistFile(@NotEmpty @RequestParam("employeeId") String employeeId,
			@NotEmpty @RequestParam("orgCode") String orgCode, @RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		if (!fileName.endsWith(".csv")) {
			return ApiResult.fail("-1", "上传文件必须是csv文件！");
		}
		String[] arr = fileName.split(".", -99);
		File dmp = null;
		try {
			dmp = File.createTempFile(arr[0] + "_bak", arr[1]);
			file.transferTo(dmp);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
			String currTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
			// 构造远程文件名字
			String remoteFile = employeeId + "_" + orgCode + "_" + currTime + ".csv";
			boolean flag = FtpUtil.FtpUploadFile(fileServerFtpConfiger, dmp, remoteFile);
			if (flag) {
				return ApiResult.success();
			} else {
				return ApiResult.fail("-1", "上传文件失败");
			}
		} catch (IOException e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.SYSTEM_ERROR);
		} catch (Exception e) {
			logger.error("", e);
			throw new BusException(ApiResultCode.SYSTEM_ERROR);
		} finally {
			if (dmp != null) {
				dmp.delete();
			}
		}

	}

	@PostMapping("/getBlackListHistory")
	@ApiOperation(value = "查询黑名单上传历史记录")
	public Object getUserList( String jsonUser,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		BlacklistStat e = JSONObject.parseObject(jsonUser, BlacklistStat.class);
		if(e==null) {
			e=new BlacklistStat();
		}
		Page<BlacklistStat> page = new Page<>(currentPage, pageSize);
		page = blacklistService.selectBlacklistStatePageList(page, e);
		return page;
	}

}
