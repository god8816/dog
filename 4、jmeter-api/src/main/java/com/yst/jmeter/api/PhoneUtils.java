package com.yst.jmeter.api;
import com.yst.jmeter.util.PhoneRandom;

public class PhoneUtils {
	
    /**
     * 生成随机手机号
     * @return
     */
    public static String phone() {
        return PhoneRandom.getTel();
    }

   

    public static void main(String[] args) {
        String startime = PhoneUtils.phone();
        System.out.println(startime);
    }

}
