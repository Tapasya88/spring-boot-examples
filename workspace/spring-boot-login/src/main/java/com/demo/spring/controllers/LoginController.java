package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.User;
import com.demo.spring.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository repo;
	/*
	 * @RequestMapping(path="/login",method=RequestMethod.GET) public String
	 * getPage() { return "login"; }
	 */

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("userName") String username,
			@RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		User userFromDb = repo.findOne(username);
		if (userFromDb != null) {
			if (password.equals(userFromDb.getPassword())) {
				mv.setViewName("success");
				mv.addObject("user", userFromDb);
			} else {
				mv.setViewName("failure");
			}
		} else {
			mv.setViewName("failure");
		}
		return mv;
	}
}
