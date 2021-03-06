package com.boc.wms.user.domain;

import java.util.List;

/**
 * ehr用户实体
 * 
 * @author st-wg-hzw14176
 *
 */
public class Employee {
	private String name;// 员工姓名
	private String gender;// 性别
	private String employeeId;// 员工编号
	private String jobId;// 具体职位编号
	private String jobName;// 具体职位名称
	private String parentCode;// 上级主管编号(员工编号)
	private String parentName;// 上级主管称谓
	private String hireDate;// 入职时间
	private String orgCode;// 所属机构号
	private String orgName;// 所属机构名称
	private String unitCode;// 所属组织机构号
	private String unitName;// 所属组织机构名称
	private String employeeType;// 用工形式
	private String employeeStatus;// 员工状态
	// private String empRole;// 角色 01 管理人员 02营销人员 每个人只有一个角色
	private String lastMaintDate;// 更新时间
	private String empPwd;// 登陆密码 md5加密
	private String accStatus;// 账户状态 0注销 1正常
	private String onlineFlag;// 登陆状态0 离线 1在线
	private String annulReason;// 注销原因 1机构注销
	private Role currentRole;// 当前登录 角色

	private int orgLvl;// 用户所在机构级别

	private String provCode;// 省行号

	private List<Role> roles;// 角色

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

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastMaintDate() {
		return lastMaintDate;
	}

	public void setLastMaintDate(String lastMaintDate) {
		this.lastMaintDate = lastMaintDate;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(Role currentRole) {
		this.currentRole = currentRole;
	}

	public int getOrgLvl() {
		return orgLvl;
	}

	public void setOrgLvl(int orgLvl) {
		this.orgLvl = orgLvl;
	}

	public String getProvCode() {
		return provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}
	
	

}
