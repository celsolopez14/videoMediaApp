package com.videomedia.videoappbackend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.repository.VideoAppUserRepository;

@Service
public class VideoAppUserServiceImp implements VideoAppUserService {

    @Autowired
    VideoAppUserRepository videoAppUserRepository;

    @Override
    public User getUser(Long id) {
        
        return videoAppUserRepository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        
        return videoAppUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub
        videoAppUserRepository.deleteById(id);
    }

    @Override
    public Set<User> getUsers() {
        // TODO Auto-generated method stub
        return (Set<User>) videoAppUserRepository.findAll();
    }

   
    
}
