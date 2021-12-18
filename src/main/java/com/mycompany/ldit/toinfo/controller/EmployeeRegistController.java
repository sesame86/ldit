package com.mycompany.ldit.toinfo.controller;

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

@Controller
public class EmployeeRegistController {
	@Autowired
	private StaffService staffservice;
	
	@RequestMapping(value = "eregist", method = RequestMethod.GET)
    public ModelAndView eregist(ModelAndView mv) {
       mv.setViewName("employee/eregist");
       return mv;
    }
   
   @RequestMapping(value = "eregist", method=RequestMethod.POST)
   public ModelAndView eregist(Staff vo, @RequestParam("stfNo") int stfNo,
          @RequestParam("deptNo") int deptNo, @RequestParam("stfLvl") String stfLvl, @RequestParam("stfName") String stfName,
          @RequestParam("stfId") String stfId, @RequestParam("stfPasswd") String stfPasswd, @RequestParam("stfImg") String stfImg, @RequestParam("stfSign") String stfSign,
          @RequestParam("stfPhone") String stfPhone, @RequestParam("stfMail") String stfMail, @RequestParam("stfEnroll") String stfEnroll,
          HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr, ModelAndView mv) {
       int result=0;
       
       
       try {
          System.out.println(result);
          
          vo.setStfNo(stfNo);
          vo.setDeptNo(deptNo);
          vo.setStfLvl(stfLvl);
          vo.setStfName(stfName);
          vo.setStfId(stfId);
          vo.setStfPasswd(stfPasswd);
          vo.setStfImg(stfImg);
          vo.setStfSign(stfSign); 
          vo.setStfPhone(stfPhone);
          vo.setStfMail(stfMail);
          vo.setStfEnroll(stfEnroll);
          
          result = staffservice.eregist(vo);
          System.out.println(result);
          if(result==1) { 
             String msg = "회원 정보가 등록되었습니다.";
             rttr.addFlashAttribute("msg", msg);
             mv.setViewName("main");
          }else {
             String msg = "회원 정보 등록에 실패하였습니다.";
             rttr.addFlashAttribute("msg", msg);
             mv.setViewName("main");
          }
          
       } catch (Exception e) {
          e.printStackTrace();
       }
       return mv;
    }
}