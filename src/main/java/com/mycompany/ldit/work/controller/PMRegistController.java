package com.mycompany.ldit.work.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("pmregist")
public class PMRegistController {
	@RequestMapping(value = "/pmregist", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "right/rightgrant";
	}
}
