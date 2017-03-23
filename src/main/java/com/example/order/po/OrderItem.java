package com.example.order.po;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bb_order_item")
public class OrderItem {
	private Long orderItemNo;
	private Long orderNo;
	private Long productNo;
	private Long productStyleNo;
	private String productName;
	private String productStyleName;
	private BigDecimal price;
	private Integer quantity;
	private BigDecimal totalAmount;
	private Long createTime;
	private Long updateTime;
	private Byte deleteFlag;
	private Long deleteTime;
	
	@Id
	@Column(name = "order_item_no")
	public Long getOrderItemNo() {
		return orderItemNo;
	}
	public void setOrderItemNo(Long orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	
	@Column(name = "order_no")
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	
	@Column(name = "product_no")
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	
	@Column(name = "product_style_no")
	public Long getProductStyleNo() {
		return productStyleNo;
	}
	public void setProductStyleNo(Long productStyleNo) {
		this.productStyleNo = productStyleNo;
	}
	
	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "product_style_name")
	public String getProductStyleName() {
		return productStyleName;
	}
	public void setProductStyleName(String productStyleName) {
		this.productStyleName = productStyleName;
	}
	
	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "total_amount")
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Column(name = "create_time")
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "update_time")
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	
	@Column(name = "delete_flag")
	public Byte getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Byte deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Column(name = "delete_time")
	public Long getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}
}
