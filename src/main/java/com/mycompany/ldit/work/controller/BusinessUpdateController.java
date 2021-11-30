package com.mycompany.ldit.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.work.model.servie.WorkService;
import com.mycompany.ldit.work.model.vo.Work;

@Controller
public class BusinessUpdateController {
	@Autowired
	private WorkService WorkService;
	
	@RequestMapping(value = "/updatework", method = RequestMethod.POST)
	public ModelAndView updateWork(ModelAndView mv, HttpServletRequest request, Work wvo) {
		String viewpage = "redirect:workmain";
		int result = 0;
		try {
			result = WorkService.updateWork(wvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}