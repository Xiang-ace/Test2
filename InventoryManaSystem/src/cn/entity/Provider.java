package cn.entity;

import java.util.Date;

public class Provider {
	private Integer id;
	private String providerCode;
	private String providerName;
	private String providerDesc;// 供应商备注，经营范围
	private String providerContact;// 供应商联系人
	private String providerPhone;
	private String providerAddress;
	private String providerFax;
	private Integer createdBy;
	private Date creationDate;

	private Integer modifyBy;
	private Date modifyDate;

	private Bill bill;

	public Provider() {
		super();
	}

	public Provider(Integer id, String providerCode, String providerName,
			String providerDesc, String providerContact, String providerPhone,
			String providerAddress, String providerFax) {
		super();
		this.id = id;
		this.providerCode = providerCode;
		this.providerName = providerName;
		this.providerDesc = providerDesc;
		this.providerContact = providerContact;
		this.providerPhone = providerPhone;
		this.providerAddress = providerAddress;
		this.providerFax = providerFax;
	}

	public Provider(Integer id, String providerCode, String providerName,
			String providerDesc, String providerContact, String providerPhone,
			String providerAddress, String providerFax, Integer createdBy,
			Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.providerCode = providerCode;
		this.providerName = providerName;
		this.providerDesc = providerDesc;
		this.providerContact = providerContact;
		this.providerPhone = providerPhone;
		this.providerAddress = providerAddress;
		this.providerFax = providerFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderDesc() {
		return providerDesc;
	}

	public void setProviderDesc(String providerDesc) {
		this.providerDesc = providerDesc;
	}

	public String getProviderContact() {
		return providerContact;
	}

	public void setProviderContact(String providerContact) {
		this.providerContact = providerContact;
	}

	public String getProviderPhone() {
		return providerPhone;
	}

	public void setProviderPhone(String providerPhone) {
		this.providerPhone = providerPhone;
	}

	public String getProviderAddress() {
		return providerAddress;
	}

	public void setProviderAddress(String providerAddress) {
		this.providerAddress = providerAddress;
	}

	public String getProviderFax() {
		return providerFax;
	}

	public void setProviderFax(String providerFax) {
		this.providerFax = providerFax;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", providerCode=" + providerCode
				+ ", providerName=" + providerName + ", providerDesc="
				+ providerDesc + ", providerContact=" + providerContact
				+ ", providerPhone=" + providerPhone + ", providerAddress="
				+ providerAddress + ", providerFax=" + providerFax
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate
				+ ", bill=" + bill + "]";
	}

}
