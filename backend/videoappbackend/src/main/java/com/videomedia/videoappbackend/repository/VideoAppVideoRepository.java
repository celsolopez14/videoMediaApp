package com.videomedia.videoappbackend.repository;




import org.springframework.data.repository.CrudRepository;



import com.videomedia.videoappbackend.pojo.Video;


public interface VideoAppVideoRepository extends CrudRepository<Video, Long> {

    
} 

