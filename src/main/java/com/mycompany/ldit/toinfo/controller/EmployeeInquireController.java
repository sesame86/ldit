package com.mycompany.ldit.toinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller("einquire")
public class EmployeeInquireController {

	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value="organization", method=RequestMethod.GET)
	public ModelAndView organization(ModelAndView mv) {
		String viewpage ="";
		Staff vo = new Staff();
		vo.setStf_name("백건호");
		List<Staff> orlist = null;
		try {
			viewpage="organization/organization";
			orlist=staffService.organization(vo);
			mv.addObject("orlist", orlist);
		} catch(Exception e) {
			mv.addObject("msg", "조직도를 불러올 때 문제가 발생했습니다.");
			mv.addObject("url", "organization");
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
