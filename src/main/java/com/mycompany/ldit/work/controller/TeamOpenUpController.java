package com.mycompany.ldit.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.team.model.service.TeamService;

@Controller("topen")
public class TeamOpenUpController {
	@Autowired
	private TeamService TeamService;
	
	@RequestMapping(value = "/teamadd", method = RequestMethod.GET)
	public ModelAndView getTeam(ModelAndView mv) {
		String viewpage = "team/team_add";
		Project vo = null;
		try {
			//pro_no 넘기는거 받아오기 전까지
			int pro_no = 1;
			vo = TeamService.getOneProject(pro_no);
			viewpage = "team/team_add";
			System.out.println("vo:" + vo);
			mv.addObject("getProject", vo);
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("url", "team_main");
		}
		mv.setViewName(viewpage);
		return mv;
	}
}