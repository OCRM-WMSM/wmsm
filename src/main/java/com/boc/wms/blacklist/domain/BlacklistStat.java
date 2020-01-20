package com.boc.wms.blacklist.domain;

/**
 * 黑名单上传
 * 
 * @author st-wg-hzw14176
 *
 */
public class BlacklistStat {
	private String uploader;// 上传人
	private String upTime;// 上传时间
	private int recordTotal;// 总记录数
	private int recordSuccess;// 成功数量
	private String orgCode;// 用户所在机构

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public int getRecordTotal() {
		return recordTotal;
	}

	public void setRecordTotal(int recordTotal) {
		this.recordTotal = recordTotal;
	}

	public int getRecordSuccess() {
		return recordSuccess;
	}

	public void setRecordSuccess(int recordSuccess) {
		this.recordSuccess = recordSuccess;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
