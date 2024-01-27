package com.videomedia.videoappbackend.pojo;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "videoapp_video")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JdbcTypeCode(SqlTypes.JSON)
    private User user;

    @Column(name = "video_url", nullable = false)
    private String videoUrl;

    @Column(name = "upload_date", nullable = false)
    private LocalDate uploadDate;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "likes")
    @JdbcTypeCode(SqlTypes.JSON)
    private Set<User> likes;

    
}
