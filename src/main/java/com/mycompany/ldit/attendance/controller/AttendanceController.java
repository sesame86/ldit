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
	public ModelAndView testMethodGet(ModelAndView mv,HttpServletRequest request, HttpServletResponse response) throws IOException{
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
	public String checkinMethod(HttpServletRequest request, HttpServletResponse response, @RequestParam("stfNo") int stfno) throws IOException{
		//response.setContentType("application/json; charset=utf-8");
		
		System.out.println("checkinMethod진입");
		//근태일련번호
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter attnoFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
		int attNo = Integer.parseInt(String.valueOf(dt.format(attnoFormat)));
		System.out.println("attNo: "+attNo);
		
		//출근시간
		Timestamp attStart = Timestamp.valueOf(dt);
		
		//출근 근태코드
		int whCode = 0;
		
		//임시 아이디
		System.out.println("stfno:"+stfno);
		int stfNo;
		try {
			stfNo = stfno;
		} catch (NumberFormatException e) {
			stfNo = 1111;
		}
		
		Map<String, Object> mapCheckin = new HashMap<String, Object>();	
		mapCheckin.put("attNo", attNo);
		mapCheckin.put("attStart", attStart);
		mapCheckin.put("stfNo", stfNo);
		mapCheckin.put("whCode", "ㄷㄷㄷ");
		
	//	int result = attService.insertCheckin(mapCheckin);
		String r = "돌아가자";
		Gson gson = new Gson();
		r = gson.toJson(mapCheckin);
		System.out.println(r);
		return r;
//		response.getWriter().append(r);
//		response.getWriter().flush();
//		response.getWriter().close();
		
	}
	
	
	
	
	
	

}
