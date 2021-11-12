package com.mycompany.LDIT.work.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("topen")
public class TeamOpenUpController {
	@RequestMapping(value = "/teamadd", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "team_add";
	}
}