package com.videomedia.videoappbackend.service;


import java.util.List;


import com.videomedia.videoappbackend.pojo.Video;


public interface VideoAppVideoService {

    public List<Video> getVideos();
    public Video getVideo(Long id);
    public void addVideo(Video video);
    public void deleteVideo(Long id);
    
    
}
