package com.videomedia.videoappbackend.security;




public class SecurityConstants {
    public static String SECRET_KEY = null;
    public static final int TOKEN_EXPIRATION = 9000000;
    public static final String BEARER = "Bearer ";
    public static final String AUTH_PATH = "/auth";
    public static final String AUTHORIZATION = "Authorization";
    public static final String REGISTER_PATH = "user/register";

    public static void setSecretKey(String secretKey){
        SECRET_KEY = secretKey;
    }
    
}
