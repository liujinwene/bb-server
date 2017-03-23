package com.example.order.cmd;

import java.util.List;

public class CreateOrderCmd {
	private Byte payType;
	private String description;
	
	private Long productNo;
	private Long productStyleNo;
	private Integer quantity;
	
	private String userName;
	private String userPhone;
	private String provinceName;
	private String cityName;
	private String areaName;
	private String address;
	
	private List<CreateOrderItemCmd> orderItems;
	private CreateOrderAddressCmd orderAddress;
	
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
	public List<CreateOrderItemCmd> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<CreateOrderItemCmd> orderItems) {
		this.orderItems = orderItems;
	}
	public CreateOrderAddressCmd getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(CreateOrderAddressCmd orderAddress) {
		this.orderAddress = orderAddress;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
