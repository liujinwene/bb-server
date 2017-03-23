package com.example.order.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderDetailDTO {
	//order
	private BigInteger orderNo;
	private Byte status;
	private Byte payType;
	private String description;
	private BigInteger createTime;
	private BigInteger updateTime;
	
	//orderItem
	private BigInteger productNo;
	private BigInteger productStyleNo;
	private String productName;
	private String productStyleName;
	private BigDecimal price;
	private Integer quantity;
	private BigDecimal totalAmount;
	
	//orderAddress
	private String userName;
	private String userPhone;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String address;
	
	public BigInteger getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(BigInteger orderNo) {
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
	public BigInteger getCreateTime() {
		return createTime;
	}
	public void setCreateTime(BigInteger createTime) {
		this.createTime = createTime;
	}
	public BigInteger getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(BigInteger updateTime) {
		this.updateTime = updateTime;
	}
	public BigInteger getProductNo() {
		return productNo;
	}
	public void setProductNo(BigInteger productNo) {
		this.productNo = productNo;
	}
	public BigInteger getProductStyleNo() {
		return productStyleNo;
	}
	public void setProductStyleNo(BigInteger productStyleNo) {
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
