package com.mycompany.ldit.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.main.model.service.MainService;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class MainController {
	@Autowired
	private MainService MainService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpSession session) {
		String viewpage = "main";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		
		try {
			//내정보 가져오기, 근태(attendance: att_start, att_end)
			//이름, 출근시간, 퇴근시간, 오늘 근무 시간(현재시간 - att_start)
			//System.out.println(loginUser.getStfNo());
			Attendance atVo = MainService.getAttendance(loginUser.getStfNo());
			//이거 왜 null오는지 확인해야함
			//System.out.println(atVo);
			
			//주간 근무시간, 월간 근무시간(date의 같은달의 총 근무시간)
			
			//진행중인 프로젝트 가져오기
			List<Project> pVo = MainService.getUserProject(loginUser.getStfNo());
			mv.addObject("projectVo", pVo);
			//쪽지 즐겨찾기
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
}