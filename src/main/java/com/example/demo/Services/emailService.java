package com.example.demo.Services;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

private String  from="antimjaiswal33@gmail.com";

public boolean sendmails(String to,String subject,String message)
{
	 boolean f=false;
	 String from="antimajswal33@gmail.com";

//		Email host 
		String host="smtp.gmail.com";
	//	
		// get system property

	Properties pro= new Properties();
	//Properties pro=new Properties();
	//host set 

	pro.put("mail.smtp.auth","true");
	pro.put("mail.smtp.starttls.enable","true");
	pro.put("mail.smtp.port","587");
	pro.put("mail.smtp.host",host);

	//Step 1 to get session object 


	Session session=Session.getInstance(pro,new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			
			return new PasswordAuthentication("antimjaiswal33","bewuuvxyzgqyujnj");
		}
		
	});

	// Step 2 :compose the message [text,multi media ]
	MimeMessage m=new MimeMessage(session);

	try {
		
	//from email
		m.setFrom(new InternetAddress(from));
		
		// adding recipient to 
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		// adding subject to message 
		m.setSubject(subject);
		
		// adding message 
		m.setText(message,"utf-8");
		m.saveChanges();
//		step 3 send message using Transport class
		Transport.send(m);
	System.out.println("ok");
	f=true;
	}catch (Exception e) {

	e.printStackTrace();
	}
return f;
}
	
}
