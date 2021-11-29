package com.mycompany.ldit.work.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.clientneeds.model.service.ClientNeedsService;
import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;

@Controller
public class RequirementsRegistController {
	@Autowired
	private ClientNeedsService ClientNeedsService;
	
	@RequestMapping(value = "/csadd", method = RequestMethod.GET)
	public String getCS(Model m, HttpServletRequest request) {
		String proNo = request.getParameter("prono");
		if(proNo != null) {
			m.addAttribute("proNo", proNo);
		}
		return "project/csadd";
	}
	@RequestMapping(value = "/csadd", method = RequestMethod.POST)
	public ModelAndView insertCS(ModelAndView mv, ClientNeeds cvo) {
		String viewpage = "redirect:csneeds";
		System.out.println(cvo);
		try {
			System.out.println("진입");
			int result = ClientNeedsService.insertCS(cvo);
			System.out.println(result);
		}catch (Exception e) {
			e.getStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
