package com.videomedia.videoappbackend.repository;




import java.util.Optional;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.videomedia.videoappbackend.pojo.Video;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
    Optional<Set<Video>> findByUserId(String userId);

    
} 

