package com.mycompany.ldit.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.attendance.service.AttendanceService;

@Controller("attController")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attService;
	
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
