package com.videomedia.videoappbackend.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.videomedia.videoappbackend.pojo.Video;
import com.videomedia.videoappbackend.repository.VideoAppVideoRepository;

@Service
public class VideoAppVideoServiceImp implements VideoAppVideoService {

    @Autowired
    VideoAppVideoRepository videoAppVideoRepository;

    @Override
    public List<Video> getVideos() {
        // TODO Auto-generated method stub
        return (List<Video>) videoAppVideoRepository.findAll();
    }

    @Override
    public Video getVideo(Long id) {
        // TODO Auto-generated method stub
        return videoAppVideoRepository.findById(id).get();
    }

    @Override
    public void addVideo(Video video) {
        // TODO Auto-generated method stub
        videoAppVideoRepository.save(video);
    }

    @Override
    public void deleteVideo(Long id) {
        // TODO Auto-generated method stub
        videoAppVideoRepository.deleteById(id);
    }

    

    
    
}
