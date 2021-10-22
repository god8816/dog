package com.yst.jmeter.ztest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		StringBuffer bu = new StringBuffer("");
		for(int i=1;i<=1000;i++) {
			//mysql
			//bu.append("('${incNum"+i+"}', '${snowflakeid"+i+"}', '${money"+i+"}', '${uuid"+i+"}', '${text"+i+"}', '${startime"+i+"}', '${endtime"+i+"}', '${province}', '${city}', '${area}', '${street}','${province}-${city}-${area}-${street}-${text"+i+"}小区1幢1单元101室','${phone"+i+"}', '${mail"+i+"}', '${wordAndNum"+i+"}'),");
			
			//es
			//bu.append("{ \"index\" : { \"_index\" : \"a_xn\", \"_type\" : \"a_xn_type\",\"_id\": \"${incNum"+i+"}\"} }");
			//bu.append("\n");
			//bu.append("{\"incNum\":\"${incNum"+i+"}\",\"snowflakeId\":${snowflakeid"+i+"},\"money\":${money"+i+"},\"uuid\":\"${uuid"+i+"}\",\"name\":\"${text"+i+"}\",\"startTime\":\"${startime"+i+"}\",\"endTime\":\"${endtime"+i+"}\",\"province\":\"${province}\",\"city\":\"${city}\",\"area\":\"${area}\",\"street\":\"${street}\",\"address\":\"${province}-${city}-${area}-${street}-${text1}小区1幢1单元101室\",\"phone\":\"${phone"+i+"}\",\"mail\":\"${mail"+i+"}\",\"word_and_num\":\"${wordOrNum"+i+"}\"}");
			//bu.append("\n");
			
			//rocketMq
			bu.append("{'${incNum"+i+"}', '${snowflakeid"+i+"}', '${money"+i+"}', '${uuid"+i+"}', '${text"+i+"}', '${startime"+i+"}', '${endtime"+i+"}', '${province}', '${city}', '${area}', '${street}','${province}-${city}-${area}-${street}-${text"+i+"}小区1幢1单元101室','${phone"+i+"}', '${mail"+i+"}', '${wordAndNum"+i+"}'},");
			
		}
		String xx = bu.toString();
		writerFile(xx);
		System.out.println(xx);
	}
	
	
    public static void writerFile(String filestr)  {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dzc/Downloads/runoob.txt"));
            out.write(filestr);
            out.close();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
        }
    }

}
