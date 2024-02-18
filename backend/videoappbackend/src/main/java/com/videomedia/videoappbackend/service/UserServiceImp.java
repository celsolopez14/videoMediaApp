package com.videomedia.videoappbackend.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.videomedia.videoappbackend.exception.UserNotFoundException;
import com.videomedia.videoappbackend.exception.UsernameDuplicateException;
import com.videomedia.videoappbackend.pojo.User;
import com.videomedia.videoappbackend.pojo.UserDTO;
import com.videomedia.videoappbackend.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO getUser(String id) {
        Optional <User> optionalUser = userRepository.findById(id);
        User user = unwrappUser(optionalUser, id);
        return convertToUserDTO(user);
    }

    @Override
    public UserDTO addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try{
            userRepository.save(user);
        } catch(DuplicateKeyException e){
            throw new UsernameDuplicateException(user.getUsername());

        }
        return convertToUserDTO(user);
    }

    @Override
    public void deleteUser(String id) {
        
        userRepository.deleteById(id);
    }

    @Override
    public Set<UserDTO> getUsers() {
        Set<UserDTO> users = new HashSet<>();
        for(User user : userRepository.findAll()){
            users.add(convertToUserDTO(user));
        }
        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return unwrappUser(optionalUser, "404");
    }

    @Override
    public void followUser(String userId, String userIdToFollow) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = unwrappUser(optionalUser, userId);

        Optional<User> optionalUserToFollow = userRepository.findById(userIdToFollow);
        User userToFollow = unwrappUser(optionalUserToFollow, userIdToFollow);

        user.getFollowing().add(userToFollow.getId());
        userToFollow.getFollowers().add(user.getId());
        userRepository.saveAll(List.of(user,userToFollow));
    }

    @Override
    public UserDTO getUserDTO(String username) {
        User user = getUserByUsername(username);
        return convertToUserDTO(user);
    }

    @Override
    public Set<UserDTO> getFollowers(String userId) {
        UserDTO userDTO = getUser(userId);
        Set<UserDTO> followers = new HashSet<UserDTO>();
        for(User user: userRepository.findAllById(userDTO.getFollowers())){
            followers.add(convertToUserDTO(user));
        }
        return followers;
        
    }

    @Override
    public Set<UserDTO> getFollowing(String userId) {
        UserDTO userDTO = getUser(userId);
        Set<UserDTO> following = new HashSet<UserDTO>();
        for(User user: userRepository.findAllById(userDTO.getFollowing())){
            following.add(convertToUserDTO(user));
        }
        return following;
    }

    @Override
    public void unFollowUser(String userId, String follower_id) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = unwrappUser(optionalUser, userId);

        Optional<User> optionalUserToUnFollow = userRepository.findById(follower_id);
        User userToUnFollow = unwrappUser(optionalUserToUnFollow, follower_id);

        user.getFollowing().remove(userToUnFollow.getId());
        userToUnFollow.getFollowers().remove(user.getId());
        userRepository.saveAll(List.of(user,userToUnFollow));
       
    }

    static User unwrappUser(Optional<User> entity, String id) {
        if(entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(id);
    }

    private UserDTO convertToUserDTO(User user){
       UserDTO userDTO = new ObjectMapper().convertValue(user, UserDTO.class);
       return userDTO;
    }
    
}
