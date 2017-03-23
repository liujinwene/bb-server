package com.example.order.cmd;

import com.example.base.PageCmd;

public class ListOrderItemByCdCmd extends PageCmd {
	private Long orderItemNo;
	private Long orderNo;
	private Long productNo;
	private Long productStyleNo;
	private String productName;
	private String productStyleName;
	private Long startCreateTime;
	private Long endCreateTime;
	private Byte deleteFlag;
	
	public Long getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(Long orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
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
}
