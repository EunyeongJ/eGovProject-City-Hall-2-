package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//리스트보기
	/*@RequestMapping(value = "/list")
	public String defaultList(){
		return "redirect:list/1";
	}*/
	
	//양식 작성
	@RequestMapping(value = "/writeForm")
	public String writeForm(Model model){
		
		//대분류 공통 코드 가져와서 (list) 양식에 보여주기
		model.addAttribute("groupCode", boardService.getCommonGroupCode());
		return "board/apprWriteForm";
	}
}
