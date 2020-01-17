package com.boc.wms.user.domain;

/**
 * 角色实体类
 * 
 * @author st-wg-hzw14176
 *
 */
public class Role {

	private int roleId;

	private String roleCode;
	private String roleName;

	private String createdDate;

	private String updatedDate;

	private String roleSts;

	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getRoleSts() {
		return roleSts;
	}

	public void setRoleSts(String roleSts) {
		this.roleSts = roleSts;
	}
	
	

}
