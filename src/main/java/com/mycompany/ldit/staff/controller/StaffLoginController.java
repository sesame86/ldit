package com.mycompany.ldit.staff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("login")
public class StaffLoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

}
