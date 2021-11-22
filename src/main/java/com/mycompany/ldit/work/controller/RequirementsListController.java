package com.mycompany.ldit.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.clientneeds.model.service.ClientNeedsService;
import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;

@Controller
public class RequirementsListController {
	@Autowired
	private ClientNeedsService ClientNeedsService;
	
	@RequestMapping(value = "/csneeds", method = RequestMethod.GET)
	public ModelAndView getNeedsList(ModelAndView mv) {
		String viewpage = "project/csneeds";
		List<ClientNeeds> urgentList = null;
		List<ClientNeeds> highList = null;
		List<ClientNeeds> normalList = null;
		List<ClientNeeds> lowList = null;
		try {
			//pro_no 넘기는거 받아오기 전까지
			int pro_no = 1;
			
			urgentList = ClientNeedsService.getUrgentList(pro_no);
			highList = ClientNeedsService.getHighList(pro_no);
			normalList = ClientNeedsService.getNormalList(pro_no);
			lowList = ClientNeedsService.getLowList(pro_no);
			viewpage = "project/csneeds";

			mv.addObject("urgentList", urgentList);
			mv.addObject("highList", highList);
			mv.addObject("normalList", normalList);
			mv.addObject("lowList", lowList);
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("url", "team_main");
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
