package com.mycompany.ldit.attendance.service;

import java.util.List;
import java.util.Map;

import com.mycompany.ldit.attendance.model.vo.WorkBreak;

public interface AttendanceService {
	public int insertCheckin(int stfNo);
	public String getAttStart(int stfNo);
	public int countAttStart(int stfNo);
	public int updateCheckout(int stfNo);
	public String getAttEnd(int stfNo);
	public int insertRestin(int stfNo);
	public WorkBreak getRestStart(int stfNo);
	public int updateBrEnd(int brNo);
	public String getBrEnd(int brNo);
	public String getLatestBrStart(int stfNo);
	public String getLatestBrEnd(int stfNo);
	public int getBrNo(Map<String, Object> map1);
}
