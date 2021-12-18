package com.mycompany.ldit.attendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mycompany.ldit.attendance.model.service.AttendanceServiceImpl;
import com.mycompany.ldit.attendance.model.vo.WHManage;
import com.mycompany.ldit.attendance.model.vo.Xiuxi;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class AttendanceRegistController {
	
	@Autowired
	private AttendanceServiceImpl attService;
	
	@RequestMapping(value="whmanage", method = RequestMethod.GET)
	public ModelAndView whmanageMethod(ModelAndView mv, HttpSession session) {
		mv.setViewName("attendance/whmanage");
		
		Staff loginUser = (Staff) session.getAttribute("loginUser");
		int authAble = loginUser.getDeptNo();
		if(authAble != 3) {
			mv.setViewName("main");
			String authMsg = "접근 권한이 없습니다";
			mv.addObject("authMsg", authMsg);
			return mv;
		}
		
		WHManage whm = attService.getWHM();
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
	
	@RequestMapping(value="ckDuplXiuNo", method = RequestMethod.POST)
	@ResponseBody
	public int ckDuplXiuNo(@RequestParam(value="xiuNo") String xiuNo) {
		int result = -1;
		System.out.println("진입함. xiuNo: "+xiuNo);
		//xiuNo가 이미 존재하는지 확인
		result = attService.countXiuNo(xiuNo);
		System.out.println("result: "+result);
		return result;
	}
	
	@RequestMapping(value="xiuxiset", method = RequestMethod.POST)
	public String xiuxiSetMethod(HttpServletRequest request) {
		Map<String, Object> mapM = new HashMap<String, Object>();
		
		String xiuNo = request.getParameter("xiu_no");
		String xiuReason = request.getParameter("xiu_reason");
		int xiuAPL = Integer.parseInt(request.getParameter("xiu_apl_yesno"));
		
		mapM.put("xiuNo", xiuNo);
		mapM.put("xiuReason", xiuReason);
		mapM.put("xiuAPL", xiuAPL);
		System.out.println("mapM: "+mapM);
		
		int result = attService.insertXiuxi(mapM);
		System.out.println("attService.insertXiuxi(mapM)의 값은"+result);
		return "redirect:/whmanage";
	}
	
	@RequestMapping(value="xiuxiremove", method = RequestMethod.POST)
	public void xiuxiRemoveMethod(@RequestParam(value="checkedXiuxi[]") List<String> checkedXiuxi, HttpServletResponse response) throws IOException{
		response.setContentType("application/json; charset=utf-8");
		
		int resultOfRemoveXiuxi = -1;
		for(String checked : checkedXiuxi) {
			System.out.println("checkedd의 값: "+checked);
			int result = attService.deleteXiuxi(checked);
			resultOfRemoveXiuxi += result;
		}
		
		PrintWriter out = response.getWriter(); 
		out.println(resultOfRemoveXiuxi); 
		out.flush(); 
		out.close();
	}
	

}
