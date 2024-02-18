package com.videomedia.videoappbackend.controller;


import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.pojo.UserDTO;
import com.videomedia.videoappbackend.pojo.Video;
import com.videomedia.videoappbackend.pojo.VideoWithUserDTO;
import com.videomedia.videoappbackend.service.UserService;
import com.videomedia.videoappbackend.service.VideoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/")
public class VideoController {
    

    @Autowired
    private VideoService videoService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}/videos")
    public ResponseEntity<Set<VideoWithUserDTO>> getVideos(@PathVariable String username) {
        UserDTO user = userService.getUserDTO(username);
        Set<VideoWithUserDTO> videos = videoService.findByUserId(user.getId());
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @GetMapping("/{username}/following-videos")
    public ResponseEntity<Set<VideoWithUserDTO>> getFollowersVideos(@PathVariable String username) {
        Set<VideoWithUserDTO> following_videos = videoService.getFollowingVideos(username);
        return new ResponseEntity<>(following_videos, HttpStatus.OK);
    }

    @PostMapping("/post-video")
    public ResponseEntity<HttpStatus> postVideo(@Valid @RequestBody Video video) {
        videoService.addVideo(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}
