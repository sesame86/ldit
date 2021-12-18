package com.mycompany.ldit.work.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.service.TeamService;
import com.mycompany.ldit.team.model.vo.Team;
import com.mycompany.ldit.teammember.model.service.TeamMemberService;
import com.mycompany.ldit.teammember.model.vo.TeamMember;

@Controller
public class TeamOpenUpController {
	@Autowired
	private TeamService TeamService;
	@Autowired
	private TeamMemberService TeamMemberService;
	
	@RequestMapping(value = "/teamadd", method = RequestMethod.GET)
	public ModelAndView getTeam(ModelAndView mv, HttpServletRequest request) {
		String viewpage = "team/team_add";
		Project vo = null;
		try {
			//pro_no 넘기는거 받아오기 전까지
			int proNo = 1;
			vo = TeamService.getOneProject(proNo);
			viewpage = "team/team_add";
			mv.addObject("getProject", vo);
			String update = request.getParameter("update");
			mv.addObject("update", update);
			if(update != null) {
				int updateInt = Integer.parseInt(update);
				Team tvo = new Team();
				List<Staff> stfList = null;
				tvo = TeamService.getTeamUpdate(updateInt);
				stfList = TeamMemberService.getTeamMemberUpdate(updateInt);
				mv.addObject("getUpdateTeam", tvo);
				mv.addObject("stfList", stfList);
			}
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("url", "team_main");
		}
		mv.setViewName(viewpage);
		return mv;
	}
	@RequestMapping(value = "/teamadd", method = RequestMethod.POST)
	public ModelAndView postTeam(ModelAndView mv, Team tvo, HttpServletRequest request) {
		String viewpage = "redirect:teammain";
		try {
			int result1 = 0;
			int result2 = 0;
			int result3 = 0;
			int getTeamId = 0;
			//int checkTM = -1;
			String update = request.getParameter("update");
			
			if(update != null) { //팀 수정
				int updateInt = Integer.parseInt(update);
				System.out.println(updateInt);
				tvo.setTeamId(updateInt);
				System.out.println(tvo);
				result1 = TeamService.updateTeam(tvo);
				for(int i=0; i<tvo.getStaffList().size(); i++) {
					TeamMember tmVo = new TeamMember();
					tmVo.setTeamId(updateInt);
					tmVo.setStfNo(tvo.getStaffList().get(i).getStfNo());
					int checkDupidTeamMember = TeamMemberService.checkDupidTeamMember(tmVo);
					if(checkDupidTeamMember == 0) { //삽입
						result3 = TeamMemberService.insertTeamMember(tmVo);
					}//이미 있으면 무시
				}
			}else { //팀 개설
				result1 = TeamService.insertTeam(tvo);
				getTeamId = TeamService.checkTeamId(tvo);
				if(getTeamId != 0) {
					for(int i=0; i<tvo.getStaffList().size(); i++) {
						TeamMember tmVo = new TeamMember();
						tmVo.setTeamId(getTeamId);
						tmVo.setStfNo(tvo.getStaffList().get(i).getStfNo());
						result3 = TeamMemberService.insertTeamMember(tmVo);
					}
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
	@RequestMapping(value = "/searchpm.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Staff> searchPM(HttpServletRequest request) {
		String searchPM = request.getParameter("searchPM");
		List<Staff> staffList = null;
		try {
			staffList = TeamService.searchPM(searchPM);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}
	@RequestMapping(value = "/searchbyno.do", method = RequestMethod.GET)
	@ResponseBody
	public Staff searchByNo(HttpServletRequest request) {
		String searchByNoStr = request.getParameter("searchByNo");
		int searchByNo = 0;
		if(searchByNoStr != null) {
			searchByNo = Integer.parseInt(searchByNoStr);
		}
		Staff staffVo = null;
		try {
			staffVo = TeamService.searchByNo(searchByNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffVo;
	}
}