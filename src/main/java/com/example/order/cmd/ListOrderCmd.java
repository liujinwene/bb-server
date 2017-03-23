package com.example.order.cmd;

import com.example.base.PageCmd;

public class ListOrderCmd extends PageCmd {
	//order
	private Long orderNo;
	private Byte status;
	private Byte payType;
	private String description;
	private Long startCreateTime;
	private Long endCreateTime;
	private Byte deleteFlag;
	
	//orderItem
	private Long orderItemNo;
	private Long productNo;
	private Long productStyleNo;
	private String productName;
	private String productStyleName;
	
	//orderAddress
	private Long addressNo;
	private String userName;
	private String userPhone;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String address;
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Byte getPayType() {
		return payType;
	}
	public void setPayType(Byte payType) {
		this.payType = payType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(Long startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public Long getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(Long endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	public Byte getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Byte deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Long getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(Long orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public Long getProductStyleNo() {
		return productStyleNo;
	}
	public void setProductStyleNo(Long productStyleNo) {
		this.productStyleNo = productStyleNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductStyleName() {
		return productStyleName;
	}
	public void setProductStyleName(String productStyleName) {
		this.productStyleName = productStyleName;
	}
	public Long getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(Long addressNo) {
		this.addressNo = addressNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
