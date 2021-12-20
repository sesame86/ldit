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
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.clientneeds.model.service.ClientNeedsService;
import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.service.TeamService;

@Controller
public class RequirementsListController {
	@Autowired
	private ClientNeedsService ClientNeedsService;
	@Autowired
	private TeamService TeamService;
	
	@RequestMapping(value = "/csneeds", method = RequestMethod.GET)
	public ModelAndView getNeedsList(ModelAndView mv, HttpSession session, @RequestParam(value="proNo", required = false) String prono) {
		String viewpage = "project/csneeds";
		List<ClientNeeds> urgentList = null;
		List<ClientNeeds> highList = null;
		List<ClientNeeds> normalList = null;
		List<ClientNeeds> lowList = null;
		int proNo = 41;
		try {
			//pro_no 넘기는거 받아오기 전까지
			if(prono == null) {
				proNo = 2;				
			} else {
				proNo = Integer.parseInt(prono);
			}
			System.out.println("proNo"+proNo);
			Staff loginUser = (Staff)session.getAttribute("loginUser");
			int rightNo = TeamService.getStaffRight(loginUser.getStfNo());
			mv.addObject("rightNo", rightNo);
			
			urgentList = ClientNeedsService.getUrgentList(proNo);
			highList = ClientNeedsService.getHighList(proNo);
			normalList = ClientNeedsService.getNormalList(proNo);
			lowList = ClientNeedsService.getLowList(proNo);
			viewpage = "project/csneeds";

			mv.addObject("proNo", proNo);
			mv.addObject("urgentList", urgentList);
			mv.addObject("highList", highList);
			mv.addObject("normalList", normalList);
			mv.addObject("lowList", lowList);
		}catch (Exception e) {
			//viewpage = "error/commonError";
			//mv.addObject("msg", "팀 개설에 문제가 생겼습니다.");
			//mv.addObject("url", "team_main");
		}
		mv.setViewName(viewpage);
		return mv;
	}
	@RequestMapping(value = "/getCSDetail.do", method = RequestMethod.GET)
	@ResponseBody
	public ClientNeeds getCSDetail(ModelAndView mv, HttpServletRequest request) {
		String cnIdStr = request.getParameter("cnId");
		int cnId = 0;
		if(cnIdStr != null) {
			cnId = Integer.parseInt(cnIdStr);
		}
		ClientNeeds cvo = null;
		try {
			cvo = ClientNeedsService.getCSDetail(cnId);
			mv.addObject("cvo", cvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cvo;
	}
}
