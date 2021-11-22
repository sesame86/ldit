package com.mycompany.ldit.clientneeds.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.ldit.clientneeds.model.dao.ClientNeedsDao;
import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;

@Service("ClientNeedsService")
public class ClientNeedsServiceImpl implements ClientNeedsService{
	@Autowired
	private ClientNeedsDao ClientNeedsDao;
	
	@Override
	public List<ClientNeeds> getUrgentList(int pro_no) throws Exception {
		return ClientNeedsDao.getUrgentList(pro_no);
	}
	@Override
	public List<ClientNeeds> getHighList(int pro_no) throws Exception {
		return ClientNeedsDao.getHighList(pro_no);
	}
	@Override
	public List<ClientNeeds> getNormalList(int pro_no) throws Exception {
		return ClientNeedsDao.getNormalList(pro_no);
	}
	@Override
	public List<ClientNeeds> getLowList(int pro_no) throws Exception {
		return ClientNeedsDao.getLowList(pro_no);
	}
}
