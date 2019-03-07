package com.blog.springboot.mail;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.blog.springboot.mapper.PostsMapper;
import com.blog.springboot.pojo.SoCode;
import com.blog.springboot.util.Data;
import com.sun.mail.util.MailSSLSocketFactory;



public class Test {

	// 邮件编辑
	public static MimeMessage createSimpleMail(Session session, String usermail, String yzm) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress("feixunsat@163.com"));
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(usermail));
		// 邮件的标题
		message.setSubject("评论回复授权码");
		// 邮件的文本内容
		message.setContent("<table class=\"content\" role=\"presentation\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" bgcolor=\"#f5f5f5\" width=\"100%\" style=\"\r\n" + 
				"font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;\r\n" + 
				"font-size: 1em;\r\n" + 
				"line-height: 1.5;\r\n" + 
				"max-width: 600px;\r\n" + 
				"padding: 0 20px 0 20px;\r\n" + 
				"\">\r\n" + 
				"<tbody><tr>\r\n" + 
				"\r\n" + 
				"<td class=\"header\" style=\"\r\n" + 
				"padding: 20px;\r\n" + 
				"\">\r\n" + 
				"<table role=\"presentation\" width=\"100%\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"<tbody><tr>\r\n" + 
				"<td width=\"70\">\r\n" + 
				"<font color=\"#000000\"><b>飞讯@</b></font>" + 
				"</td>\r\n" + 
				"<td align=\"right\" style=\"text-align: right;\">\r\n" + 
				"<a class=\"login\" href=\"https://link.edx.org/click/5c7b48c7cdb7ec768d0a53f9/aHR0cHM6Ly9jb3Vyc2VzLmVkeC5vcmcvZGFzaGJvYXJkP3V0bV9jb250ZW50PThmY2IzMzA0LWM0NDMtNDVmYi1iNzQ3LTFlZWE2YzJjYWE1NyZ1dG1fbWVkaXVtPWVtYWlsJnV0bV9jYW1wYWlnbj1yZWN1cnJpbmdudWRnZV9kYXkzJnV0bV9zb3VyY2U9c2NoZWR1bGVzJnV0bV90ZXJtPWNvdXJzZS12MSUzQU1pY3Jvc29mdCUyQkRFVjI3NnglMkIxVDIwMTk/5c7781a2bf008116dd3201e1B491ea8c2\" style=\"color: #005686;\" rel=\"noopener\" target=\"_blank\">首页</a>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody></table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"\r\n" + 
				"<td class=\"main\" bgcolor=\"#ffffff\" style=\"\r\n" + 
				"padding: 30px 20px;\r\n" + 
				"box-shadow: 0 1px 5px rgba(0,0,0,0.25);\r\n" + 
				"\">\r\n" + 
				"<table width=\"100%\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
				"<tbody><tr>\r\n" + 
				"<td>\r\n" + 
				"<h1>您的授权码是("+usermail+").</h1>\r\n" + 
				"<p>\r\n" + 
				"请仔细阅读本邮件 <strong>您的授权码是:</strong>&nbsp;&nbsp;"+yzm+".&nbsp;&nbsp;欢迎进入本文章发布您的生活经历以及学习经历==>\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"<a href=\"https://link.edx.org/click/5c7b48c7cdb7ec768d0a53f9/aHR0cHM6Ly9jb3Vyc2VzLmVkeC5vcmcvY291cnNlcy9jb3Vyc2UtdjE6TWljcm9zb2Z0K0RFVjI3NngrMVQyMDE5L2NvdXJzZS8_dXRtX2NvbnRlbnQ9OGZjYjMzMDQtYzQ0My00NWZiLWI3NDctMWVlYTZjMmNhYTU3JnV0bV9tZWRpdW09ZW1haWwmdXRtX2NhbXBhaWduPXJlY3VycmluZ251ZGdlX2RheTMmdXRtX3NvdXJjZT1zY2hlZHVsZXMmdXRtX3Rlcm09Y291cnNlLXYxJTNBTWljcm9zb2Z0JTJCREVWMjc2eCUyQjFUMjAxOQ/5c7781a2bf008116dd3201e1Be4348987\" style=\"\r\n" + 
				"color: #ffffff;\r\n" + 
				"text-decoration: none;\r\n" + 
				"border-radius: 4px;\r\n" + 
				"-webkit-border-radius: 4px;\r\n" + 
				"-moz-border-radius: 4px;\r\n" + 
				"background-color: #005686;\r\n" + 
				"border-top: 12px solid #005686;\r\n" + 
				"border-bottom: 12px solid #005686;\r\n" + 
				"border-right: 50px solid #005686;\r\n" + 
				"border-left: 50px solid #005686;\r\n" + 
				"display: inline-block;\r\n" + 
				"\" rel=\"noopener\" target=\"_blank\">\r\n" + 
				"<font color=\"#ffffff\"><b>现在进入首页</b></font>\r\n" + 
				"</a>\r\n" + 
				"</p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody></table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"\r\n" + 
				"<td class=\"footer\" style=\"padding: 20px;\">\r\n" + 
				"\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"\r\n" + 
				"<td style=\"padding-bottom: 20px;\">\r\n" + 
				"\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"\r\n" + 
				"<td style=\"padding-bottom: 20px;\">\r\n" + 
				"<p>\r\n<br/><br/>" + 
				"<a href=\"http://www.baidu.com\" style=\"color: #005686\" rel=\"noopener\" target=\"_blank\">\r\n" + 
				"<font color=\"#005686\"><b>感谢您的支持~</b></font>\r\n" + 
				"</a>\r\n" + 
				"</p>\r\n" + 
				"<p>\r\n" + 
				"<a href=\"http://www.baidu.com\" style=\"color: #005686\" rel=\"noopener\" target=\"_blank\">\r\n" + 
				"<font color=\"#005686\"><b>欢迎您的到来</b></font>\r\n" + 
				"</a>\r\n" + 
				"</p>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"\r\n" + 
				"<td>\r\n" + 
				"© 2019 feiXunSat, All rights reserved.<br>\r\n" + 
				"<br>\r\n" + 
				"如果有建议来信此邮箱:<br>\r\n" + 
				"feixunsat@163.com\r\n<br/><br/>" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody></table>\r\n" + 
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody></table>", "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}

	// 验证码的生成
	// 生成随机数字和字母,
	public static String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	public static void sendEmail(String useremail, String yzm) throws Exception {
		Properties properties = new Properties();
		// 开启debug调试，以便在控制台查看
		properties.setProperty("mail.debug", "true");
		// 设置邮件服务器主机名
		properties.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		properties.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		properties.setProperty("mail.transport.protocol", "smtp");

		// 开启SSL加密，否则会失败
		
		MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
		
		mailSSLSocketFactory.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);

		// 创建session
		Session session = Session.getInstance(properties);
		// 通过session得到transport对象
		Transport transport = session.getTransport();
		// 连接邮件服务器:邮箱类型，账号，授权码代替密码(更安全)
		transport.connect("smtp.163.com", "feixunsat@163.com", "wyf2801998");
		// 生成验证码
		// String yzm = Test.getStringRandom(8);
		// 添加数据到对象
		/*
		 * SoCode soCode = new SoCode(); soCode.setUsermail(useremail);
		 * soCode.setCode(yzm); soCode.setTime(new Date()); //插入验证码到数据库 int num =
		 * postsMapper.save_code(soCode); //判断是否插入数据成功 if(num==1) {
		 */

		// 创建邮件createSimpleMail
		Message message = Test.createSimpleMail(session, useremail, yzm);
		// 发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

		// data.init(1, "邮件发送成功(如果未收到可能在垃圾箱)");

		/*
		 * }else { data.init(-1, "数据插入失败"); }
		 */
	}
}
