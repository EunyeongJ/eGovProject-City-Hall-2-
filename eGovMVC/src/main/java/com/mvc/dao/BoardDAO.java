package com.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//결재 양식 DAO
@Component
public class BoardDAO extends SqlSessionDaoSupport{
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//저장된 대분류 공통코드 가져오기
	public List<CommonCodeDTO> getCommonGroupCode(){
		return getSqlSession().selectList("boardMapper.getCommonGroupCode");
	}
	
	//대분류코드로 중분류 코드 가져오기
	public List<CommonCodeDTO> selectChangeCheck(String groupCodeCD){
		return getSqlSession().selectList("boardMapper.selectChangeCheck", groupCodeCD);
	}
	
	//결제방법 대분류
	public List<CommonCodeDTO> getApprCommonGroupCode(){
		return getSqlSession().selectList("boardMapper.getApprCommonGroupCode");
	}
	
	//list 가져오기
	public List<BoardDTO> getBoardList(){
		return getSqlSession().selectList("boardMapper.getBoardList");
	}
	
	//양식 insert 하는 함수! 게시판에 먼저 넣고, 테이블에 따로 넣어야 겠음!
	public void insertBoard(ApprBoardDTO apprBoardDTO){		
		getSqlSession().insert("boardMapper.insertBoard", apprBoardDTO); //게시판에 넣기
		getSqlSession().insert("boardMapper.insertForm", apprBoardDTO); //양식에 넣기
		System.out.println("넣었음!");
	}
	
}
