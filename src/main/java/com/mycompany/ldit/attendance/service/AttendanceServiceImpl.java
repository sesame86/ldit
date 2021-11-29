package com.mycompany.ldit.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.dao.AttendanceDao;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;

@Service("attService")
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDao attDao;

	@Override
	public int insertCheckin(int stfNo) {
		return attDao.insertCheckin(stfNo);
	}

	@Override
	public String getAttStart(int stfNo) {
		return attDao.getAttStart(stfNo);
	}

	@Override
	public int countAttStart(int stfNo) {
		return attDao.countAttStart(stfNo);
	}
	
	@Override
	public int updateCheckout(int stfNo) {
		return attDao.updateCheckout(stfNo);
	}

	@Override
	public String getAttEnd(int stfNo) {
		return attDao.getAttEnd(stfNo);
	}

	@Override
	public int insertRestin(int stfNo) {
		return attDao.insertRestin(stfNo);
	}

	@Override
	public WorkBreak getRestStart(int stfNo) {
		return attDao.getRestStart(stfNo);
	}

	@Override
	public int updateBrEnd(int brNo) {
		return attDao.updateBrEnd(brNo);
	}

	@Override
	public String getBrEnd(int brNo) {
		return attDao.getBrEnd(brNo);
	}

	@Override
	public String getLatestBrStart(int stfNo) {
		return attDao.getLatestBrStart(stfNo);
	}

	@Override
	public String getLatestBrEnd(int stfNo) {
		return attDao.getLatestBrEnd(stfNo);
	}
	

}
