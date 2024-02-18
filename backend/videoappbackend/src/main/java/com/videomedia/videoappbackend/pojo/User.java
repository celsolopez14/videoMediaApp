package com.videomedia.videoappbackend.pojo;


import java.util.HashSet;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank(message = "username cannot be blank")
    @NonNull
    @Indexed(unique = true)
    private String username;

    @NotBlank(message = "password cannot be blank")
    @NonNull
    private String password;

    @NotBlank(message = "first name cannot be blank")
    @NonNull
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    @NonNull
    private String lastName;

    /*
    @Column(name = "followers")
    @JdbcTypeCode(SqlTypes.JSON)
    @ManyToMany
    @JoinTable(
    name = "followers",
    joinColumns = @JoinColumn(name = "follower_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
     */
    @Field("followers")
    private Set<String> followers = new HashSet<>();
    /* 
    @Column(name = "following")
    @JdbcTypeCode(SqlTypes.JSON)
    @ManyToMany(mappedBy = "followers")
    */
    @Field("following")
    private Set<String> following = new HashSet<>();
    
}
