package com.mycompany.ldit.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.ldit.work.model.servie.WorkService;
import com.mycompany.ldit.work.model.vo.Work;

@Controller
public class BusinessManagementController {
	@Autowired
	private WorkService WorkService;
	
	@RequestMapping(value = "/getworkdetail.do", method = RequestMethod.GET)
	@ResponseBody
	public Work getWorkDetial(HttpServletRequest request) {
		String workIdStr = request.getParameter("workId");
		int workId = 0;
		if(workIdStr != null) {
			workId = Integer.parseInt(workIdStr);
		}
		Work wvo = null;
		try {
			wvo = WorkService.getWorkDetial(workId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wvo;
	}
}