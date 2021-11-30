package com.mycompany.ldit.work.model.servie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.work.model.dao.WorkDao;
import com.mycompany.ldit.work.model.vo.Work;

@Service("WorkService")
public class WorkServiceImpl implements WorkService{
	@Autowired
	private WorkDao WorkDao;
	@Override
	public int insertWork(Work wvo) throws Exception {
		return WorkDao.insertWork(wvo);
	}
	@Override
	public List<Work> getWorkList(int stfNo) throws Exception {
		return WorkDao.getWorkList(stfNo);
	}
	@Override
	public Work getWorkDetial(int workId) throws Exception {
		return WorkDao.getWorkDetial(workId);
	}
	@Override
	public int deleteWork(int workId) throws Exception {
		return WorkDao.deleteWork(workId);
	}
	@Override
	public int updateWork(Work wvo) throws Exception {
		return WorkDao.updateWork(wvo);
	}
}