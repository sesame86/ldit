package com.mycompany.ldit.staff.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffService")
public class StaffService implements StaffServiceInterface{

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public List<Staff> organization(Staff vo) throws Exception {
		List<Staff> orlist = null;
		orlist = staffDao.organization();
		System.out.println(orlist);
		return orlist;
	}
}
