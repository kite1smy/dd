package com.dangdang.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {


	private static Properties pro = new Properties();

	static {
		pro.setProperty("mail.transport.protocol", "smtp");  //smtpЭ��  ���ʼ�Э��      ����:http  ftp
		pro.setProperty("mail.smtp.host", "smtp.qq.com");    //smtp.qq.com ��Ѷ���ʼ�������    (��˾�������Լ����ʼ�������)   apache james
		pro.setProperty("mail.smtp.auth", "true");			 // ��Ҫ�����֤
		pro.setProperty("mail.smtp.port", "587");            // 587�˿ں�
	}
	public static int sendSimpleMail(String mati) {
		int res = 0;
		try {
			// 2.����һ���Ự������ʼ�����������
			Session session = Session.getDefaultInstance(pro);
			// 3.����һ���ʼ�����
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("1148334390@qq.com")); // ������
			message.setRecipient(MimeMessage.RecipientType.TO,
					new InternetAddress(mati)); // �ռ���
			message.setSubject("�����������ʼ�");// �����ʼ��ı���//
			message.setContent("<a href='http://192.168.1.100:8080/dangdang/public/user_key?user.email="+mati+"'>点击验证</a>", "text/html;charset=UTF-8");// �����ʼ�������
			message.setSentDate(new Date());// ����ʱ��
			message.saveChanges(); // ��������
			Transport transport = session.getTransport();// ��ȡһ���������
			transport.connect("1148334390@qq.com", "kktznludnizxfhba");// ���÷����ʼ��û���������(��Ȩ��)
			transport.sendMessage(message, message.getAllRecipients());// �����ʼ�

			transport.close();
			
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
