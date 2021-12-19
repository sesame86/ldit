package com.mycompany.ldit.toinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
	
	@RequestMapping(value = "edelete2", method=RequestMethod.GET)
	public String edelete(@RequestParam("stfNo") int stfNo){
		String viewpage="redirect:/edelete";
		System.out.println("삭제할 직원 번호: "+stfNo);
		staffservice.edelete(stfNo);
		
		return viewpage;
	}
}
