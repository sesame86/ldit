package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.ldit.teamaim.model.service.TeamAimService;

@Controller
public class TeamGoalRegistController {
	@Autowired
	private TeamAimService TeamAimService;
	
	@RequestMapping(value = "/gstatuscheck.do", method = RequestMethod.GET)
	@ResponseBody
	public String goalStatusCheck(HttpServletRequest request) {
		String teamIdStr = request.getParameter("teamId");
		int teamId = 0;
		if(teamIdStr != null) {
			teamId = Integer.parseInt(teamIdStr);
		}
		String status = null;
		try {
			status = TeamAimService.goalStatusCheck(teamId);
			if(status == null) {
				status = "noGoal";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(status);
		return status;
	}
}
