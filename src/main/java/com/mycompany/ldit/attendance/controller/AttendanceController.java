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
import com.mycompany.ldit.attendance.model.vo.WHManage;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.WorkHomeApply;
import com.mycompany.ldit.attendance.model.vo.Xiuxi;
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

		return mv;
	}

	// 개인 근무관리 메인페이지 - 초기 정보 세팅
	@RequestMapping(value = "attmaingetdata", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String attMainGetDataMethod(HttpSession session) {
		Gson gson = new Gson();
		Map<String, Object> mapM = new HashMap<String, Object>();

		// stfNo 받아오기
		Staff loginUser = (Staff) session.getAttribute("loginUser");

		int stfNo = loginUser.getStfNo();

		// 오늘 날짜 Attendance 테이블 읽어오기 + 총 휴식시간 포함
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
				mapM.put("elapsedWTime", elapsedWTAfter);
			}

			// 오늘 날짜 WORK_BREAK 읽어오기
			wb = attService.getLatestWB(mapMS);

		}
		if (wb != null) {
			mapM.put("wb", wb);
		}

		// 1년 내 부여된 연차
		int calAplT = attService.countAplTotal(stfNo);
		mapM.put("calAplT", calAplT);

		// 사용가능한 연차
		int calAplU = attService.countAplUse(stfNo);
		mapM.put("calAplU", calAplU);

		// xiuxiList읽어오기
		List<Xiuxi> xiuxiList = attService.getXiuxiList();
		if (xiuxiList != null) {
			mapM.put("xiuxiList", xiuxiList);
		}

		String result = gson.toJson(mapM);
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

		// 퇴근시간 update + 휴식 강제 종료도 함께하기
		int resultOfCheckout = attService.updateCheckout(stfNo);

		// 퇴근시각 읽어오기
		if (resultOfCheckout > 0) {
			String attEndFormat = attService.getAttEnd(stfNo);
			result = attEndFormat;
		}

		return result;
	}

	// 휴식시작 ajax
	@RequestMapping(value = "restin", method = RequestMethod.POST)
	@ResponseBody
	public String restinMethod(@RequestParam(value = "stfNo") String stfno) {

		int stfNo = Integer.parseInt(stfno);
		String result = "";

		// 휴식시작 insert
		int resultOfRestin = attService.insertRestin(stfNo);

		if (resultOfRestin > 0) {
			WorkBreak wb = attService.getRestStart(stfNo);
			Gson gson = new Gson();
			result = gson.toJson(wb);
		}

		return result;
	}

	// 휴식종료 ajax
	@RequestMapping(value = "restout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restoutMethod(@RequestParam(value = "brNo") String brno, HttpSession session) {
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
		if (restEndFormat != null && !restEndFormat.equals("00:00:00")) {
			Staff loginUser = (Staff) session.getAttribute("loginUser");
			int stfNo = loginUser.getStfNo();

			String elapsedRTAfter = calRestTime(stfNo, wb.getAttNo());
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

	// 휴가등록 form
	@RequestMapping(value = "restapply", method = RequestMethod.POST)
	public ModelAndView restApplyMethod(ModelAndView mv, HttpSession session,
			@RequestParam(value = "xiuNo") String xiuNo, @RequestParam(value = "xaStart") String xastart,
			@RequestParam(value = "xaEnd") String xaend) {
		mv.setViewName("attendance/attmain");
		Map<String, Object> mapM = new HashMap<String, Object>();

		Staff loginUser = (Staff) session.getAttribute("loginUser");
		int stfNo = loginUser.getStfNo();
		String xaStart = xastart.replaceAll("-", "");
		String xaEnd = xaend.replaceAll("-", "");

		mapM.put("stfNo", stfNo);
		mapM.put("xiuNo", xiuNo);
		mapM.put("xaStart", xaStart);
		mapM.put("xaEnd", xaEnd);

		System.out.println(mapM);

		int result = attService.insertXiuxiApply(mapM);

		if (result > 0) {
			// attService.update();
		}

		mv.addObject("chooseID", "article_c");
		return mv;
	}

	// 재택등록 form
	@RequestMapping(value = "whomeapply", method = RequestMethod.POST)
	public ModelAndView whomeApplyMethod(ModelAndView mv, HttpSession session,
			@RequestParam(value = "whStart") String whstart, @RequestParam(value = "whEnd") String whend) {
		mv.setViewName("attendance/attmain");
		Map<String, Object> mapM = new HashMap<String, Object>();
		System.out.println("재택등록 컨트롤러 진입");

		Staff loginUser = (Staff) session.getAttribute("loginUser");
		int stfNo = loginUser.getStfNo();
		String whStart = whstart.replaceAll("-", "");
		String whEnd = whend.replaceAll("-", "");

		mapM.put("stfNo", stfNo);
		mapM.put("whStart", whStart);
		mapM.put("whEnd", whEnd);

		int result = attService.insertWorkHomeApply(mapM);
		System.out.println("result?" + result);
		mv.addObject("chooseID", "article_d");
		return mv;
	}

	// 휴가등록 상세내역 ajax
	@RequestMapping(value = "getxalist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String xiuxiApplyListMethod(@RequestParam(value = "stfNo") String stfno,
			@RequestParam(value = "currentPage", required = false) String currentpage,
			@RequestParam(value = "keyValue", required = false) String keyValue) {
		Map<String, Object> mapM = new HashMap<String, Object>();

		int stfNo = Integer.parseInt(stfno);
		int currentPage = 1;
		int limitInOnePage = 5;
		if (currentpage != null) {
			currentPage = Integer.parseInt(currentpage);
		}
		if (keyValue == null || keyValue.equals("")) {
			keyValue = "allAble";
		}
		// 전체 게시글 수
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("stfNo", stfNo);
		map1.put("keyValue", keyValue);
		int xaListCount = attService.countXAList(map1);
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

		mapM.put("xiuxiApplyList", xiuxiApplyList);
		mapM.put("currentPage", currentPage);
		mapM.put("maxPage", maxPage);
		mapM.put("startPage", startPage);
		mapM.put("endPage", endPage);

		Gson gson = new Gson();
		String r = gson.toJson(mapM);
		return r;
	}

	// 재택근무 ajax
	@RequestMapping(value = "getwhomelist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getWhomeListMethod(@RequestParam(value = "stfNo") String stfno,
			@RequestParam(value = "currentPage", required = false) String currentpage,
			@RequestParam(value = "keyValue", required = false) String keyValue) {
		Map<String, Object> mapM = new HashMap<String, Object>();

		int stfNo = Integer.parseInt(stfno);
		int currentPage = 1;
		int limitInOnePage = 5;
		if (currentpage != null) {
			currentPage = Integer.parseInt(currentpage);
		}
		if (keyValue == null || keyValue.equals("")) {
			keyValue = "allAble";
		}
		// 전체 게시글 수
		Map<String, Object> mapS = new HashMap<String, Object>();
		mapS.put("stfNo", stfNo);
		mapS.put("keyValue", keyValue);
		int whomeListCount = attService.countWhomeList(mapS);
		// 총 페이지 수 계산
		int maxPage = (int) ((double) whomeListCount / limitInOnePage + 0.9);
		// 현재 페이지에 보여줄 시작 페이지 번호
		int startPage = (((int) ((double) currentPage / limitInOnePage + 0.9)) - 1) * limitInOnePage + 1;
		int endPage = startPage + limitInOnePage - 1;
		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 재택근무 상세내역
		List<WorkHomeApply> whomeList = null;
		whomeList = attService.getWhomeList(stfNo, currentPage, limitInOnePage, keyValue);
		System.out.println(whomeList);
		mapM.put("whomeList", whomeList);
		mapM.put("currentPage", currentPage);
		mapM.put("maxPage", maxPage);
		mapM.put("startPage", startPage);
		mapM.put("endPage", endPage);

		Gson gson = new Gson();
		String r = gson.toJson(mapM);
		return r;
	}

	// 근무내역 ajax
	@RequestMapping(value = "getattlist", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getAttListMethod(@RequestParam(value = "stfNo") String stfno,
			@RequestParam(value = "currentPage", required = false) String currentpage) {
		Map<String, Object> mapM = new HashMap<String, Object>();

		int stfNo = Integer.parseInt(stfno);
		int currentPage = 1;
		int limitInOnePage = 5;
		if (currentpage != null) {
			currentPage = Integer.parseInt(currentpage);
		}
		// 전체 게시글 수
		int attListCount = attService.countAttList(stfNo);
		// 총 페이지 수 계산
		int maxPage = (int) ((double) attListCount / limitInOnePage + 0.9);
		// 현재 페이지에 보여줄 시작 페이지 번호
		int startPage = (((int) ((double) currentPage / limitInOnePage + 0.9)) - 1) * limitInOnePage + 1;
		int endPage = startPage + limitInOnePage - 1;
		if (maxPage < endPage) {
			endPage = maxPage;
		}
		
		//근무제도 코드 가져오기
		WHManage whm = attService.getWHM();
		String restCode = whm.getWhmRestCode();

//		// 근무내역 상세내역
		List<Attendance> attList = null;
		attList = attService.getAttList(stfNo, currentPage, limitInOnePage);
		
		mapM.put("attList", attList);
		mapM.put("restCode", restCode);
		mapM.put("currentPage", currentPage);
		mapM.put("maxPage", maxPage);
		mapM.put("startPage", startPage);
		mapM.put("endPage", endPage);

		Gson gson = new Gson();
		String r = gson.toJson(mapM);
		return r;
	}

	private String calRestTime(int stfNo, int attNo) {
		// parameter map형태로 만들기
		Map<String, Object> mapS = new HashMap<String, Object>();
		mapS.put("stfNo", stfNo);
		mapS.put("thisAttNo", String.valueOf(attNo));

		// 총 휴식시간 DB에서 계산해 오기
		Map<String, Object> elapsedRTime = attService.getElapsedRTime(mapS);

		// 결과를 보기 좋게 바꾸기
		String elapsedRTAfter = myFormatedTime(elapsedRTime);

		return elapsedRTAfter;
	}

	private String myFormatedTime(Map<String, Object> elapsedTime) {
		String hours = String.valueOf(elapsedTime.get("EH"));
		String minutes = String.valueOf(elapsedTime.get("EM"));
		String seconds = String.valueOf(elapsedTime.get("ES"));
		String elapsedTBefore = hours + ":" + minutes + ":" + seconds;
		String elapsedTAfter = elapsedTBefore.replace(" ", "");
		System.out.println("elapsedRTime: " + elapsedTAfter);
		return elapsedTAfter;
	}

}
