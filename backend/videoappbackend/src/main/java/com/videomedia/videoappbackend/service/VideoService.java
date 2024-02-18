package com.videomedia.videoappbackend.service;



import java.util.Set;

import com.videomedia.videoappbackend.pojo.Video;
import com.videomedia.videoappbackend.pojo.VideoWithUserDTO;


public interface VideoService {

    public Set<VideoWithUserDTO> getVideos();
    public Set<VideoWithUserDTO> findByUserId(String userId);
    public Set<VideoWithUserDTO> findByUsername(String username);
    public VideoWithUserDTO getVideo(String id);
    public void addVideo(Video video);
    public void deleteVideo(String id);
    public Set<VideoWithUserDTO> getFollowingVideos(String username);
    
    
}
