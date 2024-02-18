package com.videomedia.videoappbackend.pojo;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowRequest {
    @NonNull
    private String userId;
    @NonNull
    private String userIdToFollow;
    
}
