package com.mycompany.ldit.attendance.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
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
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.XiuxiApply;
import com.mycompany.ldit.staff.model.vo.Staff;

@SessionAttributes("msg")
@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceServiceImpl attService;

	@RequestMapping(value="attcheck", method = RequestMethod.GET)
	public ModelAndView attMainMethod(ModelAndView mv, HttpSession session) {
		mv.setViewName("attendance/attcheck");
		
		Staff loginUser = (Staff)session.getAttribute("loginUser");
		if(loginUser == null) {
			System.out.println("로그인정보 없음. 메인으로 이동");
			mv.setViewName("main");
			String msgLogout = "접근 권한이 없습니다. 로그인 정보를 확인해주세요.";
			mv.addObject("msg", msgLogout);
			return mv;
		}
		int stfNo = loginUser.getStfNo();
	
		System.out.println("받은 stfNo 값은? " + stfNo);
		String attStartFormat = null;
		attStartFormat = attService.getAttStart(stfNo);
		String attEndFormat = null;
		attEndFormat = attService.getAttEnd(stfNo);
		String restStartFormat = null;
		restStartFormat = attService.getLatestBrStart(stfNo);
		String restEndFormat = null;
		restEndFormat = attService.getLatestBrEnd(stfNo);
		if(restStartFormat != null) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("restStartFormat", restStartFormat);
			map1.put("stfNo", stfNo);
			int brNo = attService.getBrNo(map1);
			mv.addObject("brNo", brNo);
		}
		
		int calAplT = attService.countAplTotal(stfNo);
		int calAplU = attService.countAplUse(stfNo);
		
		mv.addObject("attStartFormat", attStartFormat);
		mv.addObject("attEndFormat", attEndFormat);
		mv.addObject("restStartFormat", restStartFormat);
		mv.addObject("restEndFormat", restEndFormat);
		
		mv.addObject("calAplT", calAplT);
		mv.addObject("calAplU", calAplU);
		
		return mv;
	}

	
	@RequestMapping(value="checkin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkinMethod(@RequestParam(value="stfNo", required=false) String stfno) throws IOException{
		
		System.out.println("checkinMethod진입");
		
		int stfNo = Integer.parseInt(stfno);
		System.out.println("출근 stfno"+stfno);
		System.out.println("출근 stfNo"+stfNo);
		
		int resultOfExist = attService.countAttStart(stfNo);
		System.out.println("resultOfExist: "+resultOfExist);
		String attStartFormat = "00:00:00";
		if(resultOfExist == 0) {
			int resultOfCheckin = attService.insertCheckin(stfNo);	
			if(resultOfCheckin > 0) {
				attStartFormat = attService.getAttStart(stfNo);
			}
		}
		
		
		Gson gson = new Gson();
		String r = gson.toJson(attStartFormat);
		return r;
		
	}
	
	@RequestMapping(value="checkout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String checkoutMethod(@RequestParam(value="stfNo", required=false) String stfno) {
		
		System.out.println("checkout메소드 진입");
		
		int stfNo = Integer.parseInt(stfno);
		int resultOfCheckout = attService.updateCheckout(stfNo);
		
		String attEndFormat = "00:00:00";
		if(resultOfCheckout == 1) {
			attEndFormat = attService.getAttEnd(stfNo);
		}
		
		Gson gson = new Gson();
		String r = gson.toJson(attEndFormat);
		return r;
	}
	
	@RequestMapping(value="restin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restinMethod(@RequestParam(value="stfNo", required=false) String stfno) {
		
		System.out.println("restIn메소드 진입");
		
		int stfNo = Integer.parseInt(stfno);
		int resultOfRestin = attService.insertRestin(stfNo);
		
		WorkBreak wb = null;
		if(resultOfRestin>0) {
			wb = attService.getRestStart(stfNo);
		}
		
		
		Gson gson = new Gson();
		String r = gson.toJson(wb);
		return r;	
	}
	
	
	@RequestMapping(value="restout", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restoutMethod(@RequestParam(value="brNo") String brno) {
		System.out.println("restOut메소드 진입");

		
		int brNo = Integer.parseInt(brno);
		
		int resultOfRestout = attService.updateBrEnd(brNo);
		
		String restEndFormat = "00:00:00";
		if(resultOfRestout>0){
			restEndFormat = attService.getBrEnd(brNo);
		}

		Gson gson = new Gson();
		String r = gson.toJson(restEndFormat);
		return r;	
	}
	
	@RequestMapping(value="restapply", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String restApplyMethod() {
		
		Gson gson = new Gson();
		String r = gson.toJson("");
		return r;
	}
	
	@RequestMapping(value="getXAList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> xiuxiApplyListMethod(@RequestParam(value="stfNo", required=false) String stfno
			,@RequestParam(value="currentPage", required=false) String currentpage
			,@RequestParam(value="keyValue", required=false) String keyValue){
		Map<String, Object> xaMap = new HashMap<String, Object>();
		
		int stfNo = Integer.parseInt(stfno);
		System.out.println("getXAList stfNo"+stfNo);
		int currentPage = 1;
		int limitInOnePage = 5;
		if(currentpage != null) {
			currentPage = Integer.parseInt(currentpage);
		}
		if(keyValue == null) {
			keyValue = "allAble";
		}
		
		//전체 게시글 수 
		int xaListCount = attService.countXAList(stfNo);
		//총 페이지 수 계산
		int maxPage = (int)((double)xaListCount / limitInOnePage + 0.9); 
		// 현재 페이지에 보여줄 시작 페이지 번호
		int startPage = (((int)((double)currentPage / limitInOnePage + 0.9)) - 1) * limitInOnePage + 1;
		int endPage = startPage + limitInOnePage - 1; 
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		//휴가신청 상세내역
		List<XiuxiApply> xiuxiApplyList = null;
		xiuxiApplyList = attService.getxiuxiApplyList(stfNo, currentPage, limitInOnePage, keyValue);
		
		System.out.println("xiuxiApplyList: "+xiuxiApplyList);
		
		xaMap.put("xiuxiApplyList", xiuxiApplyList);
		return xaMap;
	}
	
	
	

}
