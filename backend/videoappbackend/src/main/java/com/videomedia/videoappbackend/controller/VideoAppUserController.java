package com.videomedia.videoappbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.service.VideoAppUserService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/user")
public class VideoAppUserController {

    @Autowired
    VideoAppUserService videoAppUserService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(videoAppUserService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(videoAppUserService.addUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        videoAppUserService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<User>> getUsers() {
        return new ResponseEntity<>(videoAppUserService.getUsers(), HttpStatus.OK);
    }
    
    
    
    
}
