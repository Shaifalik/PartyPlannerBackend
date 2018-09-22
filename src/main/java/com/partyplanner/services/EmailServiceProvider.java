package com.partyplanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceProvider {

	@Autowired
	public JavaMailSender emailSender;

	public String sendMail(List<String> guestEmailIds) {
		
		
		SimpleMailMessage mail = new SimpleMailMessage();
		try {
			mail.setTo(guestEmailIds.get(0));
			mail.setText("Greetings :)");
			mail.setSubject("Mail From Spring Boot");
		} catch (MailException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		emailSender.send(mail);
		return "Mail Sent Success!";
	}
}
