package com.boc.wms.common.domain;

import java.util.List;

/**
 * 机构树对象
 * 
 * @author st-wg-hzw14176
 *
 */
public class OrgTreeEntity {
	private String orgNo;// 机构编号
	private String orgName;// 机构名字
	private List<OrgTreeEntity> children;// 子机构

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<OrgTreeEntity> getChildren() {
		return children;
	}

	public void setChildren(List<OrgTreeEntity> children) {
		this.children = children;
	}

}
