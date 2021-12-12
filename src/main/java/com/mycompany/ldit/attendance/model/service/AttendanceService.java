package com.mycompany.ldit.attendance.model.service;

import java.util.List;
import java.util.Map;

import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.WorkingHoursManage;
import com.mycompany.ldit.attendance.model.vo.Xiuxi;
import com.mycompany.ldit.attendance.model.vo.XiuxiApply;

public interface AttendanceService {
	int insertCheckin(int stfNo);
	String getAttStart(int stfNo);
	int countAttStart(int stfNo);
	int updateCheckout(int stfNo);
	String getAttEnd(int stfNo);
	int insertRestin(int stfNo);
	WorkBreak getRestStart(int stfNo);
	int updateBrEnd(int brNo);
	String getBrEnd(int brNo);
	String getLatestBrStart(int stfNo);
	String getLatestBrEnd(int stfNo);
	int getBrNo(Map<String, Object> map1);
	int countAplTotal(int stfNo);
	int countAplUse(int stfNo);
	WorkingHoursManage getWHM();
	int updateWHM(Map<String, Object> map1);
	int updateWHMOne(int weekHours);
	int updateWHMZero(Map<String, Object> map2);
	int resetWHMZeroState();
	List<Xiuxi> getXiuxiList();
	int deleteXiuxi(String checked);
	int countXAList(int stfNo);
	List<XiuxiApply> getxiuxiApplyList(int stfNo, int currentPage, int limitInOnePage, String keyValue);
}
