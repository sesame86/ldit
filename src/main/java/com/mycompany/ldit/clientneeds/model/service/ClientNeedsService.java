package com.mycompany.ldit.clientneeds.model.service;

import java.util.List;

import com.mycompany.ldit.clientneeds.model.vo.ClientNeeds;


public interface ClientNeedsService {
	public List<ClientNeeds> getUrgentList(int pro_no) throws Exception;
	public List<ClientNeeds> getHighList(int pro_no) throws Exception;
	public List<ClientNeeds> getNormalList(int pro_no) throws Exception;
	public List<ClientNeeds> getLowList(int pro_no) throws Exception;
	public int insertCS(ClientNeeds cvo) throws Exception;
	public ClientNeeds getCSDetail(int cnId) throws Exception;
	public int disableCS(int cnId) throws Exception;
	public int updateCS(ClientNeeds cvo) throws Exception;
}