package com.mycompany.ldit.attendance.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.attendance.model.vo.WorkingHoursManage;
import com.mycompany.ldit.attendance.service.AttendanceServiceImpl;

@Controller
public class AttendanceRegistController {
	
	@Autowired
	private AttendanceServiceImpl attService;
	
	@RequestMapping(value="whmanage", method = RequestMethod.GET)
	public ModelAndView whmanageMethod(ModelAndView mv) {
		mv.setViewName("attendance/whmanage");
		
		
		WorkingHoursManage whm = attService.getWHM();
	
		System.out.println("getWHM: "+ whm);
		
		mv.addObject("whm", whm);
		return mv;
	}
	
	@RequestMapping(value="whmanage", method = RequestMethod.POST)
	public String updateWHMMethod(HttpServletRequest request) {
		
		String whmCode = request.getParameter("whm_type");
		String whmRestCode = request.getParameter("rest_type");
		Map<String, Object> map1 = new HashMap<String, Object>();
		if(whmCode=="0") {
			map1.put("whmCode", whmCode);
			map1.put("whmRestCode", whmRestCode);
			int resultOfWHM = attService.updateWHM(map1);
			
			
			
			
			
			
		} else {
			map1.put("whmCode", whmCode);
			map1.put("whmRestCode", whmRestCode);
			int resultOfWHM = attService.updateWHM(map1);
			int weekHours = Integer.parseInt(request.getParameter("weekHours"));
			int resultOfWHMOne = attService.updateWHMOne(weekHours);
		}
		
		
		
		return "attendance/whmanage";
	}
	
	

}
