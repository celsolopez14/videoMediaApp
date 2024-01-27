package com.videomedia.videoappbackend.service;

import java.util.Set;

import com.videomedia.videoappbackend.pojo.User;

public interface VideoAppUserService{
    User getUser(Long id);
    User addUser(User user);
    void deleteUser(Long id);
    Set<User> getUsers();

}
