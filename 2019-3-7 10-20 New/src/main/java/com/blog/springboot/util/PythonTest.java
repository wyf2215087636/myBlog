package com.blog.springboot.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.text.html.HTML;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.python.antlr.PythonParser.return_stmt_return;

public class PythonTest {
	

	public static void main(String[] args){
		//创建一个http请求
		/*HttpClient httpClient = new DefaultHttpClient();
		HttpContext httpContext = new BasicHttpContext();
		HttpGet httpGet = new HttpGet("https://api.mlwei.com/music/api/wy/?key=523077333&cache=0&type=url&id=32507038");
		
		try {
			HttpResponse response = httpClient.execute(httpGet,httpContext);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取重定向之后的主机信息
		HttpHost targetHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
		//获取实际的请求对象的URI
		HttpUriRequest realRequest = (HttpUriRequest) httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
		
		System.out.println("host:====================="+targetHost);
		System.out.println("真实地址:====================="+realRequest.getURI());
		System.out.println(targetHost+""+realRequest.getURI());*/
		
		PythonTest test = new PythonTest();
		test.start_download("https://api.mlwei.com/music/api/wy/?key=523077333&cache=0&type=url&id=32507038","演员");
		System.out.println("下载成功~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!!!!!!");
			
			
		
		
		 
		
		//下载二测试===失败
		/*String downloadFile = HttpConnectionUtil.downloadFile("http://music.163.com/song/media/outer/url?id=1313354324", "D:\\");
		System.out.println("下载返回地址:"+downloadFile);
		try {
			//等待下载
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	
	public int start_download(String url,String mp3_name) {
		//mp3Url MP3的URL
				try {
					InputStream inputStream = new URL(url(url)).openConnection().getInputStream();
					FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\22150\\Desktop\\"+mp3_name+".mp3");//创建文件输出流
					byte[] bb = new byte[1024];//接收缓存
					int len;
					while((len = inputStream.read(bb))>0) {//接收
						fileOutputStream.write(bb,0,len);//写入文件
					}
					fileOutputStream.close();
					inputStream.close();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//创建连接、输入流
				return 1;
	}
	
	
	
	public String url(String url) {
		//创建一个http请求
				HttpClient httpClient = new DefaultHttpClient();
				HttpContext httpContext = new BasicHttpContext();
				HttpGet httpGet = new HttpGet(url);
				
				try {
					HttpResponse response = httpClient.execute(httpGet,httpContext);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//获取重定向之后的主机信息
				HttpHost targetHost = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
				//获取实际的请求对象的URI
				HttpUriRequest realRequest = (HttpUriRequest) httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
				
				System.out.println("host:====================="+targetHost);
				System.out.println("真实地址:====================="+realRequest.getURI());
				System.out.println(targetHost+""+realRequest.getURI());
				
				return targetHost+""+realRequest.getURI();
	}
	
	
}
