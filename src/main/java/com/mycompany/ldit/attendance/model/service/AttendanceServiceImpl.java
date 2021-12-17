package com.mycompany.ldit.attendance.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.dao.AttendanceDao;
import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.WHManage;
import com.mycompany.ldit.attendance.model.vo.Xiuxi;
import com.mycompany.ldit.attendance.model.vo.XiuxiApply;

@Service("attService")
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDao attDao;
	
	@Override
	public Attendance getTodayAttendance(int stfNo) {
		return attDao.getTodayAttendance(stfNo);
	}
	
	public String getAttStartDateTime(Map<String, Object> mapMS) {
		return attDao.getAttStartDateTime(mapMS);
	}
	
	@Override
	public Map<String, Object> getElapsedWTime(Map<String, Object> mapMS) {
		return attDao.getElapsedWTime(mapMS);
	}

	@Override
	public Map<String, Object> getElapsedRTime(Map<String, Object> mapMS) {
		return attDao.getElapsedRTime(mapMS);
	}
	
	@Override
	public WorkBreak getLatestWB(Map<String, Object> mapMS) {
		return attDao.getLatestWB(mapMS);
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
	public int countXiuNo(String xiuNo) {
		return attDao.countXiuNo(xiuNo);
	}
	
	@Override
	public int insertXiuxi(Map<String, Object> mapM) {
		return attDao.insertXiuxi(mapM);
	}
	
	@Override
	public int deleteXiuxi(String checked) {
		return attDao.deleteXiuxi(checked);
	}
	
	
	

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
		int result = 0;
		result = attDao.updateCheckout(stfNo);

		if(result > 0) {
			//��ٽ� ���� attNo�� �޽��� �ִٸ� �޽� ���� �ϱ�
			Attendance att = attDao.getTodayAttendance(stfNo);
			int thisAttNo = att.getAttNo();
	
			// parameter map���·� �����
			Map<String, Object> mapS = new HashMap<String, Object>();
			mapS.put("stfNo", stfNo);
			mapS.put("thisAttNo", String.valueOf(thisAttNo));
			
			//�޽� ���� �ϱ�
			attDao.updateBrEndForce(mapS);  // ���� ����� 0 �� �� �����Ƿ� ���� return ���� ó������ ����.
		}
		return result;
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
	public WorkBreak getWorkBreak(int brNo) {
		return attDao.getWorkBreak(brNo);
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
	public WHManage getWHM() {
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

	@Override
	public List<Xiuxi> getXiuxiList() {
		return attDao.getXiuxiList();
	}



	@Override
	public int countXAList(Map<String, Object> map1) {
		return attDao.countXAList(map1);
	}

	@Override
	public List<XiuxiApply> getxiuxiApplyList(int stfNo, int currentPage, int limitInOnePage, String keyValue) {
		return attDao.getxiuxiApplyList(stfNo, currentPage, limitInOnePage, keyValue);
	}

	







}
