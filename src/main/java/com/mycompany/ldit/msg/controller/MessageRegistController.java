package com.mycompany.ldit.msg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.ldit.msg.model.MsgService;
import com.mycompany.ldit.msg.model.vo.Msg;
import com.mycompany.ldit.receivemsg.model.ReceiveMsgService;
import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.SendMsgService;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;
import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller
public class MessageRegistController {
	@Autowired
	private MsgService msgservice;
	
	@Autowired
	private SendMsgService sendmsgservice;
	
	@Autowired
	private ReceiveMsgService receivemsgservice;
	
	@Autowired
	private StaffService staffservice;
	
	@RequestMapping(value="sendMsg", method=RequestMethod.GET)
	public ModelAndView sendMsg(ModelAndView mv) {
		mv.setViewName("msg/sendMsg");
		return mv;
	}
	
	@RequestMapping(value="sendMsg", method=RequestMethod.POST)
	public ModelAndView sendMsg(Msg msg, SendMsg sendmsg, ReceiveMsg receivemsg, Staff staff, @RequestParam("mTitle") String mTitle, @RequestParam("sStfId") String sStfId
			,@RequestParam("mContent") String mContent, @RequestParam("rStfId") String rStfId, @RequestParam("stfNo") int stfNo
			,  HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr, HttpSession session, ModelAndView mv) {
		int result = 0;
		int result2 = 0;
		int result3 = 0;
		
		int no = 0; // 쪽지 번호
		int no2 = 0; // 사원 번호
		
		System.out.println("no값 :" + no);
		System.out.println("no2값 :" + no2);
		
		try {
			System.out.println("result=" + result);
			System.out.println("result2=" + result2);
			System.out.println("result3=" + result3);
			
			msg.setmTitle(mTitle);
			msg.setmContent(mContent);
			
			result=msgservice.sendMsg(msg);
			
			no = msgservice.checkMNo(msg);
			System.out.println("쪽지 번호는 " + no);
			
			no2 = staffservice.searchNo(rStfId);
			System.out.println("받은 직원의 사원 번호는 " + no2);
			
			sendmsg.setStfNo(stfNo);
			sendmsg.setmNo(no);
			sendmsg.setrStfId(rStfId);
			result2=sendmsgservice.sendBox(sendmsg);
			
			receivemsg.setStfNo(no2);
			receivemsg.setmNo(no);
			receivemsg.setrMCheck(0);
			receivemsg.setsStfId(sStfId);
			result3=receivemsgservice.receiveBox(receivemsg);
			
			System.out.println("result:" + result);
			System.out.println("result2:" + result2);
			System.out.println("result3:" + result3);
			mv.setViewName("main");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}