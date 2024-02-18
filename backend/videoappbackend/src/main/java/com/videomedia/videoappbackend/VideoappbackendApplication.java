package com.videomedia.videoappbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.videomedia.videoappbackend.repository.UserRepository;
import com.videomedia.videoappbackend.repository.VideoRepository;

@SpringBootApplication
public class VideoappbackendApplication implements CommandLineRunner {

	@Autowired
	VideoRepository videoAppVideoRepository;

	@Autowired
	UserRepository videoAppUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(VideoappbackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/* 
		 User[] users = new User[]{
			new User(6L, "lola", "111", "Lola", "Lopez", null, null),
			new User(7L, "lola2", "222", "Lola2", "Lopez", null, null),
			new User(5L, "lola3", "333", "Lola3", "Lopez", null, null),
			new User(4L, "lola4", "444", "Lola4", "Lopez", null, null),
			new User(3L, "lola5", "555", "Lola5", "Lopez", null, null),
			new User(2L, "lola7", "777", "Lola7", "Lopez", null, null)
		};
		*/
		/* 
		 Video[] videos = new Video[]{
			new Video(1L, users[0], "https://www.youtube.com/embed/nIekqreVbWY?si=gE29zFdtHxRCxDiz",LocalDate.parse("2020-12-13"),"Title1", new HashSet<>()),
            new Video(2L,users[1], "https://www.youtube.com/embed/qJAaQu-DMJ0?si=LlhwMOt23gYckI8e",LocalDate.parse("2020-12-13"), "Title2", new HashSet<>()),
            new Video(3L, users[2], "https://www.youtube.com/embed/GZHVHK1OxC0?si=rcz1z2DXTc-O_ifx",LocalDate.parse("2020-12-13"), "Title3", new HashSet<>()),
            new Video(4L, users[3], "https://www.youtube.com/embed/9i1gQ7w2V24?si=Dw1VL7Hf8GYpRq3J",LocalDate.parse("2020-12-13"), "Title4", new HashSet<>()),
            new Video(5L, users[4], "https://www.youtube.com/embed/pKv5MAm2Wuw?si=nO0z0bLkTejCdz_U",LocalDate.parse("2020-12-13"), "Title4", new HashSet<>()),
            new Video(6L, users[5], "https://www.youtube.com/embed/zVN3XJ-jse8?si=w11oy1OhoRj7NtEp",LocalDate.parse("2020-12-13"), "Title5", new HashSet<>()),
		};
		*/
		/*
		for (int i = 0; i < users.length; i++) {
			videoAppUserRepository.save(users[i]);
		}

		for (int i = 0; i < videos.length; i++) {
			videoAppVideoRepository.save(videos[i]);
		}
		*/
		
	}

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
