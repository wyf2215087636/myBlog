package com.blog.springboot.miusc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public String httpRequestUtils(String url,String params) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			URL reqUrl = new URL(url);
			//建立连接
			URLConnection conn = reqUrl.openConnection();
			
			//设置请求头
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//  conn.setRequestProperty("Connection","Keep-Alive");//保持长连接
			conn.setDoOutput(true);//设置true才可以使用conn.getOutputStream().write()
			conn.setDoInput(true);//才可以使用conn.getInputStream().read();
			
			//写入参数
			out = new PrintWriter(conn.getOutputStream());
			//设置参数，可以直接写&参数，也可以直接传入拼接好的
			out.println(params);
			//flush输出流的缓冲
			out.flush();
			
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//使用finally块来关闭输出流输入流
			try {
				if(out != null) {
					out.close();
				}
				if(in != null) {
					in.close();
				}
			} catch (IOException ex) {
				// TODO: handle exception
			}
			
			
		}
		
		return result.toString();
		
	}
	
	
	//请求api获取返回的json进行解析
	public List<String> jsonIsOk(String url){
		String httpurl = "https://api.mlwei.com/music/api/?key=523077333&id="+url+"&type=so&cache=0&size=hq&nu=1";
		String result = httpRequestUtils(httpurl, "");
		System.out.println(result);
		
		JSONObject jsonObject = JSONObject.fromObject(result);
		//通过getString("")分别取出里面的信息
		String arraydata = jsonObject.getString("Body");
		System.out.println(arraydata);
		
		
		//将jsonArray字符串转化为JSONArray
		JSONArray jsonArray = JSONArray.fromObject(arraydata);
		System.out.println(jsonArray.size());
		//取出数组第一个元素
		JSONObject jSongs = JSONObject.fromObject(jsonArray.get(0));
		//取出第一个元素的信息，并且转化为JSONObject
		System.out.println(jSongs.getString("author"));
		System.out.println(jSongs.getString("url"));
		
		List<String> list = new ArrayList<String>();
		list.add(jSongs.getString("author"));
		list.add(jSongs.getString("url"));
		
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		Test test = new Test();
		List<String> list = test.jsonIsOk("%E6%88%92%E7%83%9F");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		String url = list.get(1);
		
		
	}
}
