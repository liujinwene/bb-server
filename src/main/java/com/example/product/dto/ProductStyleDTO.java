package com.example.product.dto;

public class ProductStyleDTO {
	private Long productStyleNo;
	private String productStyleName;
	private Long createTime;
	private Long updateTime;
	private Byte deleteFlag;
	private Long deleteTime;
	
	public Long getProductStyleNo() {
		return productStyleNo;
	}
	public void setProductStyleNo(Long productStyleNo) {
		this.productStyleNo = productStyleNo;
	}
	public String getProductStyleName() {
		return productStyleName;
	}
	public void setProductStyleName(String productStyleName) {
		this.productStyleName = productStyleName;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public Byte getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Byte deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Long getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

}
