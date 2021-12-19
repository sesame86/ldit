package com.mycompany.ldit.receivemsg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.ldit.receivemsg.model.ReceiveMsgService;

@Controller
public class ReceiveMsgDeleteController {
	@Autowired
	private ReceiveMsgService receivemsgservice;
	
	@RequestMapping(value="rmdelete", method=RequestMethod.GET)
	public String receiveBox(@RequestParam("rMNo") int rMNo) {
		String viewpage="redirect:/receiveBox";
		System.out.println("삭제한 받은 쪽지 번호: " + rMNo);
		receivemsgservice.deleteMsg(rMNo);
		return viewpage;
	}
}
