package com.mycompany.ldit.attendance.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.dao.AttendanceDao;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.WorkingHoursManage;

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

	@Override
	public int getBrNo(Map<String, Object> map1) {
		return attDao.getBrNo(map1);
	}

	@Override
	public int countAplTotal(int stfNo) {
		return attDao.countAplTotal(stfNo);
	}

	@Override
	public int countAplUse(int stfNo) {
		return attDao.countAplUse(stfNo);
	}

	@Override
	public WorkingHoursManage getWHM() {
		return attDao.getWHM();
	}

	@Override
	public int updateWHM(Map<String, Object> map1) {
		return attDao.updateWHM(map1);
	}

	@Override
	public int updateWHMOne(int weekHours) {
		return attDao.updateWHMOne(weekHours);
	}
	
	@Override
	public int resetWHMZeroState() {
		return attDao.resetWHMZeroState();
	}

	@Override
	public int updateWHMZero(Map<String, Object> map2) {
		return attDao.updateWHMZero(map2);
	}
	

}
