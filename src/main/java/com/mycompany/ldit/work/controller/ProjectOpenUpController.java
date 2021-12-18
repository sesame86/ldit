package com.mycompany.ldit.work.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.service.ProjectService;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.right.model.service.RightService;
import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller("popen")
public class ProjectOpenUpController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	RightService rightService;
	@Autowired
	private StaffService staffservice;
	
	@RequestMapping(value = "/popen", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "project/projectadd";
	}
	
	@RequestMapping(value = "/pjadd", method = RequestMethod.POST)
	public ModelAndView insertPJ(ModelAndView mv, Project pJvo, HttpSession session) {
		String viewpage = "redirect:projectmain";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		mv.addObject("loginUser", staffservice.profile(loginUser));
				
		System.out.println(pJvo);
		try {
			int result = projectService.insertPJ(pJvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
	
	@RequestMapping(value = "/tmregist", method = RequestMethod.GET)
	@ResponseBody
	public List<Staff> getStaffList(HttpServletRequest request
			, @RequestParam(value = "stfName", required = false) String getStfName
			) {
		
		System.out.println("getStfName : " + getStfName);
		
		Staff vo = new Staff();
		vo.setStfName(getStfName);
		System.out.println("vo : " + vo);
		
		List<Staff> staffList = null;
		try {
			staffList = rightService.getStaffList(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("staffList : " + staffList);
		return staffList;
	}
}
