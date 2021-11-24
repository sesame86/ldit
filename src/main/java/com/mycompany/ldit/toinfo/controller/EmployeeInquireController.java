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
	
	@RequestMapping(value="einquire", method=RequestMethod.GET)
	public ModelAndView einquire(ModelAndView mv) {
		String viewpage ="";
		Staff vo = new Staff();
		List<Staff> orlist = null;
		try {
			viewpage="employee/einquire";
			orlist = staffService.einquire(vo);
			mv.addObject("orlist", orlist);
		} catch(Exception e) {
			mv.addObject("msg", "조직도를 불러올 때 문제가 발생했습니다.");
			mv.addObject("url", "einquire");
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
