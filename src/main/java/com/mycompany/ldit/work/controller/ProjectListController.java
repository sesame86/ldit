package com.mycompany.ldit.work.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ldit.project.model.service.ProjectService;

@Controller
public class ProjectListController {
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/projectmain", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "project/projectmain";
	}

}