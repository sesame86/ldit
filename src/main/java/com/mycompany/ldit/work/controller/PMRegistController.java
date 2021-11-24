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
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller("pmregist")
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
			, @RequestParam(value = "stfNo", required = false) int getStfNo) {
		
		System.out.println("getDeptName : " + getdeptName);
		System.out.println("getStfName : " + getStfName);
		System.out.println("getStfNo : " + getStfNo);
		
		Staff vo = new Staff();
		//vo.setDept_name(getdeptName);
		//vo.setStf_name(getStfName);
		//vo.setStf_no(getStfNo);
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
}