package com.mycompany.ldit.attendance.model.service;

import java.util.List;
import java.util.Map;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.attendance.model.vo.WHMZero;
import com.mycompany.ldit.attendance.model.vo.WorkBreak;
import com.mycompany.ldit.attendance.model.vo.WorkHomeApply;
import com.mycompany.ldit.attendance.model.vo.WHManage;
import com.mycompany.ldit.attendance.model.vo.Xiuxi;
import com.mycompany.ldit.attendance.model.vo.XiuxiApply;

public interface AttendanceService {
	Attendance getTodayAttendance(int stfNo);

	String getAttStartDateTime(Map<String, Object> mapMS);

	Map<String, Object> getElapsedWTime(Map<String, Object> mapMS);

	Map<String, Object> getElapsedRTime(Map<String, Object> mapMS);

	WorkBreak getLatestWB(Map<String, Object> mapMS);

	int countAplTotal(int stfNo);

	int countAplUse(int stfNo);

	int countXiuNo(String xiuNo);

	int insertXiuxi(Map<String, Object> mapM);

	int deleteXiuxi(String checked);

	int insertCheckin(int stfNo);

	String getAttStart(int stfNo);

	int countAttStart(int stfNo);

	int updateCheckout(int stfNo);

	String getAttEnd(int stfNo);

	int insertRestin(int stfNo);

	WorkBreak getRestStart(int stfNo);

	int updateBrEnd(int brNo);

	String getBrEnd(int brNo);

	WorkBreak getWorkBreak(int brNo);

	String getLatestBrStart(int stfNo);

	String getLatestBrEnd(int stfNo);

	int getBrNo(Map<String, Object> map1);

	WHManage getWHM();
	
	int getWHMOne();
	
	List<WHMZero> getWHMZero();

	int updateWHM(Map<String, Object> map1);

	int updateWHMOne(int weekHours);

	int updateWHMZero(Map<String, Object> map2);

	int resetWHMZeroState();

	List<Xiuxi> getXiuxiList();

	int countXAList(Map<String, Object> mapS);
	int countWhomeList(Map<String, Object> mapS);

	List<XiuxiApply> getxiuxiApplyList(int stfNo, int currentPage, int limitInOnePage, String keyValue);
	List<WorkHomeApply> getWhomeList(int stfNo, int currentPage, int limitInOnePage, String keyValue);
	List<Attendance> getAttList(int stfNo, int currentPage, int limitInOnePage);

	int insertXiuxiApply(Map<String, Object> mapM);
	
	int insertWorkHomeApply(Map<String, Object> mapM);
	int countAttList(int stfNo);
}
