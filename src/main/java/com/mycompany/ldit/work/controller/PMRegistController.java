package com.mycompany.ldit.work.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.right.model.service.RightService;
import com.mycompany.ldit.right.model.vo.Right;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class PMRegistController {
	@Autowired
	RightService rightService;
	
	@RequestMapping(value = "/pmregist", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "right/rightgrant";
	}
	
	@RequestMapping(value = "/pmregist.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Staff> getStaffList(HttpServletRequest request
			, @RequestParam(value = "deptName", required = false) String getdeptName
			, @RequestParam(value = "stfName", required = false) String getStfName
			, @RequestParam(value = "stfNo", defaultValue = "0") int getStfNo) {
		
		System.out.println("getDeptName : " + getdeptName);
		System.out.println("getStfName : " + getStfName);
		System.out.println("getStfNo : " + getStfNo);
		
		Staff vo = new Staff();
		vo.setDeptName(getdeptName);
		vo.setStfName(getStfName);
		vo.setStfNo(getStfNo);
		System.out.println("vo : " + vo);
		
		List<Staff> staffList = null;
		try {
			staffList = rightService.getStaffList(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("staffList : " + staffList);
		return staffList;
	}
	
	@RequestMapping(value = "/insertPm.do", method = RequestMethod.POST)
	public ModelAndView insertPm(ModelAndView mv, @RequestParam("stfNo") int rightSno) {
		System.out.println("stfNo : " + rightSno);
		String viewpage = "redirect:pmregist";
		int result = 0;
		System.out.println(rightSno);
		try {
			result = rightService.insertPm(rightSno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}