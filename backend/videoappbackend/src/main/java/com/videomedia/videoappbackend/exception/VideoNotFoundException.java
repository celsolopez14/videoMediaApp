package com.videomedia.videoappbackend.exception;

public class VideoNotFoundException extends RuntimeException {

    public VideoNotFoundException(Long id) {
        super("The video id '" + id + "' does not exist in our records");
    }
    
}
