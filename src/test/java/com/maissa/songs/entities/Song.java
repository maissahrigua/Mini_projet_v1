package com.maissa.songs.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSong;
	private String nomSong;
	private String nomSinger;
	private Date dateCreation;
	
	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(String nomSong, String nomSinger, Date dateCreation) {
		super();
		this.nomSong = nomSong;
		this.nomSinger = nomSinger;
		this.dateCreation = dateCreation;
	}
	public Long getIdSong() {
		return idSong;
	}
	public void setIdSong(Long idSong) {
		this.idSong = idSong;
	}
	public String getNomSong() {
		return nomSong;
	}
	public void setNomSong(String nomSong) {
		this.nomSong = nomSong;
	}
	public String getNomSinger() {
		return nomSinger;
	}
	public void setNomSinger(String nomSinger) {
		this.nomSinger = nomSinger;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", nomSong=" + nomSong + ", nomSinger=" + nomSinger + ", dateCreation="
				+ dateCreation + "]";
	}
	
}
