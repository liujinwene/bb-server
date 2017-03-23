package com.example.order.cmd;

public class CreateOrderItemCmd {
	private Long productNo;
	private Long productStyleNo;
	private Integer quantity;
	
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
}
