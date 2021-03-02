package com.example.Hibernate.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Hibernate.Dao.AdminDao;
import com.example.Hibernate.Pojo.Candidate;
import com.example.Hibernate.Pojo.User;
import com.example.Hibernate.Service.CandidateService;
import com.example.Hibernate.Service.UserService;
import com.example.Hibernate.Thymeleaf.dto.UserDto;


@Controller
@RequestMapping("/registration")
public class AdminController {

	@Autowired
    private CandidateService candidateService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private AdminDao dao;
	
	
	@ModelAttribute("user")
	public UserDto userDto() {
		return new UserDto();
	}
	
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserDto user, Model model) {
		userService.save(user);
		 model.addAttribute("allEmps", candidateService.findAll());
		return "allRegistrations";
		// edit remaining: redirect to admin added page
	}
	
//	@GetMapping("/edit/{id}")
//	public String showUpdateForm(@PathVariable("id") long id, Model model) {
//	    User user = dao.findById(id)
//	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//	    
//	    model.addAttribute("user", user);
//	    return "update-user";
//	}
//	
//	@PostMapping("/update/{id}")
//	public String updateUser(@PathVariable("id") long id, @Valid User user, 
//	  BindingResult result, Model model) {
//	    if (result.hasErrors()) {
//	        user.setId(id);
//	        return "update-user";
//	    }
//	        
//	    dao.save(user);
//	    return "redirect:/allRegistrations";
//	}
//	    
//	@GetMapping("/delete/{id}")
//	public String deleteUser(@PathVariable("id") long id, Model model) {
//	    User user = dao.findById(id)
//	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//	    dao.delete(user);
//	    return "redirect:/allRegistrations";
//	}
	
}
