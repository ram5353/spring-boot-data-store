package com.example.demo.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired 
	AlienRepo repo;
	
	@RequestMapping("/showform")
	public String ShowForm() {
		return "showform.jsp";
	}
	@RequestMapping("/FetchShowForm")
	public String FetchShowForm() {
		return "FetchForm.jsp";
	}
	
	 @RequestMapping("/")
     public String home() {
    	 return "home.jsp";
     }
	 
	 @RequestMapping("/addAlien")
	 public String AddAlien(Alien alien) {
		 repo.save(alien);
		 return "showform.jsp";
		 
	 }
	 
	 @RequestMapping("/getAlien")
	 public ModelAndView getAlien(@RequestParam int aid) {
		 ModelAndView mv = new ModelAndView();
		 Alien alien = repo.findById(aid).orElse(new Alien());
		 mv.addObject("alien",alien);
		 System.out.println(alien);
		 mv.setViewName("ShowAlien.jsp");
		 return mv;
		 
	 }
}
