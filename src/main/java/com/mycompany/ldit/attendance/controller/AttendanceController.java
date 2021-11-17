package com.mycompany.ldit.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceController {
	
	@RequestMapping(value="attcheck", method = RequestMethod.GET)
	public ModelAndView attMainMethod(ModelAndView mv) {
		mv.setViewName("attendance/attcheck");
		
		return mv;
	}
	
	@RequestMapping(value="checkin", method = RequestMethod.POST)
	@ResponseBody
	public void checkinMethod() {
		
	}
	

}
