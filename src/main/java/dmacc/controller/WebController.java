package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.ComicBookInformation;
import dmacc.beans.StoreInformation;
import dmacc.repository.SpringComicRepository;
import dmacc.repository.SpringStoreRepository;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Apr 11, 2022
 */
@Controller
public class WebController {
	
	@Autowired
	SpringComicRepository repo;
	
	
	@GetMapping({"/", "selection"})
	public String selection(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewComic(model);
		}
		model.addAttribute("comics", repo.findAll());
		return "selection";
	}
	

	@GetMapping("/input-comic-list")
	public String addNewComic(Model model) {
		ComicBookInformation c = new ComicBookInformation();
		model.addAttribute("newComic", c);
		return "input-comic-list";
	}
	
	@PostMapping("/input-comic-list")
	public String addNewComic(@ModelAttribute ComicBookInformation c, Model model) {
		repo.save(c);
		return selection(model);
	}
	
	@GetMapping("/editComic/{id}")
	public String showUpdateComic(@PathVariable("id") long id, Model model) {
		ComicBookInformation c = repo.findById(id).orElse(null);
		model.addAttribute("newComic", c);
		return "input-comic-list";
	}
	
	@PostMapping("/update/{id}")
	public String revisedComic(ComicBookInformation c, Model model) {
		repo.save(c);
		return selection(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComic(@PathVariable("id") long id, Model model) {
		ComicBookInformation c = repo.findById(id).orElse(null);
		repo.delete(c);
		return selection(model);
	}
	
	@GetMapping("/viewAllComics")
	public String viewAllComics(Model model) {
		if(repo.findAll().isEmpty()) {
			return viewAllComics(model);
		}
		model.addAttribute("comics", repo.findAll());
		return "selection";
	}
	
}