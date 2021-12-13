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
	
	@RequestMapping(value="eupdate2", method=RequestMethod.POST)
	public String eupdate(@RequestParam("stfId") String stfId, @RequestParam("deptNo") int deptNo
			, @RequestParam("stfLvl") String stfLvl, @RequestParam("stfPasswd") String stfPasswd
			, @RequestParam("stfPhone") String stfPhone, @RequestParam("stfMail") String stfMail
			, Staff staff) {
		String viewpage="main";
		System.out.println("deptNo:" + deptNo);
		System.out.println("stfId:" + stfId);
		System.out.println("stfLvl:" + stfLvl);
		staff.setStfId(stfId);
		staff.setDeptNo(deptNo);
		staff.setStfLvl(stfLvl);
		staff.setStfPasswd(stfPasswd);
		staff.setStfPhone(stfPhone);
		staff.setStfMail(stfMail);
		staffservice.eupdate(staff);
		return viewpage;
	}
}
