package com.example.order.constant;

public enum PayType {
	DELIVERY_CASH((byte)1, "货到付款");
	
	private byte code;
	private String msg;
	
	private PayType(byte code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static PayType fromCode(Byte code) {
		if(code == null) {
			return null;
		}
		for(PayType r : PayType.values()) {
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
