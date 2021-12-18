package com.mycompany.ldit.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.msg.model.MsgService;
import com.mycompany.ldit.msg.model.vo.Msg;

@Controller()
public class SendMessageInquireController {
	@Autowired
	private MsgService msgservice;
	
	@RequestMapping(value="sendBox", method=RequestMethod.GET)
	public ModelAndView sendMsgCheck(ModelAndView mv) {
		String viewpage="";
		Msg msg = new Msg();
		List<Msg> mlist = null;
		try {
			viewpage="msg/sendBox";
			mlist=msgservice.sendMsgCheck(msg);
			System.out.println("mlist:" + mlist);
			mv.addObject("mlist", mlist);
		} catch(Exception e) {
			mv.addObject("msg", "보낸 쪽지함을 불러올 때 문제가 발생했습니다.");
			mv.addObject("url", "sendBox");
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
