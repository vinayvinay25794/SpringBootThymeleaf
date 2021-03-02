package com.example.Hibernate.Thymeleaf;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Hibernate.Dao.AdminDao;
import com.example.Hibernate.Dao.CandidateDao;
import com.example.Hibernate.Pojo.Candidate;
import com.example.Hibernate.Pojo.User;
import com.example.Hibernate.Service.CandidateService;
import com.example.Hibernate.Service.UserService;

@Controller
public class MainController {

	
	@Autowired
    private UserService userService;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private CandidateDao dao;
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		 model.addAttribute("allEmps", candidateService.findAll());
		    return "allRegistrations";
	}
	
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Candidate candidate = candidateService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("user", candidate);
	    return "update-user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Candidate candidate, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	candidate.setId(id);
	        
	        System.out.println("-----------------------------------");
	        System.out.println(candidate);
	        return "update-user";
	    }
	        
	    dao.save(candidate);
	    model.addAttribute("allEmps", candidateService.findAll());
	    return "allRegistrations";
	}
	    
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Candidate candidate = candidateService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		candidateService.delete(candidate);
	    model.addAttribute("allEmps", candidateService.findAll());
	    return "allRegistrations";
	}
}

