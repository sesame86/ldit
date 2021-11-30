package com.mycompany.ldit.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.ldit.work.model.servie.WorkService;

@Controller
public class BusinessDeleteController {
	@Autowired
	private WorkService WorkService;
	
	@RequestMapping(value = "/deletework.do", method = RequestMethod.GET)
	@ResponseBody
	public int deleteWork(HttpServletRequest request) {
		String workIdStr = request.getParameter("workId");
		int workId = 0;
		if(workIdStr != null) {
			workId = Integer.parseInt(workIdStr);
		}
		System.out.println(workId);
		int result = 0;
		try {
			result = WorkService.deleteWork(workId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}