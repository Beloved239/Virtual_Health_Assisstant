package com.Vitality_Hub.Virtual_Health_Assisstant.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ComponentScan
public class DataSource {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder
                .create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://vitalityhub.c4honoauco01.us-east-1.rds.amazonaws.com:3306/vitality_hub")
                .username("root")
                .password("Adettob239")
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setUsername("adettob@gmail.com");
        mailSender.setPassword("lxzfsogbrdlwlwea");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }

    @Bean
    public String myStringBean() {
        return "";
    }



}
