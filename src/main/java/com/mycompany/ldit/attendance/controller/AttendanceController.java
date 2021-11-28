package com.mycompany.ldit.attendance.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.service.AttendanceServiceImpl;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceServiceImpl attService;
	
	@RequestMapping(value="testcut", method=RequestMethod.GET)
	public ModelAndView testMethodGet(ModelAndView mv, @RequestParam(value="stfNo", required=false) int stfNo) throws IOException{
		mv.setViewName("attendance/testcut");
	
		
		return mv;
	}

	@RequestMapping(value="attcheck", method = RequestMethod.GET)
	public ModelAndView attMainMethod(ModelAndView mv/*, @RequestParam(value="stfNo", required=false) int stfNo*/) {
		mv.setViewName("attendance/attcheck");
		
		//임시
		int stfNo = 20213333;
		
		String attStartFormat = null;
		attStartFormat = attService.getAttStart(stfNo);
		String attEndFormat = null;
		attEndFormat = attService.getAttEnd(stfNo);
		String restStartFormat = null;
		restStartFormat = attService.getLatestBrStart(stfNo);
		String restEndFormat = null;
		restEndFormat = attService.getLatestBrEnd(stfNo);
		
		mv.addObject("attStartFormat", attStartFormat);
		mv.addObject("attEndFormat", attEndFormat);
		mv.addObject("restStartFormat", restStartFormat);
		mv.addObject("restEndFormat", restEndFormat);
		
		return mv;
	}

	
	@RequestMapping(value="checkin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkinMethod(/*@RequestParam(value="stfNo", required=false) int stfNo*/) throws IOException{
		
		System.out.println("checkinMethod진입");
		
		//임시
		int stfNo = 20213333;
		
		int resultOfExist = attService.countAttStart(stfNo);
		System.out.println("resultOfExist: "+resultOfExist);
		String attStartFormat = "00:00:00";
		if(resultOfExist == 0) {
			int resultOfCheckin = attService.insertCheckin(stfNo);	
			if(resultOfCheckin > 0) {
				attStartFormat = attService.getAttStart(stfNo);
			}
		}
		
		
		Gson gson = new Gson();
		String r = gson.toJson(attStartFormat);
		return r;
		
	}
	
	@RequestMapping(value="checkout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkoutMethod(/*@RequestParam(value="stfNo", required=false) int stfNo*/) {
		
		System.out.println("checkout메소드 진입");
		
		//임시
		int stfNo = 20213333;
		
		
		int resultOfCheckout = attService.updateCheckout(stfNo);
		
		String attEndFormat = "00:00:00";
		if(resultOfCheckout == 1) {
			attEndFormat = attService.getAttEnd(stfNo);
		}
		
		Gson gson = new Gson();
		String r = gson.toJson(attEndFormat);
		return r;
	}
	
	@RequestMapping(value="restin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restinMethod(/*@RequestParam(value="stfNo", required=false) int stfNo*/) {
		
		System.out.println("restIn메소드 진입");
		
		//임시
		int stfNo = 20213333;
		
		int resultOfRestin = attService.insertRestin(stfNo);
		
		WorkBreak wb = null;
		if(resultOfRestin>0) {
			wb = attService.getRestStart(stfNo);
		}
		
		
		Gson gson = new Gson();
		String r = gson.toJson(wb);
		return r;	
	}
	
	
	@RequestMapping(value="restout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restoutMethod(/*@RequestParam(value="stfNo", required=false) int stfNo, @RequestParam(value="brNo", required=false) int brNo*/) {
		
		System.out.println("restOut메소드 진입");
		
		//임시
		int brNo = 1;
		
		int resultOfRestout = attService.updateBrEnd(brNo);
		
		String restEndFormat = "00:00:00";
		if(resultOfRestout>0){
			restEndFormat = attService.getBrEnd(brNo);
		}
		
		Gson gson = new Gson();
		String r = gson.toJson("restEndFormat");
		return r;	
	}

}
