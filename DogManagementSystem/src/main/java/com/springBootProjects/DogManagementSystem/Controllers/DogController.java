package com.springBootProjects.DogManagementSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springBootProjects.DogManagementSystem.Models.Dog;
import com.springBootProjects.DogManagementSystem.repository.DogRepository;

@Controller
public class DogController {
//	
//	@RequestMapping("dogHome")
//	public String home() {
//		return "home";
//	}
	
	ModelAndView mv = new ModelAndView();
	@Autowired
	DogRepository dogRepo;
	
	@RequestMapping("dogHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewDog.html");
		return mv;
	}
	
	@RequestMapping("addNewDog")
	public ModelAndView addNewDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDogs() {
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = dogRepo.findAll();
		mv.addObject("dogs", dogList);
		return mv;
	}
	
	@RequestMapping("editDog")
	public ModelAndView editDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("editDog");
		return mv;
	}
}
