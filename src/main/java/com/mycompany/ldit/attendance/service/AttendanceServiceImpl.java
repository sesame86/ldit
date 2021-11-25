package com.mycompany.ldit.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.dao.AttendanceDao;

@Service("attService")
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDao attDao;

	@Override
	public int insertCheckin(int stfNo) throws Exception {
		return attDao.insertCheckin(stfNo);
	}

	@Override
	public String getAttStart(int stfNo) throws Exception {
		return attDao.getAttStart(stfNo);
	}

	@Override
	public int countAttStart(int stfNo) throws Exception {
		return attDao.countAttStart(stfNo);
	}
	

}
