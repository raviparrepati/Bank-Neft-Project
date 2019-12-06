package com.tcs.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
//	@RequestMapping(value="/")
//	public String toHome()
//	{
//		return "redirect:/home";
//	}
	
	@RequestMapping("/403")
	public String accessDenied()
	{
		return "403";
	}
}
