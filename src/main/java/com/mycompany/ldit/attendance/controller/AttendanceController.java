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
import com.mycompany.ldit.attendance.service.AttendanceServiceImpl;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceServiceImpl attService;
	
	@RequestMapping(value="testcut", method=RequestMethod.GET)
	public ModelAndView testMethodGet(ModelAndView mv, @RequestParam(value="stfNo", required=false) int stfNo) throws IOException{
		mv.setViewName("attendance/testcut");
		
		//String attStartFormat = attService.getAttStart(stfNo);
		
		return mv;
	}

	@RequestMapping(value="attcheck", method = RequestMethod.GET)
	public ModelAndView attMainMethod(ModelAndView mv) {
		mv.setViewName("attendance/attcheck");
		return mv;
	}

	
	@RequestMapping(value="checkin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkinMethod(@RequestParam(value="stfNo", required=false) int stfNo) throws IOException{
		
		System.out.println("checkinMethod진입");
		
		//임시 사원번호
		stfNo = 1;
		
		int result1 = -1;
		int result2 = -1;
		String attStartFormat = "00:00:00";
		
		//데이터가 없을 때만 insert 하기
		try {
			result1 = attService.countAttStart(stfNo);
			System.out.println(result1+" + result1 at AttendanceController");
			if(result1 == 0) {
				result2 = attService.insertCheckin(stfNo);		
				System.out.println(result2+" + result2 at AttendanceController");
				if(result2 > 0) {
					attStartFormat = attService.getAttStart(stfNo);		
					System.out.println(attStartFormat+" + attStartFormat at AttendanceController");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Gson gson = new Gson();
		String r = gson.toJson(attStartFormat);
		return r;
		
	}
	
	@RequestMapping(value="checkout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkoutMethod(@RequestParam(value="stfNo", required=false) int stfNo/*, @RequestParam("whmCode") int whmCode*/) {
		
		
		String r ="";
		return r;
	}
	
	
	
	

}
