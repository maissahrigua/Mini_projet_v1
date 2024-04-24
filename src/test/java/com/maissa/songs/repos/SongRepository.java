package com.maissa.songs.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.maissa.songs.entities.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
