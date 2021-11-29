package com.mycompany.ldit.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.ldit.clientneeds.model.service.ClientNeedsService;

@Controller
public class RequirementsDisableController {
	@Autowired
	private ClientNeedsService ClientNeedsService;
	
	@RequestMapping(value = "/disablecs.do", method = RequestMethod.GET)
	@ResponseBody
	public int disableCS(HttpServletRequest request) {
		String cnIStr = request.getParameter("cnId");
		int cnId = 0;
		if(cnIStr != null) {
			cnId = Integer.parseInt(cnIStr);
		}
		int result = 0;
		String msg = null;
		try {
			result = ClientNeedsService.disableCS(cnId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}