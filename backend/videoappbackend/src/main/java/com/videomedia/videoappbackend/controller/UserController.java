package com.videomedia.videoappbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.videomedia.videoappbackend.exception.UsernameDuplicateException;
import com.videomedia.videoappbackend.pojo.FollowRequest;
import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.pojo.UserDTO;
import com.videomedia.videoappbackend.service.UserService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<UserDTO> getUser() {
        UserDTO userDTO = userService.getUserDTO(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(userService.getUser(userDTO.getId()), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        try{
            userService.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(UsernameDuplicateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<UserDTO>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}/followers-and-following")
    public ResponseEntity<Map<String, Set<UserDTO>>> getFollowersAndFollowing(@PathVariable String username) {
        Map<String, Set<UserDTO>> followersAndFollowing = new HashMap<>();
        UserDTO userDTO = userService.getUserDTO(username);
        Set<UserDTO> followers = new HashSet<>();
        Set<UserDTO> following = new HashSet<>();
        
        for(String userId : userDTO.getFollowers()){
            followers.add(userService.getUser(userId));
        }
        for(String userId : userDTO.getFollowing()){
            following.add(userService.getUser(userId));
        }

        followersAndFollowing.put("following", following);
        followersAndFollowing.put("followers", followers);

        return new ResponseEntity<>(followersAndFollowing, HttpStatus.OK);
    }

    @PostMapping("/follow")
    public ResponseEntity<HttpStatus> followUser(@Valid @RequestBody FollowRequest followRequest) {
        userService.followUser(followRequest.getUserId(), followRequest.getUserIdToFollow());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<HttpStatus> unFollowUser(@Valid @RequestBody FollowRequest unFollowRequest) {
        userService.followUser(unFollowRequest.getUserId(), unFollowRequest.getUserIdToFollow());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
