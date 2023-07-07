package com.demo.UserData.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.UserData.model.User;
import com.demo.UserData.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String sayHello() {
		return "index";
	}
	@GetMapping("/finduser")
	public ModelAndView searchUser(@RequestParam String cityinput) {
	
		System.out.println(""+cityinput);
		List<User> ulist= userService.findUser(cityinput);
		System.out.println(ulist);
		return new ModelAndView("viewusers","ulist",ulist);
		
	}
	
	@GetMapping("/adduser")
	public String addUser() {
		return "adduser";
	}
	
	@PostMapping("/addnewuser")
	public ModelAndView addNewUser(@ModelAttribute("registereduser") User u) {
		if(u!=null) {
			userService.addUser(u);
			return new ModelAndView("index","msg","Added user successfully");

		}
		
		return new ModelAndView("index","msg"," failed to Add");
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteuser(@PathVariable int id) {
		userService.deleteUser(id);
		return new ModelAndView("index","msg","deleted user successfully");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edituser(@PathVariable int id) {
		User u=userService.getById(id);
		return new ModelAndView("editUser","user",u);
	}
	
	@GetMapping("/modifyuser")
	public ModelAndView modifyUser(@ModelAttribute("registereduser") User u) {
		if(u!=null) {
			userService.modify(u);
			return new ModelAndView("index","msg","Updated user successfully");

		}
		
		return new ModelAndView("index","msg"," failed to Updated");
		
	}
	
}
