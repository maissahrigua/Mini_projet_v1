package com.maissa.songs;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.SongRepository;
import com.maissa.songs.service.SongService;



@SpringBootTest
class SongsApplicationTests {

	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private SongService songService;
	
	@Test
	public void testCreateProduit() {
	Song s = new Song("Paris","Taylor Swift",new Date());
	songRepository.save(s);
	}
	
	@Test
	public void testFindSong()
	{
	Song sg = songRepository.findById(1L).get();
	System.out.println(sg);
	}
	@Test
	public void testUpdateSong()
	{
		Song sg = songRepository.findById(1L).get();
	sg.setNomSong("Betty");
	songRepository.save(sg);
	}
	
	@Test
	public void testDeleteSong()
	{
		songRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousSongs()
	{
	List<Song> sng = songRepository.findAll();
	for (Song s : sng)
	{
	System.out.println(s);
	}
	}
	
	@Test
	public void testFindByNomSongContains()
	{
	Page<Song> sg = songService.getAllSongsParPage(0, 2);
	System.out.println(sg.getSize());
	System.out.println(sg.getTotalElements());
	System.out.println(sg.getTotalPages());
	sg.getContent().forEach(s -> {System.out.println(s.toString());
	 });
	/*ou bien
	for (Song s : sg)
	{
	System.out.println(s);
	} */
	}


}
