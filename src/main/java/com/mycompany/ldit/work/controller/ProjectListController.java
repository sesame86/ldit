package com.mycompany.ldit.work.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.service.ProjectService;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.service.TeamService;

@Controller
public class ProjectListController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TeamService teamService;
	
//	@RequestMapping(value = "/projectmain", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		return "project/projectmain";
//	}
	
	@RequestMapping(value = "/projectmain", method = RequestMethod.GET)
	public ModelAndView getProjectList(ModelAndView mv, HttpSession session) {
		String viewpage = "project/projectmain";
		List<Project> newList = null;
		List<Project> continueList = null;
		List<Project> finishList = null;
		try {
			int proNo = 8;
			Staff loginUser = (Staff)session.getAttribute("loginUser");
			int rightNo = teamService.getStaffRight(loginUser.getStfNo());
			
			newList = projectService.getNewList(proNo);
			continueList = projectService.getContinueList(proNo);
			finishList = projectService.getFinishList(proNo);
			viewpage = "project/projectmain";

			mv.addObject("proNo", proNo);
			mv.addObject("newList", newList);
			mv.addObject("continueList", continueList);
			mv.addObject("finishList", finishList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
	
}