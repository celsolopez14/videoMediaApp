package com.videomedia.videoappbackend.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("The user id '" + id + "' does not exist in our records");
    }
    
}
