package com.example.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ConvertUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ConvertUtil.class);
	
	@SuppressWarnings("unchecked")
	public static <T> T convert(Object src, Class<T> destClz) {
		if (src == null || destClz == null) {
			return null;
		}
		
		if (src instanceof Map) {
			return convert((Map<String, Object>)src, destClz);
		}
		
		if (src.getClass() == destClz) {
			return (T) src;
		}
		
		try {
			T dest = destClz.newInstance();
			BeanUtils.copyProperties(src, dest);
			return dest;
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error("convert error: src="+src+", dest class="+destClz);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T convert(Map<String, Object> srcMap, Class<T> destClz) {
		if (ObjectUtil.isEmpty(srcMap) || destClz == null) {
			return null;
		}
		
		JSONObject json = new JSONObject();
		srcMap.forEach((k,v)->{
			json.put(k, v);
		});
		
		if (destClz == Map.class) {
			return (T) json;
		}
		
		return JSON.toJavaObject(json, destClz);
	}
	
	private static final SimpleDateFormat datetimeSF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat msDatetimeSF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static String formatDate(Object date) {
		if (date == null || "".equals(date.toString())) {
			date = new Date();
		}
		try {
			if (date instanceof Date) {
				return datetimeSF.format(date);
			}
			String dateStr = date.toString();
			long time = Long.parseLong(dateStr);
			return datetimeSF.format(new Date(time));
		} catch (Exception e) {
			return date.toString();
		}
	}
	
	public static String formatDateToMS(Object date) {
		if (date == null || "".equals(date.toString())) {
			date = new Date();
		}
		try {
			if (date instanceof Date) {
				return msDatetimeSF.format(date);
			}
			String dateStr = date.toString();
			long time = Long.parseLong(dateStr);
			return msDatetimeSF.format(new Date(time));
		} catch (Exception e) {
			return date.toString();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(formatDate("977404838666"));
		System.out.println(formatDateToMS("977404838666"));
//		Map<String, Object> map = new HashMap<>();
//		map.put("customer_name", "tt");
//		map.put("customer_Age", 15);
//		map.put("cust_GUID", 110);
//		System.out.println(convert(map, Customer.class));
	}
	
	static class Customer {
		private Integer customerAge;
		private Long custGUID;
		private String customerName;
		
		public Integer getCustomerAge() {
			return customerAge;
		}
		public void setCustomerAge(Integer customerAge) {
			this.customerAge = customerAge;
		}
		public Long getCustGUID() {
			return custGUID;
		}
		public void setCustGUID(Long custGUID) {
			this.custGUID = custGUID;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		@Override
		public String toString() {
			return JSON.toJSONString(this);
		}
	} 
}
