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
public class TeamGoalUpdateController {
	@Autowired
	private TeamAimService TeamAimService;
	
	@RequestMapping(value = "/getUpdateGoal.do", method = RequestMethod.GET)
	@ResponseBody
	public TeamAim getUpdateGoal(HttpServletRequest request) {
		String teamIdStr = request.getParameter("teamId");
		int teamId = 0;
		if(teamIdStr != null) {
			teamId = Integer.parseInt(teamIdStr);
		}
		TeamAim taVo = null;
		try {
			taVo = TeamAimService.getUpdateGoal(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taVo;
	}
	@RequestMapping(value = "/goalupdate", method = RequestMethod.POST)
	public ModelAndView updateTeamGoal(ModelAndView mv, TeamAim tAimVo) {
		String viewpage = "redirect:teammain";
		int result = 0;
		System.out.println(tAimVo);
		try {
			result = TeamAimService.updateTeamGoal(tAimVo);
			if(result>0) {
				viewpage = "redirect:teammain";
				mv.addObject("msg", "팀의 목표를 등록하였습니다.");
			}else {
				viewpage = "redirect:teammain";
				mv.addObject("msg", "팀의 목표를 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
