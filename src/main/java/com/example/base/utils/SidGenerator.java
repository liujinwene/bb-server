package com.example.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SidGenerator {
	private static int count = 0;
	
	// 因为SimpleDateFormat是线程不安全的，所以放在ThreadLocal中
	private static ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>();
	
	private static synchronized int getAndIncrement(){
		if (count > 99999) {
			count = 0;
		}
		return count++;
	}
	
	private static SimpleDateFormat getFormat() {
		SimpleDateFormat f = null;
		if ((f = format.get()) == null) {
			format.set((f = new SimpleDateFormat("yyMMddHHmmss")));
		}
		return f;
	}
	
	public static String getSid(String appid) {
		int count = getAndIncrement();
		String currentDate = getFormat().format(new Date());
		return String.format("%s%s%05d", appid, currentDate, count);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] thread = new Thread[10]; 
		for (int i=0; i<thread.length; i++) {
			thread[i] = new Thread(()->{
				for(int j=0; j<20001; j++){
					System.out.println(getSid("403"));
				}
			});
		}
		for (int i=0; i<thread.length; i++) {
			thread[i].start();
		}
		for (int i=0; i<thread.length; i++) {
			thread[i].join();
		}
		System.out.println("finish~~~~~~~~~~~~"+count);
	}
	
}
