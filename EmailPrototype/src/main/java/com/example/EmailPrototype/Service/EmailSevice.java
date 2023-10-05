package com.example.EmailPrototype.Service;

import com.example.EmailPrototype.DTO.EmailPrototypeDto;
import com.example.EmailPrototype.Entity.EmailPrototypeEntity;
import com.example.EmailPrototype.Repository.EmailPrototypeRepo;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.google.common.cache.LoadingCache;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class EmailSevice {
    @Autowired
    JavaMailSender javaMailSender;
    LoadingCache<String,Integer> otpCache;
    @Autowired
    EmailPrototypeRepo emailPrototypeRepo;

    public String register( EmailPrototypeDto emailPrototypeDto) {
        String username=emailPrototypeDto.getUsername();
        int otp=generateOtp();
        try {
            sendEmail(username, otp);
        }
        catch ( MessagingException messagingException){

        }
        EmailPrototypeEntity emailPrototypeEntity=new EmailPrototypeEntity();
        EmailPrototypeDto emailPrototypeDto1=new EmailPrototypeDto();
        emailPrototypeEntity.setUsername(emailPrototypeDto.getUsername());
        emailPrototypeEntity.setEmail(emailPrototypeDto.getEmail());
        emailPrototypeEntity.setPassword(emailPrototypeDto.getPassword());
        emailPrototypeEntity.setOtp(otp);

        emailPrototypeRepo.save(emailPrototypeEntity);

        return "Registered successfully";
    }
public int generateOtp(){

        //Create cache for OTp with 6min expiration
     otpCache = CacheBuilder.newBuilder().
             expireAfterWrite(3, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
                 public Integer load(String key) {
                     return 0;
                 }
             });
    Random random=new Random();
  int otpNumber= random.nextInt(99999);
  return otpNumber;
}

    public void sendEmail(String username, Integer otp) throws MessagingException {
        //SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        // simpleMailMessage.setFrom("payalgu493@gmail.com");
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String subject="Verify your Email";
        String fromEmail="payalgu493@gmail.com";
        String body= "<br>"
                + "Please find the otp below to verify your registration:<br>"
                +otp
                +"<br>"
                + "Thank you,<br>";

        helper.setTo(username);
        helper.setFrom(fromEmail);
        helper.setSubject(subject);
//        body.replace("[[OTP]]",otp.toString());

        helper.setText(body,true);
        javaMailSender.send(message);
    }



}
