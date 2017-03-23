package com.example.order.constant;

public enum OrderStatus {
	WAIT_PAY((byte)11, "待付款"),
	PAID((byte)12, "已付款"),
	
	WAIT_DELIVERY((byte)21, "待发货"),
	DELIVERED((byte)22, "已发货"),
	
	WAIT_RECEIVE((byte)31, "待收货"),
	RECEIVED((byte)32, "已收货"),
	
	FINISHED((byte)42, "已完成"),
	
	CANCELED((byte)52, "已取消");
	
	
	private byte code;
	private String msg;
	
	private OrderStatus(byte code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static OrderStatus fromCode(Byte code) {
		if(code == null) {
			return null;
		}
		for(OrderStatus r : OrderStatus.values()) {
			if(r.code == code.byteValue()) {
				return r;
			}
		}
		return null;
	}

	public byte getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
	

}
