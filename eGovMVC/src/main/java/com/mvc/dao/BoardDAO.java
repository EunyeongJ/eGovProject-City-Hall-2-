package com.mvc.dao;

import java.sql.Date;
import java.util.HashMap;
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
	/*public List<CommonCodeDTO> getCommonGroupCode(){
		return getSqlSession().selectList("boardMapper.getCommonGroupCode");
	}*/
	
	//대분류코드로 중분류 코드 가져오기
	/*public List<CommonCodeDTO> selectChangeCheck(String groupCodeCD){
		return getSqlSession().selectList("boardMapper.selectChangeCheck", groupCodeCD);
	}*/
	
	//결제방법 대분류
	/*public List<CommonCodeDTO> getApprCommonGroupCode(){
		return getSqlSession().selectList("boardMapper.getApprCommonGroupCode");
	}*/
	
	
	
	
	
	//ajax로 대분류랑 구분, 소분류 다 뽑아오기
	public List<CommonCodeDTO> getCode(String dbParam){
		return getSqlSession().selectList("boardMapper.getCode", dbParam);
	}
	
	//list 가져오기
	public List<ApprBoardDTO> getBoardList(HashMap<String, Object> map){
		return getSqlSession().selectList("boardMapper.getBoardList", map);
	}
	
	//총 list 갯수
	public int getListCount(){
		return getSqlSession().selectOne("boardMapper.getListCount");
	}
	
	
	//새 insert!
	public void insertBoard(ApprBoardInsertDTO apprBoardInsertDTO){	
		System.out.println("게시판에 넣기!!!!");			
		
		//게시판에 넣기
		getSqlSession().insert("boardMapper.insertBoard", apprBoardInsertDTO); //일단 게시판에 넣고
		
		//map에 넣어서..
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//현재 자동증가값 가져오기
		map.put("doc_num", getSqlSession().selectOne("boardMapper.getDocNum")); //게시판에 들어간 doc_num중 max
		map.put("mber_id", apprBoardInsertDTO.getMber_id());				
		
		//for문 돌려서 넣어야 하나ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ
		for(int a=0; a<apprBoardInsertDTO.getGroup_cd().length; a++){
			map.put("group_cd", apprBoardInsertDTO.getGroup_cd()[a]); //내역
			map.put("cd", apprBoardInsertDTO.getCd()[a]); //상세내역
			map.put("sp_div", apprBoardInsertDTO.getSp_div()[a]); 
			map.put("sp_date", apprBoardInsertDTO.getSp_date()[a]); 
			map.put("sp_cont", apprBoardInsertDTO.getSp_cont()[a]);
			map.put("sp_pay", apprBoardInsertDTO.getSp_pay()[a]); 
			
			getSqlSession().insert("boardMapper.insert", map); //양식에 넣기
		}		
		System.out.println("넣었음!");
	}

	//게시글 내용 가져오기---------------------------------------------------------------------------------
	//게시글 제목이랑 작성자 이름 가져오기
	public List<ApprBoardDTO> getApprHis(int doc_num){
		List<ApprBoardDTO> list = getSqlSession().selectList("boardMapper.getApprHis", doc_num);
		return list;
	}
	
	//결재내역 양식
	public List<ApprHisDTO> getApprHisCont(int doc_num){
		List<ApprHisDTO> list = getSqlSession().selectList("boardMapper.getApprHisCont", doc_num);
		return list;
	}
	//----------------------------------------------------------------------------------------------
	
	//조회수 올리기
	public void upCount(int doc_num){
		getSqlSession().update("boardMapper.upCount", doc_num);
	}
	
	//게시글 수정
	public void boardUpdate(ApprBoardInsertDTO apprBoardInsertDTO){
		//
	}
	
}
