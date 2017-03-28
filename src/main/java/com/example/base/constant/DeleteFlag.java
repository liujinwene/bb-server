package com.example.base.constant;

public enum DeleteFlag {
	NO((byte)0, "否"),
	YES((byte)1, "是");
	
	private byte code;
	private String msg;
	
	private DeleteFlag(byte code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public DeleteFlag fromCode(Byte code) {
		if(code == null) {
			return null;
		}
		for(DeleteFlag r : DeleteFlag.values()) {
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
