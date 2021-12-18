package com.mycompany.ldit.main.model.service;

import java.util.List;

import com.mycompany.ldit.attendance.model.vo.Attendance;
import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.receivemsg.model.vo.ReceiveMsg;
import com.mycompany.ldit.sendmsg.model.vo.SendMsg;

public interface MainService {
	public Attendance getAttendance(int stfNo) throws Exception;
	public List<Project> getUserProject(int stfNo) throws Exception;
	public List<ReceiveMsg> getReceiveMsg(int stfNo) throws Exception;
}
