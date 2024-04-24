package com.maissa.songs.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.maissa.songs.entities.Song;

public interface SongService {
	Song saveSong(Song s);
	Song updateSong(Song s);
	void deleteSong(Song s);
	 void deleteSongById(Long id);
	 Song getSong(Long id);
	List<Song> getAllSongs();
	public Page<Song> getAllSongsParPage(int page, int size);
}
