/**
 * Copyright (C), 2015-2021
 * FileName: TESTOKHttp
 * Author:   呵呵哒
 * Date:     2021/3/26 14:55
 * Description:
 */
package org.springblade.common.tool;

/**
 * @创建人 hyp
 * @创建时间 2021/3/26
 * @描述
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TESTOKHttp {

	/**
	 * 调用对方接口方法
	 * @param path 对方或第三方提供的路径
	 * @param data 向对方或第三方发送的数据，大多数情况下给对方发送JSON数据让对方解析
	 */
	public static String interfaceUtil(String path,String data) {
		String result = null;
		try {
			URL url = new URL(path);
			//打开和url之间的连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			PrintWriter out = null;

			/**设置URLConnection的参数和普通的请求属性****start***/

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

			/**设置URLConnection的参数和普通的请求属性****end***/

			//设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
			//最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
			//post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
			conn.setDoOutput(true);
			conn.setDoInput(true);

			conn.setRequestMethod("POST");//GET和POST必须全大写
			/**GET方法请求*****start*/
			/**
			 * 如果只是发送GET方式请求，使用connet方法建立和远程资源之间的实际连接即可；
			 * 如果发送POST方式的请求，需要获取URLConnection实例对应的输出流来发送请求参数。
			 * */
			conn.connect();

			/**GET方法请求*****end*/

			/***POST方法请求****start*/

            out = new PrintWriter(conn.getOutputStream());//获取URLConnection对象对应的输出流

            out.print(data);//发送请求参数即数据

            out.flush();//缓冲数据

			/***POST方法请求****end*/

			//获取URLConnection对象对应的输入流
			InputStream is = conn.getInputStream();
			//构造一个字符流缓存
			String str = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((str = br.readLine()) != null) {
				//解决中文乱码问题
				str=new String(str.getBytes(),"UTF-8");
				JSONObject jsonArrays = JSONArray.parseObject(str);
				System.out.println(jsonArrays.get("code"));
				String code = jsonArrays.get("code").toString();
				System.out.println("000000000000000000000");
				if("1000".equals(code)){
					result = "true";
				}else{
					result = "false";
				}
				System.out.println("222222");
				System.out.println(str+"333333333");
			}
			//关闭流
			is.close();
			//断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
			//固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
			conn.disconnect();
			System.out.println("完整结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {

		//interfaceUtil("http://www.zhwlt.cn/api/userInfo/modifyThreePassword?username=13888888888&oldUserPwd=123456&newUserPwd=123123", "");//get请求
		//post请求
        interfaceUtil("http://www.zhwlt.cn/api/userInfo/modifyThreePassword",
             "username=13888888888&oldUserPwd=123123&newUserPwd=123123");
	}



}
