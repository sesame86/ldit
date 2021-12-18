package com.mycompany.ldit.main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.main.model.dao.MainDao;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

@Service("MainService")
public class MainServiceImpl implements MainService{
	@Autowired
	private MainDao MainDao;
	
	@Override
	public Attendance getAttendance(int stfNo) throws Exception {
		return MainDao.getAttendance(stfNo);
	}
	@Override
	public List<Project> getUserProject(int stfNo) throws Exception {
		return MainDao.getUserProject(stfNo);
	}
	@Override
	public List<ReceiveMsg> getReceiveMsg(int stfNo) throws Exception{
		return MainDao.getReceiveMsg(stfNo);
	}
}
