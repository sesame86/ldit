package com.mycompany.ldit.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.dao.AttendanceDao;

@Service("attService")
public class AttendanceService {
	
	@Autowired
	private AttendanceDao attDao;
	
	
	

}
