package com.yst.jmeter.api;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import com.yst.jmeter.util.NumUtil;

public class StringUtil {
	
	public static String[] words = {
			   "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
			   "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
			   "1","2","3","4","5","6","7","8","9","0"
	 };
	
    /**
     * 随机生成规定长度的字符串
     * */
	public static String getText(int textLength) {
		StringBuilder bd = new StringBuilder();
		for(int i = 0;i<textLength;i++) {
			bd.append(getRandomChar());
		}
		return bd.toString();
	}
	
    /**
     * 随机生成大小写字母与数字混合
     * */
	public static String getWordAndNum(int textLength) {
		StringBuilder bd = new StringBuilder();
		for(int i = 0;i<textLength;i++) {
			int num = Integer.valueOf(NumUtil.randomNumInt(0,61)) ;
			bd.append(words[num]);
		}
		return bd.toString();
	}
	
    /**
     * 获取UUID
     * */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
	}
	
    
	private static char getRandomChar() {
        String str = "";
        int hightPos; 
        int lowPos;
        
        hightPos = (176 + Math.abs(Integer.valueOf(NumUtil.randomNumInt(0, 39))));
        lowPos = (161 + Math.abs(Integer.valueOf(NumUtil.randomNumInt(0, 93))));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str.charAt(0);
    }
	

	
	public static void main(String[] args) {
	   for(int i=0;i<10;i++) {
		  System.out.println(getWordAndNum(10)); ;
	   }
	}

}
