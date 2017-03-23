package com.example.base.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalUtil {
	
	public static BigDecimal roundDown(BigDecimal value) {
		if(value == null) {
			return BigDecimal.ZERO;
		}
		return value.setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public static BigDecimal roundUp(BigDecimal value) {
		if(value == null) {
			return BigDecimal.ZERO;
		}
		return value.setScale(2, BigDecimal.ROUND_UP);
	}
	
	public static BigDecimal convert(String value) {
		if(value == null) {
			return BigDecimal.ZERO;
		}
		return (new BigDecimal(value)).setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public static BigDecimal convert(Integer value) {
		if(value == null) {
			return BigDecimal.ZERO;
		}
		return (new BigDecimal(value)).setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public static BigDecimal convert(BigInteger value) {
		if(value == null) {
			return BigDecimal.ZERO;
		}
		return (new BigDecimal(value)).setScale(2, BigDecimal.ROUND_DOWN);
	}
	
	public static BigDecimal convert(Double value) {
		if(value == null) {
			return BigDecimal.ZERO;
		}
		return (new BigDecimal(value)).setScale(2, BigDecimal.ROUND_DOWN);
	}

}
