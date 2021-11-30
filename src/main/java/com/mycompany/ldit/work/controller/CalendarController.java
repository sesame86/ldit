package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.work.model.servie.WorkService;
import com.mycompany.ldit.work.model.vo.Work;

@Controller
public class CalendarController {
	@Autowired
	private WorkService WorkService;

	@RequestMapping(value = "/workmain", method = RequestMethod.GET)
	public ModelAndView getWorkList(ModelAndView mv,HttpSession session, HttpServletRequest request) {
		String viewpage = "work/workmain";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		List<Work> wvo = null;
		try {
			wvo = WorkService.getWorkList(loginUser.getStfNo());
			//mv.addObject("workList", wvo);
			request.setAttribute("workList", wvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
	@RequestMapping(value = "/workadd", method = RequestMethod.POST)
	public ModelAndView insertWork(ModelAndView mv, Work wvo, HttpSession session) {
		String viewpage = "redirect:workmain";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		wvo.setStfNo(loginUser.getStfNo());
		try {
			int result = 0;
			result = WorkService.insertWork(wvo);
		}catch (Exception e) {
			e.getStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}