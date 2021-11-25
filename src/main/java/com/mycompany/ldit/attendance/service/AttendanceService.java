package com.mycompany.ldit.attendance.service;


public interface AttendanceService {
	public int insertCheckin(int stfNo) throws Exception;
	public String getAttStart(int stfNo) throws Exception;
	public int countAttStart(int stfNo) throws Exception;
}
