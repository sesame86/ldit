package com.mycompany.ldit.toinfo.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.ldit.staff.model.StaffService;
import com.mycompany.ldit.staff.model.vo.Staff;

@Controller("eregist")
public class EmployeeRegistController {
	@Autowired
	private StaffService staffservice;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public ModelAndView join(ModelAndView mv) {
		mv.setViewName("join");
		return mv;
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public ModelAndView join(Staff staff, @RequestParam("stfNo") int stfNo, @RequestParam("deptNo") int deptNo, @RequestParam("stfLvl") String stfLvl
			, @RequestParam("stfName") String stfName, @RequestParam("stfId") String stfId, @RequestParam("stfPasswd") String stfPasswd
			, @RequestParam("stfImg") String stfImg, @RequestParam("stfSign") String stfSign, @RequestParam("stfPhone") String stfPhone
			, @RequestParam("stfMail") String stfMail, @RequestParam("stfEnroll") Date stfEnroll
			, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr, ModelAndView mv) {
		int result = 0;
		try {
			System.out.println("직원 등록 컨트롤러1 : " + result);
			staff.setStfNo(stfNo);
			staff.setDeptNo(deptNo);
			staff.setStfLvl(stfLvl);
			staff.setStfName(stfName);
			staff.setStfId(stfId);
			staff.setStfPasswd(stfPasswd);
			staff.setStfImg(stfImg);
			staff.setStfSign(stfSign);
			staff.setStfPhone(stfPhone);
			staff.setStfMail(stfMail);
			staff.setStfEnroll(stfEnroll);
			result=staffservice.join(staff);
			
			System.out.println(staff);
			System.out.println("직원 등록 컨트롤러2 : " + result);
			
			if(result == 1) {
				String msg = "직원 등록이 완료되었습니다.";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/");
			} else {
				String msg = "직원 등록에 실패했습니다.";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
}
