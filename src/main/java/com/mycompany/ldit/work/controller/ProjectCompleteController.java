package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.service.ProjectService;
import com.mycompany.ldit.project.model.vo.Project;

@Controller("pcomplete")
public class ProjectCompleteController {
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/pcomplete", method = RequestMethod.GET)
	public ModelAndView getPJComplete(ModelAndView mv, HttpSession session
			, @RequestParam("getproNo") int getproNo) {
		System.out.println("프로젝트 번호: "+getproNo);
		String viewpage = "project/projectmain";
		List<Project> complete = null;
		try {
			complete = projectService.updatePJF(getproNo);
			viewpage = "project/projectmain";
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
	
	@RequestMapping(value = "/proceed", method = RequestMethod.GET)
	public ModelAndView getPJProceed(ModelAndView mv, HttpSession session
			, @RequestParam("getproNo") int getproNo) {
		System.out.println("프로젝트 번호: "+getproNo);
		String viewpage = "project/projectmain";
		List<Project> proceed = null;
		try {
			proceed = projectService.updatePJC(getproNo);
			viewpage = "project/projectmain";
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}

}
