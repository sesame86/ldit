package com.mycompany.ldit.work.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.service.ProjectService;
import com.mycompany.ldit.project.model.vo.Project;

@Controller("pupdate")
public class ProjectUpdateController {
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/pupdate", method = RequestMethod.GET)
	public ModelAndView getDetailList(ModelAndView mv, HttpSession session) {
		String viewpage = "project/projectdetail";
		List<Project> detailList = null;
		int proNo;
//		proNo = getproNo;
		proNo = 1;
		System.out.println("프로젝트 번호: "+proNo);
		try {
			detailList = projectService.getDetailList(proNo);
			viewpage = "project/projectdetail";
			
			mv.addObject("detailList", detailList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}

}
