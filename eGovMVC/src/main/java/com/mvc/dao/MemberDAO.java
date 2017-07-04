package com.mvc.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO extends SqlSessionDaoSupport{

	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	//회원가입
	public int memberJoin(MemberDTO memberDTO){
		System.out.println("memberDAO");
		return getSqlSession().insert("memberMapper.memberJoin", memberDTO);
	}
	
	//아이디 중복확인
	public int memberJoinConfirmId(String mber_id){
		return getSqlSession().selectOne("memberMapper.memberJoinConfirmId", mber_id);
	}
	
	//회원 로그인
	public int memberLogin(HashMap<String, Object> map){
		return getSqlSession().selectOne("memberMapper.memberLogin", map);
	}
	
	//회원아이디로 회원 정보 꺼내오기
	public MemberDTO getMemberInfo(String mber_id){
		return getSqlSession().selectOne("memberMapper.getMemberInfo", mber_id);
	}

	
	
}
