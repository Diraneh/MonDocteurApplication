package org.poeiscrumproject.gp2;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class SendEmail {

	final String senderEmail = "healthcare.aabej.app2020@gmail.com";
	final String senderPassword = "1234abc!";
	final String emailSMTPserver = "smtp.gmail.com";
	final String emailServerPort = "465";
	String receiverEmail = null;
	static String emailSubject = "Test Mail";
	static String emailBody = ":)";

	public SendEmail(String receiverEmail, String emailSubject, String emailBody) {
		this.receiverEmail = receiverEmail;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		Properties props = new Properties();
		props.put("mail.smtp.user", senderEmail);
		props.put("mail.smtp.host", emailSMTPserver);
		props.put("mail.smtp.port", emailServerPort);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", emailServerPort);
		
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		SecurityManager security = System.getSecurityManager();
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
			Transport.send(msg);
			
			System.out.println("Message send Successfully:)");
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	public class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmail, senderPassword);
		}
	}

	

}