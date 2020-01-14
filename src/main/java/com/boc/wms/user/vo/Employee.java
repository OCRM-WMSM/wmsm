package com.boc.wms.user.vo;

import java.util.Date;

/**
 * ehr用户实体
 * @author st-wg-hzw14176
 *
 */
public class Employee {
	private String name;//员工姓名
	private String gender;//性别
	private String employeeId;//员工编号
	private String jobId;//具体职位编号
	private String jobName;//具体职位名称
	private String parentCode;//上级主管编号(员工编号)
	private String parentName;//上级主管称谓
	private Date hireDate;//入职时间
	private String orgCode;//所属机构号
	private String orgName;//所属机构名称
	private String unitCode;//所属组织机构号
	private String unitName;//所属组织机构名称
	private String employeeType;//用工形式
	private String employeeStatus;//员工状态
	private String empRole;//角色 01 管理人员 02营销人员 每个人只有一个角色
	private Date lastMaintDate;//更新时间
	private String empPwd;//登陆密码 md5加密
	private String accStatus;//账户状态 0注销 1正常
	private String onlineFlag;//登陆状态0 离线 1在线
	private String annulReason;//注销原因 1机构注销
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public Date getLastMaintDate() {
		return lastMaintDate;
	}
	public void setLastMaintDate(Date lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	public String getOnlineFlag() {
		return onlineFlag;
	}
	public void setOnlineFlag(String onlineFlag) {
		this.onlineFlag = onlineFlag;
	}
	public String getAnnulReason() {
		return annulReason;
	}
	public void setAnnulReason(String annulReason) {
		this.annulReason = annulReason;
	}
	
	
	

}
