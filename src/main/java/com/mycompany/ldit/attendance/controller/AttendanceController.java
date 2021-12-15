package com.mycompany.ldit.attendance.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mycompany.ldit.attendance.model.service.AttendanceServiceImpl;
import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.XiuxiApply;
import com.mycompany.ldit.staff.model.vo.Staff;

@SessionAttributes("msg")
@Controller
public class AttendanceController {

	@Autowired
	private AttendanceServiceImpl attService;

	// 개인 근무관리 메인페이지
	@RequestMapping(value = "attmain", method = RequestMethod.GET)
	public ModelAndView attMainMethod(ModelAndView mv, HttpSession session) {
		mv.setViewName("attendance/attmain");

		// 로그인 없으면 메인으로 이동
		Staff loginUser = (Staff) session.getAttribute("loginUser");
		if (loginUser == null) {
			System.out.println("로그인정보 없음. 메인으로 이동");
			mv.setViewName("main");
			String msgNoAuth = "접근 권한이 없습니다. 로그인 정보를 확인해주세요.";
			mv.addObject("msg", msgNoAuth);
			return mv;
		}
		return mv;
	}

	// 개인 근무관리 메인페이지 - 초기 정보 세팅
	@RequestMapping(value = "attmaingetdata", method = RequestMethod.POST)
	@ResponseBody
	public String attMainGetDataMethod(HttpSession session) {
		Gson gson = new Gson();
		Map<String, Object> mapM = new HashMap<String, Object>();

		// stfNo 받아오기
		Staff loginUser = (Staff) session.getAttribute("loginUser");
		if (loginUser == null) {
			String msgNoAuth = "접근 권한이 없습니다. 로그인 정보를 확인해주세요.";
			mapM.put("msg", msgNoAuth);
			return gson.toJson(mapM);
		}
		int stfNo = loginUser.getStfNo();

		// 오늘 날짜 Attendance 테이블 읽어오기
		Attendance att = null;
		att = attService.getTodayAttendance(stfNo);
		System.out.println("화면진입 시 att폼의 결과는?: " + att);
		mapM.put("att", att);

		WorkBreak wb = null;
		if (att != null) {
			// attNo설정하기
			int thisAttNo = att.getAttNo();

			// 매개변수로 사용할 attNo&stfNo 매핑
			Map<String, Object> mapMS = new HashMap<String, Object>();
			mapMS.put("stfNo", stfNo);
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
			}

			// 오늘 날짜 WORK_BREAK 읽어오기
			wb = attService.getLatestWB(mapMS);
			System.out.println("화면진입 시 wb폼의 결과는?: " + wb);
		}
		mapM.put("wb", wb);

		// 1년 내 부여된 연차
		int calAplT = attService.countAplTotal(stfNo);
		mapM.put("calAplT", calAplT);

		// 사용가능한 연차
		int calAplU = attService.countAplUse(stfNo);
		mapM.put("calAplU", calAplU);

