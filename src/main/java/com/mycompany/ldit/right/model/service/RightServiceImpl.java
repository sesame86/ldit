package com.mycompany.ldit.right.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.right.model.dao.RightDao;
import com.mycompany.ldit.right.model.vo.Right;
import com.mycompany.ldit.staff.model.vo.Staff;

@Service("RightService")
public class RightServiceImpl implements RightService{
	@Autowired
	private RightDao rightDao;
	
	@Override
	public List<Staff> getStaffList(Staff vo) throws Exception {
		System.out.println("service vo : " + vo);
		return rightDao.getStaffList(vo);
	}

	@Override
	public int insertPm(int rightSno) throws Exception {
		System.out.println("service vo : " + rightSno);
		return rightDao.insertPm(rightSno);
	}
}
