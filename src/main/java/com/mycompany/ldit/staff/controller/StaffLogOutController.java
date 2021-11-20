package com.mycompany.ldit.staff.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.StaffServiceInterface;

@Controller("logout.do")
public class StaffLogOutController {
	
	@Inject
	StaffServiceInterface staffService;
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		staffService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("msg", "logout");
		return mav;
	}

}
