package com.videomedia.videoappbackend.repository;


import org.springframework.data.repository.CrudRepository;

import com.videomedia.videoappbackend.pojo.User;


public interface VideoAppUserRepository extends CrudRepository<User, Long> {
       
}
