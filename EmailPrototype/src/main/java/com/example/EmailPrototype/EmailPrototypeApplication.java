package com.example.EmailPrototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailPrototypeApplication {
//	@Autowired
//	EmailSevice emailSevice;

	public static void main(String[] args) {
		SpringApplication.run(EmailPrototypeApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void setEmailSevice(){
//		emailSevice.sendEmail("payalgu493@gmail.com","Test Email","verification email");
//
//	}

}
