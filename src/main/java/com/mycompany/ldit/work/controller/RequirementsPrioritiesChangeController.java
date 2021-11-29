package com.mycompany.ldit.work.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.clientneeds.model.service.ClientNeedsService;
import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;

@Controller
public class RequirementsPrioritiesChangeController {
	@Autowired
	private ClientNeedsService ClientNeedsService;
	
	@RequestMapping(value = "/updatecs.do", method = RequestMethod.POST)
	public ModelAndView updateCS(ModelAndView mv, ClientNeeds cvo) {
		String viewpage = "redirect:csneeds";
		try {
			int result = ClientNeedsService.updateCS(cvo);
		}catch (Exception e) {
			e.getStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}