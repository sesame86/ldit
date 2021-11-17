package com.mycompany.ldit.staff.model;

import java.util.List;

import com.mycompany.ldit.staff.model.vo.Staff;

public interface StaffServiceInterface {
	public List<Staff> organization(Staff vo) throws Exception;
}
