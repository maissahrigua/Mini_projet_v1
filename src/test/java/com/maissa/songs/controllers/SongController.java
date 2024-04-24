package com.maissa.songs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.maissa.songs.entities.Song;
import com.maissa.songs.service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;

	@RequestMapping("/ListeProduits")
	public String listeSongs(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
				{
				Page<Song> sg = songService.getAllSongsParPage(page, size);
				modelMap.addAttribute("songs", sg);
				 modelMap.addAttribute("pages", new int[sg.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				return "listeSongs";
				}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createSong";
	}

	@RequestMapping("/saveSong")
	public String saveSong(@ModelAttribute("song") Song song, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		song.setDateCreation(dateCreation);

		Song saveSong = songService.saveSong(song);
		String msg = "song enregistré avec Id " + saveSong.getIdSong();
		modelMap.addAttribute("msg", msg);
		return "createSong";
	}

	@RequestMapping("/supprimerSong")
	public String supprimerSong(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		songService.deleteSongById(id);
		Page<Song> sg = songService.getAllSongsParPage(page, size);
		modelMap.addAttribute("produits", sg);
		modelMap.addAttribute("pages", new int[sg.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeSongs";
	}

	@RequestMapping("/modifierSong")
	public String editerSong(@RequestParam("id") Long id, ModelMap modelMap) {
		Song s = songService.getSong(id);
		modelMap.addAttribute("song", s);
		return "editerSong";
	}

	@RequestMapping("/updateSong")
	public String updateProduit(@ModelAttribute("song") Song song, @RequestParam("date") String date,ModelMap modelMap) throws ParseException {
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		song.setDateCreation(dateCreation);

		songService.updateSong(song);
		List<Song> sg = songService.getAllSongs();
		modelMap.addAttribute("songs", sg);
		return "listeSongs";
	}
}
