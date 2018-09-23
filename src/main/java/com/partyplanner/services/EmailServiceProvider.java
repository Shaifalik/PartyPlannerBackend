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

	public String sendMail(List<String> guestEmailIds, int id) {

		String emailMessage = "http://localhost:4200/eventplanner/eventsList/eventDetails/" + id;
		SimpleMailMessage mail = new SimpleMailMessage();
		try {
			for (String guestEmail : guestEmailIds) {
				mail.setTo(guestEmail);
				mail.setText("Party Invitation: please find the details in below link"+"\n"+emailMessage);
				mail.setSubject("Party Planner Mail");
				emailSender.send(mail);
			}
		} catch (MailException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		return "Mail Sent to all Guest!";
	}
}
