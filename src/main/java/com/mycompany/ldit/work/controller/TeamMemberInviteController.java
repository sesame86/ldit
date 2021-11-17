package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.service.TeamService;

@Controller("tmemberinvite")
public class TeamMemberInviteController {
	@Autowired
	private TeamService TeamService;
	
	@RequestMapping(value = "/searchtmem.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Staff> searchPM(HttpServletRequest request) {
		String searchTmem = request.getParameter("searchTmem");
		List<Staff> staffList = null;
		try {
			staffList = TeamService.searchTeamMember(searchTmem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}
}