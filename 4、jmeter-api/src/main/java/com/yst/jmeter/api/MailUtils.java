package com.yst.jmeter.api;
import com.yst.jmeter.util.EmailRandom;

public class MailUtils {
	
    /**
     * 生成随机邮箱
     * @param min 邮箱最小长度
     * @param max 邮箱最大长度
     * @return
     */
    public static String mail(int min, int max) {
        return EmailRandom.getEmail(min,max);
    }

   

    public static void main(String[] args) {
        String startime = MailUtils.mail(1,9);
        System.out.println(startime);
    }

}
