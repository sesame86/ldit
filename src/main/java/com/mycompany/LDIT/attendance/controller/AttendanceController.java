package com.mycompany.LDIT.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttendanceController {
	
	
	@RequestMapping(value="/attendance/attcheck")
	public String attcheckMethod(Model m) {
		return "attendance/attcheck";
	}
}
