package com.mycompany.ldit.toinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class EmployeeDeleteController {
	@Autowired
	private StaffService staffservice;
	
	@RequestMapping(value="edelete", method=RequestMethod.GET)
	public ModelAndView einquire(ModelAndView mv) {
		String viewpage="";
		Staff vo = new Staff();
		List<Staff> elist = null;
		try {
			viewpage="employee/edelete";
			elist=staffservice.einquire(vo);
			mv.addObject("elist", elist);
		} catch(Exception e) {
			mv.addObject("msg", "전체 직원 정보를 불러오지 못 했습니다.");
			mv.addObject("url", "edelete");
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
