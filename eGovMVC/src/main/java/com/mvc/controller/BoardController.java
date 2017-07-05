package com.mvc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.dao.CommonCodeDTO;
import com.mvc.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
		
	//로그인 성공하여 게시판 들어가기
	@RequestMapping(value = "/apprBoard")
	public String apprBoardDefault(){
		return "redirect:apprBoard/1";
	}
	
	//처음 들어올때는 게시판이 1번 페이지...
	@RequestMapping(value="/apprBoard/{page}")
	public String arrpBoard(@PathVariable int page){
		return "board/apprBoard";
	}
	
	//양식 작성
	@RequestMapping(value = "/writeForm")
	public String writeForm(Model model){		
		//대분류 공통 코드 가져와서 (list) 양식에 보여주기
		model.addAttribute("groupCode", boardService.getCommonGroupCode());
		model.addAttribute("apprGroupCode", boardService.getApprCommonGroupCode());
		return "board/apprWriteForm";
	}
	
	//대분류에 따라서 중분류를 바꾸기 위한 에이잭스
	@RequestMapping(value = "/selectChangeCheck", produces={"application/json", "application/xml"})
	@ResponseBody
	public HashMap<String, Object> selectChangeCheck(Model model, HttpServletRequest request){
		System.out.println("소분류 함수!");
		List<CommonCodeDTO> list = boardService.selectChangeCheck(request);	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}
	
	
	
	
	
}
