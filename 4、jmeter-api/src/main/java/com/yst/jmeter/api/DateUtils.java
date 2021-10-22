package com.yst.jmeter.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
	
    /**
     * 生成随机时间 注意：3个参数的格式保持一致
     * @param beginDate
     * @param endDate
     * @param dateFormat
     * @return
     */
    public static String randomDate(String beginDate, String endDate,String dateFormat) {
        try {
        	if(Objects.isNull(dateFormat)) {
        		dateFormat = "yyyy-MM-dd hh:mm:ss";
        	}
        	
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            
            long date = random(start.getTime(), end.getTime());
            Date now =  new Date(date);
            String nowStr = format.format(now);
            return nowStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    public static void main(String[] args) {
        String startime = DateUtils.randomDate("2010-09-20 00:00:00", "2010-09-22 00:00:00","yyyy-MM-dd hh:mm:ss");
      
        System.out.println(startime);
    }

}
