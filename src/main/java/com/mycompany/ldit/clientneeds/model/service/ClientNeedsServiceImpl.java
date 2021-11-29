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
	public List<ClientNeeds> getUrgentList(int proNo) throws Exception {
		return ClientNeedsDao.getUrgentList(proNo);
	}
	@Override
	public List<ClientNeeds> getHighList(int proNo) throws Exception {
		return ClientNeedsDao.getHighList(proNo);
	}
	@Override
	public List<ClientNeeds> getNormalList(int proNo) throws Exception {
		return ClientNeedsDao.getNormalList(proNo);
	}
	@Override
	public List<ClientNeeds> getLowList(int proNo) throws Exception {
		return ClientNeedsDao.getLowList(proNo);
	}
	@Override
	public int insertCS(ClientNeeds cvo) throws Exception {
		return ClientNeedsDao.insertCS(cvo);
	}
	@Override
	public ClientNeeds getCSDetail(int cnId) throws Exception {
		return ClientNeedsDao.getCSDetail(cnId);
	}
	@Override
	public int disableCS(int cnId) throws Exception {
		return ClientNeedsDao.disableCS(cnId);
	}
	@Override
	public int updateCS(ClientNeeds cvo) throws Exception {
		return ClientNeedsDao.updateCS(cvo);
	}
}
