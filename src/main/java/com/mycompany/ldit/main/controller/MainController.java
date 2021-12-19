package com.mycompany.ldit.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.attendance.model.service.AttendanceService;
import com.mycompany.ldit.attendance.model.service.AttendanceServiceImpl;
import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.main.model.service.MainService;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;
import com.mycompany.ldit.staff.model.StaffServiceInterface;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.teamaim.model.vo.TeamAim;
import com.mycompany.ldit.work.model.servie.WorkService;
import com.mycompany.ldit.work.model.vo.Work;

@Controller
public class MainController {
	@Autowired
	private MainService MainService;
	@Autowired
	private AttendanceService attService;
	@Autowired
	private WorkService WorkService;
	@Autowired
	private StaffServiceInterface staffService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, HttpSession session) {
		String viewpage = "main";
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		
		try {
			//업무일정 들고오기
			List<Work> wvo = null;
			wvo = WorkService.getWorkListToday(loginUser.getStfNo());
			//mv.addObject("workList", wvo);
			mv.addObject("workList", wvo);
			
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
			mv.addObject("att", att);
			
			//쪽지즐겨찾기한 사람 데려오기
			List<Staff> likeStaffList = staffService.chooseLikeStaff(loginUser.getStfNo());
			mv.addObject("likeStaffList", likeStaffList);
			System.out.println("likeStaffList:"+likeStaffList);
			
			// 1년 내 부여된 연차
			int calAplT = attService.countAplTotal(loginUser.getStfNo());
			// 사용한 연차
			int calAplU = attService.countAplUse(loginUser.getStfNo());
			//사용가능한 연차
			int calApl = calAplT-calAplU;
			System.out.println("calApl:"+calApl);
			mv.addObject("calApl", calApl);
			
			WorkBreak wb = null;
			if (att != null) {
				// attNo설정하기
				int thisAttNo = att.getAttNo();

				// 매개변수로 사용할 attNo&stfNo 매핑
				Map<String, Object> mapMS = new HashMap<String, Object>();
				mapMS.put("stfNo", loginUser.getStfNo());
				mapMS.put("thisAttNo", thisAttNo);

				// 출퇴근 경과시간 읽어오기
				Map<String, Object> elapsedWTime = new HashMap<String, Object>();
				if (att.getAttEnd() != null) {
					elapsedWTime = attService.getElapsedWTime(mapMS);
					String todayHours = String.valueOf(elapsedWTime.get("EH"));
					String todayMinutes = String.valueOf(elapsedWTime.get("EM"));
					mv.addObject("todayHours", todayHours);
					mv.addObject("todayMinutes", todayMinutes);
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
	
	@RequestMapping(value = "/getalert.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ReceiveMsg> getAlert(HttpServletRequest request, HttpSession session) {
		List<ReceiveMsg> msgList = null;
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		try {
			msgList = MainService.getReceiveMsg(loginUser.getStfNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msgList;
	}
	
	//즐겨찾기 위한 직원정보창 열기
	@RequestMapping(value = "likestaff", method = RequestMethod.GET)
	public ModelAndView likeStaff(HttpSession session, ModelAndView mv) {
		mv.setViewName("msg/likestaff");
		
		List<Staff> allStaffList = staffService.getAllStaff();
		mv.addObject("allStaffList", allStaffList);
		return mv;	
	}
	
	//직원 즐겨찾기 ajax
	@RequestMapping(value = "deleteandlikestaff", method = RequestMethod.POST)
	@ResponseBody
	public int likeStaffAjax(HttpSession session, @RequestParam(value="hostStfNo") String hostingStfNo
			, @RequestParam(value="wantedStfNo") String wantingStfNo
			, @RequestParam(value="keyWordForChoose") String keyWord) {
		Map<String, Object> mapM = new HashMap<String, Object>();
		int result = -1;
		
		int hostStfNo = Integer.parseInt(hostingStfNo);
		int wantedStfNo = Integer.parseInt(wantingStfNo);
		mapM.put("hostStfNo", hostStfNo);
		mapM.put("wantedStfNo", wantedStfNo);
		
		System.out.println("직원 즐겨찾기 ajax");
		System.out.println("hostStfNo: "+hostStfNo+", wantedStfNo: "+wantedStfNo+", keyWordForChoose: "+keyWord);
		String filter = "추가";
		int resultDelete = staffService.deleteLike(mapM);
		if(resultDelete == 0 && keyWord.equals(filter)) {
			int resultInsert = staffService.insertLike(mapM);
				if(resultInsert>0) {
					result = 2; //삭제안하고 다시 인서트 성공
				} else {
					result = -2; //삭제안하고 인서트 실패
				}
		} else if(resultDelete > 0) {
			result = 1; //삭제 성공
		} else {
			result = -1; //삭제 실패
		}
		System.out.println(result);
		return result;	
	}
	
}