package com.example.base.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
	
	public static Integer getStartPageOffset(int pageSize,int pageNo){
		return (pageNo-1)*pageSize;
	}
	public static boolean nextPage(Integer offset, Integer pageSize, Integer total){
		if(offset == null || pageSize == null || total == null) {
			return false;
		}
		return (offset + pageSize) < (total) ? true : false;
	}
	
	public static boolean nextPageOffset(Integer pageNo, Integer pageSize,Integer total){
		if(pageNo == null || pageSize == null || total == null) {
			return false;
		}
		int offset = PageUtil.getStartPageOffset(pageSize, pageNo);
		return (offset + pageSize) < (total) ? true : false;
	}
	
	public static Integer getPageNoInDefault(Integer pageNo){
		return (pageNo==null||pageNo==0)?1:pageNo;
	}
	public static Integer getPageSizeInDefault(Integer pageSize){
		return (pageSize==null||pageSize==0)?20:pageSize;
	}
	
	public static Integer getMaxPageSize(){
		return 100;
	}
	
	public static <T> List<T> operateByPage(List<T> nlist, int offset, int pageSize) {
		if(nlist == null || nlist.isEmpty()) {
			return new ArrayList<T>();
		}
		
		int toIndex = offset+pageSize;
		if(nlist.size()<(offset+1))
			return null;
		else if(nlist.size()<toIndex)
			return nlist.subList(offset, nlist.size());
		else
			return nlist.subList(offset, toIndex);
	}
	
}
