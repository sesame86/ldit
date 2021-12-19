package com.mycompany.ldit.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.ldit.msg.model.MsgService;
import com.mycompany.ldit.msg.model.vo.Msg;
import com.mycompany.ldit.receivemsg.model.ReceiveMsgService;

@Controller()
public class MessageDetailedInquireController {
	@Autowired
	private MsgService msgservice;
	
	@Autowired
	private ReceiveMsgService receivemsgservice;
	
	@RequestMapping(value="checkMsg", method=RequestMethod.GET)
	public ModelAndView sendMsgCheck(@RequestParam("mNo") int mNo, ModelAndView mv) {
		String viewpage="";
		List<Msg> mlist = null;
		System.out.println("mNo:" + mNo);
		
		try {
			receivemsgservice.updateCheck(mNo);
			
			mlist = msgservice.checkMsg(mNo);
			viewpage="msg/msgInformation";
			mv.addObject("mlist", mlist);
			System.out.println("mlist2:" + mlist);
		} catch(Exception e) {
			e.printStackTrace();
		}
		mv.setViewName(viewpage);
		return mv;
	}
}
