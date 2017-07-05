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
}
