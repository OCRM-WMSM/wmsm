package com.boc.util;

import com.boc.exception.BusException;
import com.boc.util.ftpConfig.FtpBaseConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

/**
 * ftp工具
 * 
 * @author st-wg-hzw14176
 *
 */
public class FtpUtil {
	private static final Logger logger = LoggerFactory.getLogger(FtpUtil.class);

	/**
	 * ftp文件上传
	 * 
	 * @param ftpBaseConfig
	 *            ftp服务器配置项
	 * @param srcFile
	 *            本地文件
	 * @param remoteFieName
	 *            上传到远程服务器的文件名称
	 * @return
	 */
	public static boolean FtpUploadFile(FtpBaseConfig ftpBaseConfig, File srcFile, String remoteFieName) {
		return FtpUploadFile(ftpBaseConfig.url, ftpBaseConfig.port, ftpBaseConfig.username, ftpBaseConfig.password,
				ftpBaseConfig.remotepath, srcFile, remoteFieName);
	}

	/**
	 * ftp文件上传
	 * 
	 * @param url
	 *            上传的ftp地址
	 * @param port
	 *            上传的端口
	 * @param username
	 *            上传的ftp用户名
	 * @param password
	 *            上传的ftp密码
	 * @param remotePath
	 *            remotepath
	 * @param srcFile
	 *            本地文件
	 * @param remoteFieName
	 *            上传到远程服务器的文件名称
	 * @return
	 */
	public static boolean FtpUploadFile(String url, int port, String username, String password, String remotePath,
			File srcFile, String remoteFieName) {
		FTPClient ftpClient = new FTPClient();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(srcFile);
			ftpClient.connect(url, port);
			ftpClient.login(username, password);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				throw new BusException("-1", "登录ftp服务器出错");
			}
			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
			ftpClient.changeWorkingDirectory(remotePath);
			ftpClient.storeFile(remoteFieName, inputStream);
			inputStream.close();
			ftpClient.logout();
			return true;
		} catch (SocketException e) {
			logger.error("FtpUtil.FtpUploadFile", e);
			throw new BusException("登录ftp服务器出错,检查地址是否正确", e);
		} catch (IOException e) {
			logger.error("FtpUtil.FtpUploadFile", e);
			throw new BusException("FtpUploadFile error", e);
		} catch (Exception e) {
			logger.error("FtpUtil.FtpUploadFile", e);
			throw new BusException("FtpUploadFile error", e);
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					logger.error("FtpUtil.FtpUploadFile", e);
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("FtpUtil.FtpUploadFile", e);
				}
			}
		}

	}


}
