package com.mycompany.ldit.sendmsg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.ldit.sendmsg.model.SendMsgService;

@Controller
public class SendMsgDeleteController {
	@Autowired
	private SendMsgService sendmsgservice;
	
	@RequestMapping(value="smdelete", method=RequestMethod.GET)
	public String sendBox(@RequestParam("sMNo") int sMNo) {
		String viewpage="redirect:/sendBox";
		System.out.println("삭제한 보낸 쪽지 번호: " + sMNo);
		sendmsgservice.deleteMsg(sMNo);
		return viewpage;
	}
}
