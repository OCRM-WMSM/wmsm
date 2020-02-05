package com.boc.wms.distribute.domain;

/**
 * 数据分发策略实体
 * 
 * @author wq3643 X04
 *
 */
public class Distribute {
	private String installmentType;  // 分期类型
	private String distribution1;    // 分发策略
	private String distribution2;    // 分发策略
	private String cusLvl;           // 客户等级
	private String billamountst;     // 已出账账单起始金额
	private String billamountend;    // 已出账账单截止金额
	private String nobillamountst;   // 未出账单笔消费起始金额
	private String nobillamountend;  // 未出账单笔消费截止金额
	private String cardLimit;        // 信用卡额度
	private String channel;          // 分发渠道
	private String orgCode;          // 当前机构号
	private String provCode;         // 省行号
	private String orgLvl;           // 机构层级
	
	
	public String getOrgLvl() {
		return orgLvl;
	}
	public void setOrgLvl(String orgLvl) {
		this.orgLvl = orgLvl;
	}
	public String getProvCode() {
		return provCode;
	}
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}
	public String getInstallmentType() {
		return installmentType;
	}
	public void setInstallmentType(String installmentType) {
		this.installmentType = installmentType;
	}
	public String getDistribution1() {
		return distribution1;
	}
	public void setDistribution1(String distribution1) {
		this.distribution1 = distribution1;
	}
	public String getDistribution2() {
		return distribution2;
	}
	public void setDistribution2(String distribution2) {
		this.distribution2 = distribution2;
	}
	public String getCusLvl() {
		return cusLvl;
	}
	public void setCusLvl(String cusLvl) {
		this.cusLvl = cusLvl;
	}
	public String getBillamountst() {
		return billamountst;
	}
	public void setBillamountst(String billamountst) {
		this.billamountst = billamountst;
	}
	public String getBillamountend() {
		return billamountend;
	}
	public void setBillamountend(String billamountend) {
		this.billamountend = billamountend;
	}
	public String getNobillamountst() {
		return nobillamountst;
	}
	public void setNobillamountst(String nobillamountst) {
		this.nobillamountst = nobillamountst;
	}
	public String getNobillamountend() {
		return nobillamountend;
	}
	public void setNobillamountend(String nobillamountend) {
		this.nobillamountend = nobillamountend;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getCardLimit() {
		return cardLimit;
	}
	public void setCardLimit(String cardLimit) {
		this.cardLimit = cardLimit;
	}



}
