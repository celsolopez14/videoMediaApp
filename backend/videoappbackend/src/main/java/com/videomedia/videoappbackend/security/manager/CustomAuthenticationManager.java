package com.videomedia.videoappbackend.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.service.UserService;

import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager{

    private UserService userServiceImp;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userServiceImp.getUserByUsername(authentication.getName());
        if(!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())){
            throw new BadCredentialsException("Wrong password");
        }
        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials().toString());
    }
    
}