package com.mycompany.ldit.attendance.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mycompany.ldit.attendance.service.AttendanceService;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceService attService;
	
	@RequestMapping(value="testcut", method=RequestMethod.GET)
	public ModelAndView testMethodGet(ModelAndView mv) throws IOException{
		mv.setViewName("attendance/testcut");
		
		return mv;
	}

	@RequestMapping(value="attcheck", method = RequestMethod.GET)
	public ModelAndView attMainMethod(ModelAndView mv) {
		mv.setViewName("attendance/attcheck");
		return mv;
	}

	
	@RequestMapping(value="checkin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkinMethod(/*@RequestParam("stfNo") int stfNo*/) throws IOException{
		
		System.out.println("checkinMethod진입");
		
		//임시 사원번호
		int stfNo = 1;
		
		
		int result = attService.insertCheckin(stfNo);
		
		
		
		
		String r ="";
		return r;
		
	}
	
	@RequestMapping(value="checkout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkoutMethod(@RequestParam("stfNo") int stfno/*, @RequestParam("whmCode") int whmCode*/) {
		
		
		String r ="";
		return r;
	}
	
	
	
	

}
