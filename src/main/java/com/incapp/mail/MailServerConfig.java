package com.incapp.mail;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class MailServerConfig {

    private String adminEmail;
    private String adminPasscode;

    @Bean
    public JavaMailSender mailSender() {
    	System.out.println(adminEmail+" "+adminPasscode);

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(adminEmail);
        mailSender.setPassword(adminPasscode);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
