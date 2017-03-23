package com.example.base.utils;

import java.util.List;
import java.util.Map;

public class ObjectUtil {
	
	public static boolean compare(Object expect, Object current){
		if (expect != null && current != null) {
			if (expect instanceof Integer && current instanceof Integer) {
				return compareInt((Integer)expect, (Integer)current);
			}
			
			if (expect instanceof Long && current instanceof Long) {
				return compareLong((Long)expect, (Long)current);
			}
			
			if (expect instanceof String && current instanceof String) {
				return compareString((String)expect, (String)current);
			}
			
			if (expect instanceof Boolean && current instanceof Boolean) {
				return compareBoolean((Boolean)expect, (Boolean)current);
			}
			
			return expect.equals(current);
		}
		return false;
	}
	
	public static boolean compareInt(Integer expect, Integer current){
		if (expect != null && current != null) {
			return expect.intValue() == current.intValue();
		}
		return false;
	}
	
	public static boolean compareLong(Long expect, Long current){
		if (expect != null && current != null) {
			return expect.longValue() == current.longValue();
		}
		return false;
	}
	
	public static boolean compareString(String expect, String current) {
		if (expect != null && current != null) {
			return expect.equals(current);
		}
		return false;
	}
	
	public static boolean compareBoolean(Boolean expect, Boolean current) {
		if (expect != null && current != null) {
			return expect.booleanValue() == current.booleanValue();
		}
		return false;
	}
	
	public static boolean isEmpty(Object object) {
		return object == null;
	}
	
	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}
	
	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.isEmpty();
	}
	
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}
	
	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}
	
	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}
	
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
	
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}
	
}
