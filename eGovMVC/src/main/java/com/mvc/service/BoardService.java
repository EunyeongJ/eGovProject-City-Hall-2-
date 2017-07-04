package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.CommonCodeDTO;

@Component
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	//저장된 공통 대분류 코드 가져오기
	public List<CommonCodeDTO> getCommonGroupCode(){
		return boardDAO.getCommonGroupCode();
	}
	
}
