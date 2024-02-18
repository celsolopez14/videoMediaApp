package com.videomedia.videoappbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.videomedia.videoappbackend.security.SecurityConstants;

@Configuration
public class SecurityConstantsConfig {
    @Value("${application.secretKey}")
    private String SECRET_KEY;


    @Bean
    SecurityConstants securityConstants(){
        SecurityConstants securityConstants = new SecurityConstants();
        SecurityConstants.setSecretKey(SECRET_KEY);
        return securityConstants;
    }
}
