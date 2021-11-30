package com.mycompany.ldit.work.model.servie;

import java.util.List;

import com.mycompany.ldit.work.model.vo.Work;

public interface WorkService {
	public int insertWork(Work wvo) throws Exception;
	public List<Work> getWorkList(int stfNo) throws Exception;
	public Work getWorkDetial(int workId) throws Exception;
	public int deleteWork(int workId) throws Exception;
	public int updateWork(Work wvo) throws Exception;
}