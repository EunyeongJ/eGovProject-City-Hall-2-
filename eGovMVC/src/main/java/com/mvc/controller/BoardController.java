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

import com.mvc.dao.ApprBoardDTO;
import com.mvc.dao.ApprHisDTO;
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
	
	//처음 들어올때는 게시판이 1번 페이지... 목록을 보여줘야함.
	@RequestMapping(value="/apprBoard/{page}")
	public String apprBoard(@PathVariable int page, Model model){
		boardService.getBoardList(page, model); //List채로 다 들고오기
		return "board/apprBoard";
	}
	
	
	//양식 작성 원본
	/*@RequestMapping(value = "/writeForm")
	public String writeForm(Model model){		
		//대분류 공통 코드 가져와서 (list) 양식에 보여주기
		//AD01
		model.addAttribute("groupCode", boardService.getCommonGroupCode());
		
		//AD02
		model.addAttribute("apprGroupCode", boardService.getApprCommonGroupCode());
		
		return "board/apprWriteForm";
	}*/
	
	//양식 작성
	@RequestMapping(value = "/writeForm")
	public String writeForm(Model model){			
		return "board/writeForm";
	}
	
	//list 꺼내오기
	@RequestMapping(value = "/selectCode")
	@ResponseBody
	public List<CommonCodeDTO> selectCode(HttpServletRequest request){
		List<CommonCodeDTO> list = boardService.getCode();
		return list;
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
	
	//넘어온 양식 insert하기!! 게시판이랑 문서에 저장하면 될듯...
	@RequestMapping(value = "/insertForm")
	public String insertForm(ApprBoardDTO apprBoardDTO){
		System.out.println("게시판, 양식 insert 함수!");
		boardService.insertBoard(apprBoardDTO);
		return "redirect:apprBoard/1";		
	}
	
	//게시판 글 보기!
	@RequestMapping(value = "/viewPage/{doc_num}")
	public String viewPage(@PathVariable int doc_num, Model model){
		System.out.println("게시판 글 보기!!");
		model.addAttribute("boardCont", boardService.getApprHis(doc_num)); //제목이랑 작성자
		model.addAttribute("boardApprCont", boardService.getApprHisCont(doc_num)); //결재내역
		//조회수 올리기
		boardService.upCount(doc_num);
		return "board/apprViewForm";
	}
	
	//게시판 글 수정하기위해 doc_num을 가지고 내용을 가져온다.
	@RequestMapping(value = "/updateForm/{doc_num}")
	public String updateForm(@PathVariable int doc_num, Model model){
		model.addAttribute("groupCode", boardService.getCommonGroupCode()); //대분류 내용 가져오기
		model.addAttribute("boardCont", boardService.getApprHis(doc_num)); //제목이랑 작성자
		model.addAttribute("boardApprCont", boardService.getApprHisCont(doc_num)); //결재내역
		return "board/apprUpdateForm";
	}
	
	//게시판 글 수정하기
	@RequestMapping(value="/updateForm")
	public String updatePage(){
		
		return "redirect:/board";
	}
	
}
