package com.vladproduction.assignsendinganemail.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.vladproduction.assignsendinganemail.javaconfig")
@Profile("javaconfigProfile")
@PropertySource(value = "classpath:/com/vladproduction/assignsendinganemail/javaconfig/clientapplication.properties")
public class AppConfig {

    @Value("${test.key}")
    private String keyProperty;

    @Bean
    public DataSource mySqlDBDS(){
        return new MySqlDBDS();
    }

    @Bean
    public DataSource postgresDBDS(){
        return new PostgresDBDS();
    }

    @Bean
    public EmailService emailService(){
//        return new EmailService(mySqlDBDS());
        return new EmailService(postgresDBDS());
    }

    @Bean
    public String getKeyProperty(){
        return keyProperty;
    }

}
