package com.maissa.songs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.maissa.songs.service.SongService;

@SpringBootApplication
public class SongsApplication  implements CommandLineRunner{

	@Autowired
	SongService songService;
	
	public static void main(String[] args) {
		SpringApplication.run(SongsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		songService.saveProduit(new Song("All too well","Taylor Swift" , new Date()));
		songService.saveProduit(new Song("Betty", "Taylor Swift", new Date()));
		songService.saveProduit(new Song("The 1", "Taylor Swift", new Date()));
	}

}
