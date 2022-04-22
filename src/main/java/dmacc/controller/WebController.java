package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dmacc.beans.ComicBookInformation;
import dmacc.beans.StoreInformation;
import dmacc.beans.UserInformation;
import dmacc.repository.SpringComicRepository;
import dmacc.repository.SpringStoreRepository;
import dmacc.repository.SpringUserRepository;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Apr 11, 2022
 */
@Controller
public class WebController {
	
	@Autowired
	SpringComicRepository repo;
	@Autowired
	SpringStoreRepository repo2;
	@Autowired
	SpringUserRepository repo3;
	
	
	
	@RequestMapping({"/", "selection"})
	public String selection(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewComic(model);
		}
		model.addAttribute("newComics", repo.findAll());
		return "selection";
	}
	
	
		public String selection2(Model model) {
			if(repo2.findAll().isEmpty()) {
		return addNewStore(model);
			}
			model.addAttribute("newStores", repo2.findAll());
			return "selection";
	}
	
		public String selection3(Model model) {
			if(repo3.findAll().isEmpty()) {
		return addNewUser(model);
			}
			model.addAttribute("newUsers", repo3.findAll());
			return "selection";
	}

	@GetMapping(value = "/input-comic-information")
	public String addNewComic(Model model) {
		ComicBookInformation c = new ComicBookInformation();
		model.addAttribute("newComic", c);
		return "input-comic-information";
	}
	
	@PostMapping(value = "/input-comic-information")
	public String addNewComic(@ModelAttribute ComicBookInformation c, Model model) {
		repo.save(c);
		return viewAllComics(model);
	}
	
	@RequestMapping(value = "/editComic/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String showUpdateComic(@PathVariable("id") long id, Model model) {
		ComicBookInformation c = repo.findById(id).orElse(null);
		model.addAttribute("newComic", c);
		return "input-comic-information";
	}
	
	@RequestMapping(value = "/update/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String revisedComic(ComicBookInformation c, Model model) {
		repo.save(c);
		return viewAllComics(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComic(@PathVariable("id") long id, Model model) {
		ComicBookInformation c = repo.findById(id).orElse(null);
		repo.delete(c);
		return addNewComic(model);
	}
	
	@RequestMapping(value = "/result-comic-list", method = {RequestMethod.POST, RequestMethod.GET})
	
	public String viewAllComics(Model model) {
		if(repo.findAll().isEmpty()) {
			return viewAllComics(model);
		}
		model.addAttribute("newComics", repo.findAll());
		return "result-comic-list";
	}
	
	@GetMapping("/input-store-information")
	public String addNewStore(Model model) {
		StoreInformation s = new StoreInformation();
		model.addAttribute("newStore", s);
		return "input-store-information";
	}
	
	@PostMapping("/input-store-information")
	public String addNewStore(@ModelAttribute StoreInformation s, Model model) {
		repo2.save(s);
		return viewAllStores(model);
		
	}
	
	@RequestMapping(value = "/editStore/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String showUpdateStore(@PathVariable("id") long id, Model model) {
		StoreInformation s = repo2.findById(id).orElse(null);
		model.addAttribute("newStore", s);
		return "input-store-information";
	}
	
	@RequestMapping(value = "/updateStore/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String revisedStore(StoreInformation s, Model model) {
		repo2.save(s);
		return viewAllStores(model);
	}
	
	@GetMapping("/deleteStore/{id}")
	public String deleteStore(@PathVariable("id") long id, Model model) {
		StoreInformation s = repo2.findById(id).orElse(null);
		repo2.delete(s);
		return addNewStore(model);
	}
	@RequestMapping(value = "result-store-list", method = {RequestMethod.POST, RequestMethod.GET})
	public String viewAllStores(Model model) {
		if(repo2.findAll().isEmpty()) {
			return viewAllStores(model);
		}
		model.addAttribute("newStores", repo2.findAll());
		return "result-store-list";
	}
	
	@GetMapping("/input-user-information")
	public String addNewUser(Model model) {
		UserInformation u = new UserInformation();
		model.addAttribute("newUser", u);
		return "input-user-information";
	}
	
	@PostMapping("/input-user-information")
	public String addNewUserc(@ModelAttribute UserInformation u, Model model) {
		repo3.save(u);
		return viewAllUsers(model);
	}
	
	@RequestMapping(value = "/editUser/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String showUpdateUser(@PathVariable("id") long id, Model model) {
		UserInformation u = repo3.findById(id).orElse(null);
		model.addAttribute("newUser", u);
		return "input-user-information";
	}
	
	@RequestMapping(value = "/updateUser/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String revisedUser(UserInformation u, Model model) {
		repo3.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		UserInformation u = repo3.findById(id).orElse(null);
		repo3.delete(u);
		return addNewUser(model);
	}
	
	@RequestMapping(value = "/result-user-list", method = {RequestMethod.POST, RequestMethod.GET})
	public String viewAllUsers(Model model) {
		if(repo3.findAll().isEmpty()) {
			return viewAllUsers(model);
		}
		model.addAttribute("newUsers", repo3.findAll());
		return "result-user-list";
	}
	
	
}