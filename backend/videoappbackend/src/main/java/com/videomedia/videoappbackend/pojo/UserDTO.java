package com.videomedia.videoappbackend.pojo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*; 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private Set<String> followers;
    private Set<String> following;
    
}
