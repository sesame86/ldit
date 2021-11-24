package com.mycompany.ldit.work.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.teamaim.model.service.TeamAimService;
import com.mycompany.ldit.teamaim.model.vo.TeamAim;

@Controller
public class TeamGoalRegistController {
	@Autowired
	private TeamAimService TeamAimService;
	
	@RequestMapping(value = "/gstatuscheck.do", method = RequestMethod.GET)
	@ResponseBody
	public TeamAim goalStatusCheck(HttpServletRequest request) {
		String teamIdStr = request.getParameter("teamId");
		int teamId = 0;
		if(teamIdStr != null) {
			teamId = Integer.parseInt(teamIdStr);
		}
		TeamAim status = null;
		try {
			status = TeamAimService.goalStatusCheck(teamId);
			if(status == null) {
				status = new TeamAim();
				status.setAimFinish('Y');
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@RequestMapping(value = "/goaladd", method = RequestMethod.POST)
	public ModelAndView insertTeamGoal(ModelAndView mv, TeamAim tAimVo) {
		String viewpage = "redirect:teammain";
		int result = 0;
		try {
			result = TeamAimService.insertTeamGoal(tAimVo);
			if(result>0) {
				viewpage = "redirect:teammain";
				//mv.addObject("msg", "팀의 목표를 등록하였습니다.");
			}else {
				viewpage = "redirect:teammain";
				//mv.addObject("msg", "팀의 목표를 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
