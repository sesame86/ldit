package com.mycompany.ldit.team.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.ldit.project.model.vo.Project;
import com.mycompany.ldit.right.model.vo.Right;
import com.mycompany.ldit.staff.model.vo.Staff;
import com.mycompany.ldit.team.model.vo.Team;

@Repository("teamDao")
public class TeamDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<Team> getOneProjectTeam(int proNo){
		return sqlSession.selectList("Team.getOneProjectTeam", proNo);
	}
	public List<Team> getTeamMemberTeamList(Team tvo){
		System.out.println("진입");
		return sqlSession.selectList("Team.getTeamMemberTeamList", tvo);
	}
	public Project getOneProject(int proNo){
		return sqlSession.selectOne("Team.getOneProject", proNo);
	}
	public List<Staff> searchPM(String searchWord) {
		return sqlSession.selectList("Team.search", searchWord);
	}
	public List<Staff> searchTeamMember(String searchWord) {
		return sqlSession.selectList("Team.search", searchWord);
	}
	public Staff searchByNo(int searchNo) {
		return sqlSession.selectOne("Team.searchByNo", searchNo);
	}
	@Transactional(rollbackFor = Exception.class)
	public int insertTeam(Team tvo) {
		return sqlSession.insert("Team.insertTeam", tvo);
	}
	@Transactional(rollbackFor = Exception.class)
	public int updateTeam(Team tvo) {
		return sqlSession.update("Team.updateTeam", tvo);
	}
	public int checkTeamId(Team tvo) {
		return sqlSession.selectOne("Team.checkTeamId", tvo);
	}
	@Transactional(rollbackFor = Exception.class)
	public int insertTMRight(Right rvo) {
		return sqlSession.insert("Team.insertTMRight", rvo);
	}
	public int checkDupidTM(Right rvo) {
		return sqlSession.selectOne("Team.checkDupidTM", rvo);
	}
	public int getStaffRight(int stfNo) {
		return sqlSession.selectOne("Team.getStaffRight", stfNo);
	}
	public Team getTeamUpdate(int proNo) {
		return sqlSession.selectOne("Team.getTeamUpdate", proNo);
	}
}