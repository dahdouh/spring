package com.spring.myschool.restful.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	
	 public void sendSimpleMessage(String to, String subject, String text);
	 public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
	 public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String templateArgs);

}
