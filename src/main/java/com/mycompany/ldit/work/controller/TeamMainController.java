package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.team.model.service.TeamService;
import com.mycompany.ldit.team.model.vo.Team;
import com.mycompany.ldit.teamaim.model.service.TeamAimService;
import com.mycompany.ldit.teamaim.model.vo.TeamAim;

@Controller
public class TeamMainController {
	@Autowired
	private TeamService TeamService;
	
	@Autowired
	private TeamAimService TeamAimService;
	
	@RequestMapping(value = "/teammain", method = RequestMethod.GET)
	public ModelAndView teamMain(ModelAndView mv) {
		String viewpage = "team/team_main";
		List<Team> voList = null;
		try {
			//pro_no 넘기는거 받아오기 전까지
			int pro_no = 1;
			
			voList = TeamService.getOneProjectTeam(pro_no);
			viewpage = "team/team_main";
			mv.addObject("getTeam", voList);
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("url", "team_main");
		}
		mv.setViewName(viewpage);
		return mv;
	}
	@RequestMapping(value = "/getteamgoal.do", method = RequestMethod.GET)
	@ResponseBody
	public List<TeamAim> getTeamGoal(HttpServletRequest request) {
		String teamIdStr = request.getParameter("teamId");
		int teamId = 0;
		if(teamIdStr != null) {
			teamId = Integer.parseInt(teamIdStr);
		}
		List<TeamAim> teamAimList = null;
		try {
			teamAimList = TeamAimService.getTeamGoal(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teamAimList;
	}
}