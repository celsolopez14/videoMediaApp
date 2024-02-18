package com.videomedia.videoappbackend.service;

import java.util.Set;

import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.pojo.UserDTO;

public interface UserService{
    UserDTO getUser(String id);
    UserDTO addUser(User user);
    User getUserByUsername(String username);
    UserDTO getUserDTO(String username);
    void followUser(String userId, String follower_id);
    void unFollowUser(String userId, String follower_id);
    void deleteUser(String id);
    Set<UserDTO> getUsers();
    Set<UserDTO> getFollowers(String userId);
    Set<UserDTO> getFollowing(String userId);

}
