package com.mycompany.ldit.attendance.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.dao.AttendanceDao;

@Service("attService")
public class AttendanceService {
	
	@Autowired
	private AttendanceDao attDao;
	
	public int insertCheckin(Map<String, Object> mapCheckin) {
		return attDao.insertCheckin(mapCheckin);
	}
	

}
