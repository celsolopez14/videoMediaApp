package com.videomedia.videoappbackend.service;




import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.videomedia.videoappbackend.exception.UserNotFoundException;

import com.videomedia.videoappbackend.pojo.UserDTO;
import com.videomedia.videoappbackend.pojo.Video;
import com.videomedia.videoappbackend.pojo.VideoWithUserDTO;
import com.videomedia.videoappbackend.repository.VideoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VideoServiceImp implements VideoService {

    private VideoRepository videoRepository;

    @Autowired
    private UserService userServiceImp;

    @Override
    public Set<VideoWithUserDTO> getVideos() {
        List<Video> videos = videoRepository.findAll();
        Set<VideoWithUserDTO> allVideos = new HashSet<>();
        for(Video video : videos){
            allVideos.add(convertToVideoWithUserDTO(video));
        }
        return allVideos;
    }

    @Override
    public VideoWithUserDTO getVideo(String id) {
        Optional<Video> optionalVideo = videoRepository.findById(id);
        Video video = unwrappVideo(optionalVideo, id);
        return convertToVideoWithUserDTO(video);
    }

    @Override
    public Set<VideoWithUserDTO> findByUserId(String id) {
        Optional<Set<Video>> optionalVideos =  videoRepository.findByUserId(id);
        Set<Video> videos = unwrappVideos(optionalVideos, id);
        Set<VideoWithUserDTO> videoWithUserDTOs = new HashSet<>();
        for(Video video : videos){
            videoWithUserDTOs.add(convertToVideoWithUserDTO(video));
        }
        return videoWithUserDTOs;    
    }

    @Override
    public void addVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void deleteVideo(String id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Set<VideoWithUserDTO> getFollowingVideos(String username) {
        UserDTO user = userServiceImp.getUserDTO(username);
        Set<String> following = user.getFollowing();
        Set<VideoWithUserDTO> following_videos = new HashSet<>();
        for(String userId : following){
            for(VideoWithUserDTO video : findByUserId(userId)){
                following_videos.add(video);
            }
        }
        return following_videos;
    }

    @Override
    public Set<VideoWithUserDTO> findByUsername(String username) {
       UserDTO user = userServiceImp.getUserDTO(username);
       Set<VideoWithUserDTO> userVideos = findByUserId(user.getId());
       return userVideos;
    }

    static Video unwrappVideo(Optional<Video> entity, String id) {
        if(entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(id);
    }

    static Set<Video> unwrappVideos(Optional<Set<Video>> entity, String id) {
        if(entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(id);
    }

    private VideoWithUserDTO convertToVideoWithUserDTO(Video video){
       VideoWithUserDTO videoWithUserDTO = new ObjectMapper().convertValue(video, VideoWithUserDTO.class);
       UserDTO userDTO = userServiceImp.getUser(video.getUserId());
       videoWithUserDTO.setUserDTO(userDTO);
       return videoWithUserDTO;
    }
    
    
}
