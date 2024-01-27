package com.videomedia.videoappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videomedia.videoappbackend.pojo.Video;
import com.videomedia.videoappbackend.service.VideoAppVideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/video")
public class VideoAppVideoController {
    

    @Autowired
    private VideoAppVideoService videoAppVideoService;

    @GetMapping("/all")
    public ResponseEntity<List<Video>> getVideos() {
        List<Video> videos = videoAppVideoService.getVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }
    
}
