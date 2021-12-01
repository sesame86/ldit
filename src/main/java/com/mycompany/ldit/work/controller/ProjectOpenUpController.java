package com.mycompany.ldit.work.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.service.ProjectService;
import com.mycompany.ldit.project.model.vo.Project;

@Controller("popen")
public class ProjectOpenUpController {
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/popen", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "project/projectadd";
	}
	
	@RequestMapping(value = "/pjadd", method = RequestMethod.POST)
	public ModelAndView insertPJ(ModelAndView mv, Project pJvo) {
		String viewpage = "redirect:popen"; // 프로젝트 메인으로 변경해주기
		System.out.println(pJvo);
		try {
			int result = projectService.insertPJ(pJvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
