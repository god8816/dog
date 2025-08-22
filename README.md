Dog【狗】
================

#### 一个基于jmeter造数据方案

# 功能
  * Dog 造数据能力   支持Mysql、Elasticsearch、RocketMq、Kafka短时间造亿万级别的数据
  * Dog 强大数据类型支持 支持自增数据器、SnowflakeID、随机金额、UUID、随机中文、随机数字字母混合、随机时间、随机省市区街道、随机手机号、随机邮箱等，可以模拟真实的生产数据压测你的接口及中间件等 

# 模块
  * mysql、es结构初始化目录 : 初始化Mysql表结构、Elasticsearch索引结构

  * jmeter依赖jar目录 : jmeter运行本轮子需要依赖的jar，将其copy到apache-jmeter-5.1/lib/ext 目录底下
  
  * jmeter-造数据工具目录 : 需要将其导入到jmeter中打开             

  * jmeter-api : 编写jmeter插件及工具类maven工程
 
#  特征
   
   *  支持Mysql、Elasticsearch、RocketMq、Kafka造数据，依托jmeter灵活且性能强大
   
   *  支持数据类型丰富，目前能想到的数据类型都支持
   
   *  配置简单工程支持单条插入、批量插入且支持动态设置步长

   *  丰富的扩展支持，你可以在jmeter-api中实现，目前未支持你想要的功能 

# 环境要求 

  * apache-jmeter-5.1 环境
  
  
# 使用及问题

  1、安装jmeter，我这边使用apache-jmeter-5.1版本，你也可以选择其他版本不过我没有做测试
  2、设置bin/jmeter.properties sampleresult.default.encoding=UTF-8 不然中文会乱码
  3、安装插件 jmeter-plugins-manager、Random CSV Data Set、 kafka Support、kakfa backend listener
  4、如果导入jar和插件后没有反应，重启jmeter即可
  
# 简介 

  1、Dog是一个造数据的轮子
  
    工作流程：
  
	      第一步：编写要插入各类中间件的数据数据结构
	      
	      第二步：点击jmeter开会按钮
	      
    工作原理：
    
      1.1、单条插入模式
    
	      第一步：使用jmeter BeanShell组件封装自增数据器、SnowflakeID、随机金额、UUID、随机中文、随机数字字母混合、随机时间、随机省市区街道、随机手机号、随机邮箱组件
	      
	      第二步：将BeanShell组件产生的值，传递给不同的中间件插件。比如：MySQL JDBC插件、ES _bulk接口插件、kafka KafkaProducerSampler插件、RocketmqProducterSampler插件
	      
	      第三布：各类插件分别和MySql、Es、Kafka、RocketMq通讯插入数据
	      
	  2.2、批量插入模式
	  
	      第一步：使用jmeter BeanShell组件封装自增数据器、SnowflakeID、随机金额、UUID、随机中文、随机数字字母混合、随机时间、随机省市区街道、随机手机号、随机邮箱组件
	      
	      第二步：将BeanShell组件产生的值放入缓存中，在传递给不同的中间件插件。比如：MySQL JDBC插件、ES _bulk接口插件、kafka KafkaProducerSampler插件、RocketmqProducterSampler插件
	      
	      第三布：各类插件分别和MySql、Es、Kafka、RocketMq通讯插入数据
      
      
  2、Dog使用技术
  
     jmeter：你需要熟悉jmeter
     
     java：你需要了解java开发才能定制开发
     
     
  3、设计思想
  
     3.1、站在巨人肩膀 利用jmeter高性能造数据，是一个不错的idea，他有丰富的插件、丰富的统计能力、压测能力，可以支持很多场景的造数据要求
     
     3.2、使用java开发一套工作常用的数据类型，做到快速配置、简单化、轻量化
     
     3.3、本轮子默认你已经有一定的jmeter使用能力

