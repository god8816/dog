package com.yst.jmeter.api;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 金额类
 * */
public class MoneyUtil {
	
  

    /**
     * 随机获取金额
     * @param startNum
     * @param endNum
     * @param decimalFormat 金额格式 参考DecimalFormat 
     * */
	public static String randomMoney(Double startNum,Double endNum,String decimalFormat) {
		if(Objects.isNull(decimalFormat) || "".equals(decimalFormat)) {
			decimalFormat = "0.00";
		}
		ThreadLocalRandom t = ThreadLocalRandom.current();
		Double num = t.nextDouble(startNum, endNum);
		DecimalFormat decimalFormatObj = new DecimalFormat(decimalFormat);
		String money = decimalFormatObj.format(num);
		return money;
	}
	

	
	public static void main(String[] args) {
		String money = MoneyUtil.randomMoney(0.00D,122222.00D,null);
		System.out.println(money);
	}

}
