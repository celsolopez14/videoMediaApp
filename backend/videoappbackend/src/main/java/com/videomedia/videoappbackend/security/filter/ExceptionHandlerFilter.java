package com.videomedia.videoappbackend.security.filter;

import java.io.IOException;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.videomedia.videoappbackend.exception.UserNotFoundException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            
            filterChain.doFilter(request, response);
        } catch(UserNotFoundException e){

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Username does not exist");
            response.getWriter().flush();   
        } catch (JWTVerificationException e){

            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("JWT NOT VALID");
            response.getWriter().flush(); 
        }catch (RuntimeException e){

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("BAD REQUEST");
            response.getWriter().flush();
        }
        
    }

    
    
}
