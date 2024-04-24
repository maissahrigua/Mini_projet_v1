package com.maissa.songs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.SongRepository;

@Service
public class SongServiceImpl implements SongService{
	
	@Autowired
	SongRepository songRepository;
	
	@Override
	public Song saveSong(Song s) {
		return songRepository.save(s);
	}

	@Override
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}

	@Override
	public void deleteSong(Song s) {
		songRepository.delete(s);
		
	}

	@Override
	public void deleteSongById(Long id) {
		songRepository.deleteById(id);
	}

	@Override
	public Song getSong(Long id) {
		return songRepository.findById(id).get();
	}

	@Override
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}
	
	@Override
	public Page<Song> getAllSongsParPage(int page, int size) {
		return songRepository.findAll(PageRequest.of(page, size));
	}

}
