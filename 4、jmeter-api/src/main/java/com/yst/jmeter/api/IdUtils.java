package com.yst.jmeter.api;

import java.util.concurrent.atomic.AtomicLong;

import com.yst.jmeter.util.IdWorker;

public class IdUtils {
	
	private static AtomicLong counter =  new AtomicLong(0);
  
	/**
     * 自增id
     * */
	public static String incNum() {
		return String.valueOf(counter.getAndIncrement());
	}
	
	/**
     * 雪花算法id
     * */
	public static String snowFlakeID() {
		return IdWorker.getSnowFlakeID();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			String snowflakeid = IdUtils.incNum();
			System.out.println(snowflakeid);
		}
	}

}
