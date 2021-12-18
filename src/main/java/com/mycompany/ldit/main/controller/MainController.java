package com.mycompany.ldit.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.attendance.model.service.AttendanceService;
import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.main.model.service.MainService;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class MainController {
	@Autowired
	private MainService MainService;
	@Autowired
	private AttendanceService attService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpSession session) {
		String viewpage = "main";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		
		try {
			//내정보 가져오기, 근태(attendance: att_start, att_end)
			//이름, 출근시간, 퇴근시간, 오늘 근무 시간(현재시간 - att_start)
			//System.out.println(loginUser.getStfNo());
			//Attendance atVo = MainService.getAttendance(loginUser.getStfNo());
			//이거 왜 null오는지 확인해야함
			//System.out.println(atVo);
			//mv.addObject("atVo", atVo);
			//주간 근무시간, 월간 근무시간(date의 같은달의 총 근무시간)
			
			
			Map<String, Object> mapM = new HashMap<String, Object>();
			//setInterval용도 date 읽어오기
			String attStart = null;
			attStart = attService.getAttStart(loginUser.getStfNo());
			mv.addObject("attStart", attStart);
			//퇴근시각 읽어오기
			String attEndFormat = null;
			attEndFormat = attService.getAttEnd(loginUser.getStfNo());
			mv.addObject("attEndFormat", attEndFormat);
			
			// 오늘 날짜 Attendance 테이블 읽어오기 + 총 휴식시간 포함
			Attendance att = null;
			att = attService.getTodayAttendance(loginUser.getStfNo());
			mapM.put("att", att);

			WorkBreak wb = null;
			if (att != null) {
				// attNo설정하기
				int thisAttNo = att.getAttNo();

				// 매개변수로 사용할 attNo&stfNo 매핑
				Map<String, Object> mapMS = new HashMap<String, Object>();
				mapMS.put("stfNo", loginUser.getStfNo());
				mapMS.put("thisAttNo", thisAttNo);

				// setInterval용도 date 읽어오기
				String attStartDateTime = attService.getAttStartDateTime(mapMS);
				mapM.put("attStartDateTime", attStartDateTime);

				// 출퇴근 경과시간 읽어오기
				Map<String, Object> elapsedWTime = new HashMap<String, Object>();
				if (att.getAttEnd() != null) {
					elapsedWTime = attService.getElapsedWTime(mapMS);
					String hours = String.valueOf(elapsedWTime.get("EH"));
					String minutes = String.valueOf(elapsedWTime.get("EM"));
					String seconds = String.valueOf(elapsedWTime.get("ES"));
					String elapsedWTBefore = hours + ":" + minutes + ":" + seconds;
					String elapsedWTAfter = elapsedWTBefore.replace(" ", "");
					System.out.println("elapsedWTime: " + elapsedWTAfter);
					mapM.put("elapsedWTime", elapsedWTAfter);
					mv.addObject("elapsedWTime", elapsedWTime);
				}

				// 오늘 날짜 WORK_BREAK 읽어오기
				wb = attService.getLatestWB(mapMS);
				mv.addObject("wb", wb);
			}
			
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