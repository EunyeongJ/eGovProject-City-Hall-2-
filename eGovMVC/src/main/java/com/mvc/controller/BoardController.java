package com.mvc.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.dao.ApprBoardDTO;
import com.mvc.dao.ApprBoardInsertDTO;
import com.mvc.dao.ApprHisDTO;
import com.mvc.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	/*@RequestMapping(value = "/apprBoard")
	public String apprBoardDefault(){
		System.out.println("default");
		return "redirect:apprBoard/1";
	}*/
	
	//처음 들어올때는 게시판이 1번 페이지... 목록을 보여줘야함.
	@RequestMapping(value="/apprBoard/{page}")
	public String apprBoard(@PathVariable int page, Model model, HttpServletRequest request){	
		System.out.println("/page");
		boardService.getBoardList(page, model, request);
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
	
	//대분류에 따라서 중분류를 바꾸기 위한 에이잭스
	/*@RequestMapping(value = "/selectChangeCheck", produces={"application/json", "application/xml"})
	@ResponseBody
	public HashMap<String, Object> selectChangeCheck(Model model, HttpServletRequest request){
		System.out.println("소분류 함수!");
		List<CommonCodeDTO> list = boardService.selectChangeCheck(request);	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}*/
	
		
	//양식 작성
	@RequestMapping(value = "/writeForm")
	public String writeForm(Model model){			
		return "board/writeForm";
	}
	
	//대분류, 구분, 소분류 list 꺼내오기
	@RequestMapping(value = "/selectCode")
	@ResponseBody
	public HashMap<String, Object> selectCode(HttpServletRequest request){			
		System.out.println("getCode 컨트롤러");
		
		HashMap<String, Object> map = boardService.getCode(request);
		return map;
	}
	
	/*@RequestMapping(value = "/selectCode")
	@ResponseBody
	public HashMap<String, Object> selectCode(HttpServletRequest request){			
		System.out.println("getCode 컨트롤러");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("map1" , boardService.getCode(request));
		map.put("map2" , updateForm(request));		
		return map;
	}*/
		
	//넘어온 양식 insert하기!! 게시판이랑 문서에 저장하면 될듯...
	@RequestMapping(value = "/insertForm")
	public String insertForm(ApprBoardInsertDTO apprBoardInsertDTO){
		System.out.println("게시판, 양식 insert 함수!");
		System.out.println(apprBoardInsertDTO.toString()); //값이 어떻게 들어오는지 확인
		
		//for문으로 나눠 넣기
		boardService.insertBoard(apprBoardInsertDTO);
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

	//게시판 글 수정하기
	@RequestMapping(value="/updateForm/{doc_num}")
	public String updatePage(@PathVariable int doc_num, Model model){
		System.out.println("수정 폼!!!");
		List<ApprBoardDTO> list = boardService.getApprHis(doc_num);
		System.out.println("list가져옴");
		model.addAttribute("boardCont", list); //제목이랑 작성자 --> 얘는 model로 바로 박아넣고, 결재 양식만 list로 넘겨서 
		return "board/updateForm";
	}	
	
	
	//게시글 수정을 위해 글을 불러온다.
	@RequestMapping(value="/updateForm")
	@ResponseBody
	public HashMap<String, Object> updateForm(HttpServletRequest request){
		System.out.println("게시판 수정하기!!!");
		int doc_num = Integer.parseInt(request.getParameter("doc_num")); //doc_num 현재 문서 넘버 알아야함...		
		List<ApprHisDTO> apprList = boardService.getApprHisCont(doc_num); //결재내역
		
		//list들을 map에 넣어서 ajax로 보내기
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("apprList", apprList);
		return map;
		//수정할 게시글의 글을 불러와서 list에 담은 다음 ajax로 넘겨서 그걸 select box로 붙여넣어준다!
	}
	
	
	//수정 내용 update하기!!!
	@RequestMapping(value="/contUpdateForm")
	public void boardUpdate(ApprBoardInsertDTO apprBoardInsertDTO){
		System.out.println("게시판 수정글 update!");
		boardService.boardUpdate(apprBoardInsertDTO);
	}
	
	
}
