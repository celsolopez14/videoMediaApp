package com.videomedia.videoappbackend.pojo;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@Table(name = "videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "videos")
public class Video {

    //@Id
    //@Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /* 
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JdbcTypeCode(SqlTypes.JSON)
    */
    private String userId;

    @NotBlank(message = "url cannot be blank")
    @NonNull
    //@Column(name = "video_url", nullable = false)
    private String videoUrl;

    //@Column(name = "upload_date", nullable = false) 
    private LocalDateTime uploadDate = LocalDateTime.now();

    @NotBlank(message = "url cannot be blank")
    @NonNull
    //@Column(name = "title", nullable = false)
    
    private String title;

    //@Column(name = "likes")
    //@JdbcTypeCode(SqlTypes.JSON)
   
    private Set<String> likes = new HashSet<>();

    
}
