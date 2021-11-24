package com.mycompany.ldit.right.model.service;

import java.util.List;

import com.mycompany.ldit.right.model.vo.Right;
import com.mycompany.ldit.staff.model.vo.Staff;

public interface RightService {
	public List<Staff> getStaffList(Staff vo) throws Exception;
	public int insertPm(int rightSno) throws Exception;
}
