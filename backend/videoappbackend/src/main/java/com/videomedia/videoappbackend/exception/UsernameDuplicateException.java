package com.videomedia.videoappbackend.exception;

public class UsernameDuplicateException extends RuntimeException {

    public UsernameDuplicateException(String username) {
        super("The username '" + username + "' is already taken in our records");
    }
    
}
