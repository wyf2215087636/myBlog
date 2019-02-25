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
		message.setContent("您的评论授权码为:" + yzm, "text/html;charset=UTF-8");
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
