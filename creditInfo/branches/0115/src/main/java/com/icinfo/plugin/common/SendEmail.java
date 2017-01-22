package com.icinfo.plugin.common;


public class SendEmail {
	public static void doSendEmail(String title, String msg) {
//		if (ProUtil.MAIL_SEND.equalsIgnoreCase("true")) {
//			MailSenderInfo mailInfo = new MailSenderInfo();
//			mailInfo.setMailServerHost(ProUtil.MAIL_SERVER_HOST);
//			mailInfo.setMailServerPort(ProUtil.MAIL_SERVER_PORT);
//			mailInfo.setValidate(true);
//			mailInfo.setUserName(ProUtil.MAIL_USER_NAME);
//			mailInfo.setPassword(ProUtil.MAIL_PASSWORD);// 您的邮箱密码
//			mailInfo.setFromAddress(ProUtil.MAIL_FROM_ADDRESS);
//			mailInfo.setToAddress(ProUtil.MAIL_TO_ADDRESS);
//			mailInfo.setSubject(title);
//			mailInfo.setContent(msg);
//			// 这个类主要来发送邮件
//			SimpleMailSender sms = null;
//			for(String s:ProUtil.MAIL_TO_ADDRESS.split(";")){
//				mailInfo.setToAddress(s);
//				// 这个类主要来发送邮件
//				sms = new SimpleMailSender();
//				sms.sendTextMail(mailInfo);// 发送文体格式
//			}
//		}
	}
}
