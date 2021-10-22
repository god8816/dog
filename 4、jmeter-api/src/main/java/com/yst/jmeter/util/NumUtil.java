package com.yst.jmeter.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class NumUtil {
	
	private static AtomicLong counter =  new AtomicLong(0);
  
    /**
     * 高性能随机数 int
     * */
	public static String randomNumInt(int startNum,int endNum) {
		ThreadLocalRandom t = ThreadLocalRandom.current();
		return String.valueOf(t.nextInt(startNum, endNum));
	}
	
    /**
     * 高性能随机数 long
     * */
	public static String randomNumLong(long startNum,long endNum) {
		ThreadLocalRandom t = ThreadLocalRandom.current();
		return String.valueOf(t.nextLong(startNum, endNum));
	}
	
    /**
     * 高性能随机数 double
     * */
	public static String randomNumDouble(Double startNum,Double endNum) {
		ThreadLocalRandom t = ThreadLocalRandom.current();
		return String.valueOf(t.nextDouble(startNum, endNum));
	}
	
	/**
     * 自增id
     * */
	public static long incNum() {
		return counter.getAndIncrement();
	}
	
	/**
     * 雪花算法id
     * */
	public static String snowFlakeID() {
		return IdWorker.getSnowFlakeID();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			String snowflakeid = NumUtil.snowFlakeID();
			System.out.println(snowflakeid);
		}
	}

}
