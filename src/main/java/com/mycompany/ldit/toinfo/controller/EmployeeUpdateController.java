package com.mycompany.ldit.toinfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class EmployeeUpdateController {
	@Autowired
	private StaffService staffservice;
	
	@RequestMapping(value="eupdate", method=RequestMethod.GET)
	public ModelAndView profile(ModelAndView mv, HttpSession session) {
		String viewpage="";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		try {
			viewpage="employee/eupdate";
			mv.addObject("loginUser", staffservice.profile(loginUser));
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("session :" + session.getAttribute("loginUser"));
		mv.setViewName(viewpage);
		return mv;
	}
	
	@RequestMapping(value="eupdate2", method=RequestMethod.GET)
	public String eupdate(@RequestParam("stfId") String stfId, @RequestParam("deptName") String deptName
			, @RequestParam("stfLvl") String stfLvl, @RequestParam("stfPasswd") String stfPasswd
			, @RequestParam("stfPhone") String stfPhone, @RequestParam("stfMail") String stfMail) {
		String viewpage="main";
		staffservice.eupdate(stfId);
		return viewpage;
	}
}
