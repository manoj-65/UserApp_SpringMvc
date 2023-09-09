package edu.jsp.userappspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.jsp.userappspringmvc.dto.User;
import edu.jsp.userappspringmvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/userapp")
	public ModelAndView landingPage() {
		ModelAndView mv = new ModelAndView("registerUser.jsp");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		boolean result = service.saveUser(user);
		ModelAndView mv = new ModelAndView("dashBord.jsp");
		if (result) {
			return findAllUser();
		}
		mv.addObject("msg", "User Not Saved!!");
		return mv;
	}

	@RequestMapping("/findAll")
	public ModelAndView findAllUser() {
		List<User> listOfUser = service.findAllUsers();
		ModelAndView mv = new ModelAndView("display.jsp");
		mv.addObject("users", listOfUser);
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView editUser(long id) {
		User user = service.findUsersById(id);

		ModelAndView mv = new ModelAndView("editUser.jsp");
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/updateUser")
	public ModelAndView updateUser(@ModelAttribute User user) {
		service.updateUser(user);
		return findAllUser();
	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam long id) {
		service.deleteUser(id);
		return findAllUser();
	}
}
