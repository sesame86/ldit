package com.mycompany.ldit.work.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("teammain")
public class TeamMainController {
	@RequestMapping(value = "/teammain", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "team/team_main";
	}
	
}
