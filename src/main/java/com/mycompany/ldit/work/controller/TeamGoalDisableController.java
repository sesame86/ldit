package com.mycompany.ldit.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.ldit.teamaim.model.service.TeamAimService;

@Controller
public class TeamGoalDisableController {
	@Autowired
	private TeamAimService TeamAimService;
	
	@RequestMapping(value = "/disablegoal.do", method = RequestMethod.GET)
	@ResponseBody
	public int disableTeamGoal(HttpServletRequest request) {
		String teamIdStr = request.getParameter("teamId");
		int teamId = 0;
		if(teamIdStr != null) {
			teamId = Integer.parseInt(teamIdStr);
		}
		int result = 0;
		String msg = null;
		try {
			result = TeamAimService.disableTeamGoal(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}