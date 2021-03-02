package com.example.Hibernate.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Hibernate.Pojo.Candidate;
import com.example.Hibernate.Service.CandidateService;
import com.example.Hibernate.Service.UserService;
import com.example.Hibernate.Thymeleaf.dto.UserDto;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CandidateRegs")
public class UserController {
	@Autowired
    private CandidateService candidateService;
	
	
	@ModelAttribute("user")
	public Candidate candidateDto() {
		return new Candidate();
	}
	
	
	@GetMapping
	public String showRegistrationForm() {
		return "CandidateRegs";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") Candidate dto) {
		candidateService.save(dto);
		return "redirect:/login";
		
	}
	

}
