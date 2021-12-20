package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.vo.Staff;
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
	public ModelAndView teamMain(ModelAndView mv, HttpSession session, @RequestParam(value="proNo") String prono) {
		String viewpage = "team/team_main";
		List<Team> voList = null;
		try {
			//pro_no 넘기는거 받아오기 전까지
			int proNo = 1;
			if(prono == null) {
				proNo = 2;				
			} else {
				proNo = Integer.parseInt(prono);
			}
			System.out.println("팀 메인 호출proNo"+proNo);
			mv.addObject("proNo",proNo);
			//0:PM, 1:TM, 2:팀원
			Staff loginUser = (Staff)session.getAttribute("loginUser");
			int rightNo = TeamService.getStaffRight(loginUser.getStfNo());
			//System.out.println(rightNo);
			if(rightNo == 0 || rightNo == 1) {
				//System.out.println("진입1");
				//PM은 프로젝트에 속한 팀 전체 조회, TM은 프로젝트에 속한 팀 전체 조회
				voList = TeamService.getOneProjectTeam(proNo);
				//System.out.println("1 "+voList);
			}else if(rightNo == 2) {
				//System.out.println("진입2");
				//팀원은 프로젝트에 속한 팀중에서 자신이 속한 팀 조회
				Team tvo = new Team();
				Staff svo = new Staff();
				tvo.setProNo(proNo);
				svo.setStfNo(loginUser.getStfNo());
				tvo.setStaff(svo);
				voList = TeamService.getTeamMemberTeamList(tvo);
				//System.out.println("2 "+voList);
			}//권한에 속하지 않으면 아예 팀 메인 화면 접속하는 버튼이 안보임
			viewpage = "team/team_main";
			mv.addObject("getTeam", voList);
			mv.addObject("rightNo", rightNo);
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("check", "no");
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