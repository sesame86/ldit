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

@Controller
public class TeamOpenUpController {
	@Autowired
	private TeamService TeamService;
	private TeamMemberService TeamMemberService;
	
	@RequestMapping(value = "/teamadd", method = RequestMethod.GET)
	public ModelAndView getTeam(ModelAndView mv) {
		String viewpage = "team/team_add";
		Project vo = null;
		try {
			//pro_no 넘기는거 받아오기 전까지
			int pro_no = 1;
			vo = TeamService.getOneProject(pro_no);
			viewpage = "team/team_add";
			mv.addObject("getProject", vo);
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("url", "team_main");
		}
		mv.setViewName(viewpage);
		return mv;
	}
	@RequestMapping(value = "/teamadd", method = RequestMethod.POST)
	public ModelAndView postTeam(ModelAndView mv, Team tvo) {
		String viewpage = "redirect:teammain";
		
		System.out.println("tvo: " + tvo);
		//20211123 진행중
		try {
			int result1 = 0;
			int result2 = 0;
			result1 = TeamService.insertTeam(tvo);
			System.out.println(result1);
			result2 = TeamMemberService.insertTeamMember(tvo);
			System.out.println(result2);
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