		String result = gson.toJson(mapM);
		System.out.println(result);
		return result;
	}

	// 출근등록 ajax
	@RequestMapping(value = "checkin", method = RequestMethod.POST)
	@ResponseBody
	public String checkinMethod(@RequestParam(value = "stfNo") String stfno) throws IOException {

		int stfNo = Integer.parseInt(stfno);
		String result = "";

		// 동일 날짜 출근 여부 확인
		int resultOfExist = attService.countAttStart(stfNo);

		String attStartFormat = attService.getAttStart(stfNo);
		if (attStartFormat == null) {
			int resultOfCheckin = attService.insertCheckin(stfNo); // 출근등록
			if (resultOfCheckin > 0) {
				attStartFormat = attService.getAttStart(stfNo); // 출근시각 읽어오기
				result = attStartFormat;
			} else {
				result = ""; // 출근 insert 실패
			}
		} else {
			result = attStartFormat;
		}

		return result;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	@ResponseBody
	public String checkoutMethod(@RequestParam(value = "stfNo") String stfno) {

		int stfNo = Integer.parseInt(stfno);
		String result = "";
		
		//퇴근시간 update
		int resultOfCheckout = attService.updateCheckout(stfNo);

		//퇴근시각 읽어오기
		if (resultOfCheckout > 0) {
			String attEndFormat = attService.getAttEnd(stfNo);
			result = attEndFormat;
		}

		return result;
	}

	@RequestMapping(value = "restin", method = RequestMethod.POST)
	@ResponseBody
	public String restinMethod(@RequestParam(value = "stfNo") String stfno) {
		
		int stfNo = Integer.parseInt(stfno);
		String result = "";
		
		//휴식시작 insert
		int resultOfRestin = attService.insertRestin(stfNo);

		if (resultOfRestin > 0) {
			WorkBreak wb = attService.getRestStart(stfNo);
			result = wb.toString();
		}
		
		return result;
	}

	@RequestMapping(value = "restout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restoutMethod(@RequestParam(value = "brNo") String brno, HttpSession session) {
		System.out.println("restOut메소드 진입");
		Map<String, Object> mapM = new HashMap<String, Object>();

		int brNo = Integer.parseInt(brno);

		int resultOfRestout = attService.updateBrEnd(brNo);

		String restEndFormat = "00:00:00";
		WorkBreak wb = null;
		if (resultOfRestout > 0) {
			// restEndFormat = attService.getBrEnd(brNo);
			wb = attService.getWorkBreak(brNo);
			restEndFormat = wb.getBrEnd();
			mapM.put("restEndFormat", restEndFormat);
		}

		// 총 휴식 시간 계산하기
		Map<String, Object> elapsedRTime = new HashMap<String, Object>();
		if (restEndFormat != null) {
			Staff loginUser = (Staff) session.getAttribute("loginUser");
			int stfNo = loginUser.getStfNo();

			Map<String, Object> mapS = new HashMap<String, Object>();
			mapS.put("stfNo", stfNo);
			String attStartDateOnly = String.valueOf(wb.getAttNo());
			mapS.put("attNo", attStartDateOnly);
			elapsedRTime = attService.getElapsedRTime(mapS);
			String hours = String.valueOf(elapsedRTime.get("EH"));
			String minutes = String.valueOf(elapsedRTime.get("EM"));
			String seconds = String.valueOf(elapsedRTime.get("ES"));
			String elapsedRTBefore = hours + ":" + minutes + ":" + seconds;
			String elapsedRTAfter = elapsedRTBefore.replace(" ", "");
			System.out.println("elapsedRTime: " + elapsedRTAfter);
			mapM.put("elapsedRTime", elapsedRTAfter);
		}

		// 총 휴식 시간 계산하기
//		Map<String, Object> elapsedRTime = new HashMap<String, Object>();
//		 if() {
//			 elapsedRTime = attService.getElapsedRTime(mapMS);
//			 System.out.println("화면진입 시 elapsedRTime: "+elapsedRTime);
//			 String hours = String.valueOf(elapsedRTime.get("EH"));
//			 String minutes = String.valueOf(elapsedRTime.get("EM"));
//			 String seconds = String.valueOf(elapsedRTime.get("ES"));
//			 String elapsedRTBefore = hours + ":" + minutes + ":" + seconds;
//			 String elapsedRTAfter = elapsedRTBefore.replace(" ", "");
//			 System.out.println("elapsedRTime: "+elapsedRTAfter);
//			 mapM.put("elapsedRTime", elapsedRTAfter);			 
//		 }

		Gson gson = new Gson();
		String r = gson.toJson(mapM);
		return r;
	}

	@RequestMapping(value = "restapply", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restApplyMethod() {

		Gson gson = new Gson();
		String r = gson.toJson("");
		return r;
	}

	@RequestMapping(value = "getXAList", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String xiuxiApplyListMethod(@RequestParam(value = "stfNo", required = false) String stfno,
			@RequestParam(value = "currentPage", required = false) String currentpage,
			@RequestParam(value = "keyValue", required = false) String keyValue) {
		Map<String, Object> xaMap = new HashMap<String, Object>();

		System.out.println("keyValue?" + keyValue);
		int stfNo = Integer.parseInt(stfno);
		System.out.println("getXAList stfNo" + stfNo);
		int currentPage = 1;
		int limitInOnePage = 5;
		if (currentpage != null) {
			currentPage = Integer.parseInt(currentpage);
		}
		if (keyValue == null || keyValue.equals("")) {
			keyValue = "allAble";
		}
		System.out.println("keyValue after?" + keyValue);
		// 전체 게시글 수
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("stfNo", stfNo);
		map1.put("keyValue", keyValue);
		int xaListCount = attService.countXAList(map1);
		System.out.println("xaListCount: " + xaListCount);
		// 총 페이지 수 계산
		int maxPage = (int) ((double) xaListCount / limitInOnePage + 0.9);
		// 현재 페이지에 보여줄 시작 페이지 번호
		int startPage = (((int) ((double) currentPage / limitInOnePage + 0.9)) - 1) * limitInOnePage + 1;
		int endPage = startPage + limitInOnePage - 1;
		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 휴가신청 상세내역
		List<XiuxiApply> xiuxiApplyList = null;
		xiuxiApplyList = attService.getxiuxiApplyList(stfNo, currentPage, limitInOnePage, keyValue);

		System.out.println("xiuxiApplyList: " + xiuxiApplyList);

		xaMap.put("xiuxiApplyList", xiuxiApplyList);
		xaMap.put("currentPage", currentPage);
		xaMap.put("maxPage", maxPage);
		xaMap.put("startPage", startPage);
		xaMap.put("endPage", endPage);

		Gson gson = new Gson();
		String r = gson.toJson(xaMap);
		return r;
		// https://java119.tistory.com/51
		// https://velog.io/@minsangk/%EC%BB%A4%EC%84%9C-%EA%B8%B0%EB%B0%98-%ED%8E%98%EC%9D%B4%EC%A7%80%EB%84%A4%EC%9D%B4%EC%85%98-Cursor-based-Pagination-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
	}

}
