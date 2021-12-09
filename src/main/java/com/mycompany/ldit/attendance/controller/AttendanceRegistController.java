package com.mycompany.ldit.attendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mycompany.ldit.attendance.model.service.AttendanceServiceImpl;
import com.mycompany.ldit.attendance.model.vo.WorkingHoursManage;
import com.mycompany.ldit.attendance.model.vo.Xiuxi;

@Controller
public class AttendanceRegistController {
	
	@Autowired
	private AttendanceServiceImpl attService;
	
	@RequestMapping(value="whmanage", method = RequestMethod.GET)
	public ModelAndView whmanageMethod(ModelAndView mv) {
		mv.setViewName("attendance/whmanage");
		
		
		WorkingHoursManage whm = attService.getWHM();
		List<Xiuxi> xiuxiList = attService.getXiuxiList();
	
		System.out.println("getWHM: "+ whm);
		
		mv.addObject("whm", whm);
		mv.addObject("xiuxiList", xiuxiList);
		return mv;
	}
	
	@RequestMapping(value="whmanage", method = RequestMethod.POST)
	public String updateWHMMethod(HttpServletRequest request) {
		
		String whmCode = request.getParameter("whm_type");
		String whmRestCode = request.getParameter("rest_type");
		System.out.println("whmCode: "+ whmCode);
		System.out.println("whmRestCode: "+whmRestCode);
		Map<String, Object> map1 = new HashMap<String, Object>();
		String varZero = "0";
		String varOne = "1";
		
		if(whmCode.equals(varZero)) {
			System.out.println("진입");
			map1.put("whmCode", whmCode);
			map1.put("whmRestCode", whmRestCode);
			int resultOfWHM = attService.updateWHM(map1);
			
			String zeroStart = request.getParameter("time_in");
			String zeroEnd = request.getParameter("time_out");
			System.out.println("zeroStart: "+zeroStart);
			System.out.println("zeroEnd: "+zeroEnd);
			
			String zeroStartFormat = zeroStart.replaceAll(":", "");
			String zeroEndFormat = zeroEnd.replaceAll(":", "");
			System.out.println(zeroStartFormat);
			System.out.println(zeroEndFormat);

			Map<String, Object> map2 = new HashMap<String, Object>();
			String[] zeroDay = request.getParameterValues("select_day");
			int resultOfReset =  attService.resetWHMZeroState();
			int resultOfWHMZeroTotal = 0;
			for (int i=0; i<zeroDay.length; i++) {
				String selectedDay = zeroDay[i];
				map2.put("zeroEndFormat", zeroEndFormat);
				map2.put("zeroStartFormat", zeroStartFormat);
				map2.put("selectedDay", selectedDay);
				int resultOfWHMZero = attService.updateWHMZero(map2);
				resultOfWHMZeroTotal += resultOfWHMZero;
			}
			
			System.out.println("고정근무제에서 resultOfWHMZeroTotal: "+resultOfWHMZeroTotal);
			System.out.println("고정근무제에서 resultOfWHM: "+resultOfWHM);
			System.out.println("고정근무제에서 resultOfReset: "+resultOfReset);
			
		} else if(whmCode.equals(varOne)) {
			map1.put("whmCode", whmCode);
			map1.put("whmRestCode", whmRestCode);
			int resultOfWHM = attService.updateWHM(map1);
			int weekHours = Integer.parseInt(request.getParameter("week_hours"));
			System.out.println("weekHours: "+weekHours);
			int resultOfWHMOne = attService.updateWHMOne(weekHours);
			System.out.println("유연근무제에서 resultOfWHM: "+resultOfWHM);
			System.out.println("유연근무제에서 resultOfWHMOne: "+resultOfWHMOne);
		}
		
		return "redirect:/whmanage";
	}
	
	@RequestMapping(value="xiuxiset", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String xiuxiSetMethod() {
		
		
		
		
		
		
		Gson gson = new Gson();
		String r = gson.toJson("");
		return r;
	}
	
	@RequestMapping(value="xiuxiRemove", method = RequestMethod.POST)
	public void xiuxiRemoveMethod(@RequestParam(value="checkedXiuxi[]") List<String> checkedXiuxi, HttpServletResponse response) throws IOException{
		response.setContentType("application/json; charset=utf-8");
		
		int resultOfRemoveXiuxi = -1;
		for(String checked : checkedXiuxi) {
			System.out.println(checked);
			int result = attService.deleteXiuxi(checked);
			resultOfRemoveXiuxi += result;
		}
		
		PrintWriter out = response.getWriter(); 
		out.println(resultOfRemoveXiuxi); 
		out.flush(); 
		out.close();
	}

}
