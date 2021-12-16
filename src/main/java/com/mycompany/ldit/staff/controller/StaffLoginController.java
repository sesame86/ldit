package com.mycompany.ldit.staff.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.staff.model.StaffServiceInterface;
import com.mycompany.ldit.staff.model.vo.Staff;


// 로그인 화면
@Controller("login")
//@RequestMapping("/staff/*")
public class StaffLoginController {
	//로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(StaffLoginController.class);
	
	@Inject
	StaffServiceInterface staffService;
	
	// 로그인 화면
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	//로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute Staff vo, HttpSession session) {
		boolean result = staffService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true) {//로그인 성공
			//main.jsp 이동
			System.out.println("여기다");
			mav.setViewName("redirect:main");
			
			//단순히 JSP내용을 불러오고 싶으면
			// 새로고침 하면 로그인 
//			mav.setViewName("main");
//			mav.addObject("msg", "success");
		}else { //로그인 실패
			//login.jsp 이동.
			mav.setViewName("login");
			mav.addObject("msg", "failure");
		}
		return mav;	
	}
	
	//로그 아웃 처리
	
	
	
	

}
