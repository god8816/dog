package com.yst.jmeter.rocketmq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * Rocketmq发送消息插件
 * */
public class RocketmqProducterSampler extends AbstractJavaSamplerClient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//生产者IP
	String namesrvAddr = "";
	
	//生产者topic
	String topic = "";
	
	//生产者msg
	String rocketmqMsg = "";
	
	//定义GUI界面的参数。
	@Override
	public Arguments getDefaultParameters() {
	    Arguments params = new Arguments();
	    params.addArgument("namesrvAddr", "rocketMq集群IP");
	    params.addArgument("topic", "topic"); 
	    params.addArgument("rocketmqMsg", "发送消息，集合格式：[单体,单体]"); 
	    return params;
	}
	 
	//获取界面参数
	@Override
	public void setupTest(JavaSamplerContext context) {
	    //获取参数
		namesrvAddr = context.getParameter("namesrvAddr");
		topic = context.getParameter("topic");
		rocketmqMsg = context.getParameter("rocketmqMsg");
    }
	
	  //主体执行部分。
	  @Override
	  public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
	    //new一个SampleResult对象，用来实现计时、结果回写等操作。
	    SampleResult sr=new SampleResult();
	    
	    //业务操作
	    try {
	      //请求开始计时
	      sr.sampleStart();
	      
		  //初始化业务功能类。业务功能类就是真正用来实现请求发送的类。
		  DefaultMQProducer producer = new DefaultMQProducer();
	      producer.setNamesrvAddr(namesrvAddr);
	      producer.start();
	      //发送失败重试3次
	      producer.setRetryTimesWhenSendAsyncFailed(3);

	      //调用业务方法。
    	  List<Message> msgList = new ArrayList<>();
	      if(rocketmqMsg.substring(rocketmqMsg.length() - 1).equals("]") && rocketmqMsg.substring(0).equals("[")) {
		      JSONArray jsonList = JSON.parseArray(rocketmqMsg);
		      for (int i = 0; i < jsonList.size(); i++) {
			      Message msg = new Message(topic,
			    		  jsonList.get(i).toString().getBytes(RemotingHelper.DEFAULT_CHARSET));
			      msgList.add(msg);
			  }
	      }else {
	    	  String msgStr = "[" + rocketmqMsg + "]";
	    	  Message msg = new Message(topic,msgStr.getBytes(RemotingHelper.DEFAULT_CHARSET));
		      msgList.add(msg);
	      }
	      
	      producer.send(msgList);
	      //设置显示的请求数据，非必须。
		  StringBuilder bd = new StringBuilder("rockeMq消息返回值：")
				  .append("namesrvAddr=").append(namesrvAddr)
				  .append(",topic=").append(topic)
				  .append(",rocketmqMsg=").append(rocketmqMsg);
		  
	      sr.setSamplerData(bd.toString());
	      //设置显示的响应数据，必须。 result是操作rocketMq结果
	      sr.setResponseData("已经发送消息"+JSON.toJSONString(rocketmqMsg),sr.TEXT);
	      //设置请求的结束状态。
	      sr.setSuccessful(true);     
	    } catch (Exception e) {
	      sr.setResponseData("fail msg："+e.getMessage(),sr.TEXT);
	      sr.setSuccessful(false);
	    } finally {
	      //请求结束计时。
	      sr.sampleEnd();
	    }
	    return sr;
	  }
}
