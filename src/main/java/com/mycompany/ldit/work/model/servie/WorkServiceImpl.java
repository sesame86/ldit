package com.mycompany.ldit.work.model.servie;

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
}