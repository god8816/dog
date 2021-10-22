package com.yst.jmeter.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class AAA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String rocketmqMsg = "[{name:123},{name:456}]";
		String rocketmqMsg = "[123]";
		JSONArray jsonList = JSON.parseArray(rocketmqMsg);
		System.out.println(123);
	}
	

}
