package com.mvc.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.mvc.dao.ApprBoardDTO;
import com.mvc.dao.ApprHisDTO;
import com.mvc.dao.BoardDAO;
import com.mvc.dao.BoardDTO;
import com.mvc.dao.CommonCodeDTO;

@Component
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	//공통코드 새로 가져오기
	public List<CommonCodeDTO> getCode(){
		System.out.println("getCode");
		List<CommonCodeDTO> list = boardDAO.getCode();
		
		for(int a=0; a<list.size(); a++){
			System.out.println(list.get(a).getCdnm());
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	//저장된 공통 대분류 코드 가져오기
	public List<CommonCodeDTO> getCommonGroupCode(){
		return boardDAO.getCommonGroupCode();
	}
	
	//대분류 공통코드 가지고 와서 중분류 만들기
	public List<CommonCodeDTO> selectChangeCheck(HttpServletRequest request){
		System.out.println("selectChangeCheck");
		String groupCodeCD = "AD01" + request.getParameter("groupCodeCD"); // "AD0101" 이런식..?
		
		System.out.println(groupCodeCD);
		List<CommonCodeDTO> list = boardDAO.selectChangeCheck(groupCodeCD);
		
		for(int a=0; a<list.size(); a++){
			System.out.println(list.get(a).getCdnm());
		}
		
		return list;
	}
	
	//결제 방법 공통코드
	public List<CommonCodeDTO> getApprCommonGroupCode(){
		return boardDAO.getApprCommonGroupCode();
	}
	
	//list가져오기
	//int page는 현재 몇 페이지인지 확인하기 위함
	public void getBoardList(int page, Model model){
		
		//내가 게시판 list를 몇개로 보고 싶다.
		//int listCount = Integer.parseInt(request.getParameter("listCount"));
		
		//페이징 처리
		int pageSize = 10;
		
		
		/*int pageSize;		
		if(request.getParameter("listCount") == null){
			pageSize = 10; //일단 한 페이지에 글을 10개 보여줄거다!
		}else{
			pageSize = listCount;
		}*/
		
		
		int first = (page - 1) * pageSize + 1; //목록 10개 중 첫번째 글 - 1 / 11 / 21 ... 
		int last = page * pageSize; //목록 10개 중 마지막 글 - 10 / 20 / 30 ...
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("first", first);
		map.put("last", last);
		List<ApprBoardDTO> list = boardDAO.getBoardList(map); //rownum을 붙여서 1번부터 10번까지 데려옴!
		int count = boardDAO.getListCount();//총 글의 갯수	
		
		//페이징 처리 후 모델에 데이터 입력
		model.addAttribute("boardList", list);			//글 리스트
		model.addAttribute("count", count);			//총 글의 개수
		//model.addAttribute("number", count - (page - 1) * pageSize);	//글번호-> 1페이지 17번, 2페이지 7번, 3페이지 없음!!!!!!!
		//model.addAttribute("first", first);
		//model.addAttribute("last", last);
		//model.addAttribute("page", page);
		
		//총 글의 갯수가 하나라도 있으면...
		if(count > 0){
			//총 페이지 수. 지금 글이 17개니까 10개씩 보여준다 치면 페이지는 총 2페이지. 10개, 7개... 이렇게인데 나머지가 있다면 페이지 수를 하나 더 늘려줘야 한다.
			int pageCount = count / pageSize + (count % pageSize == 0? 0 : 1); //그래서 지금 2페이지
			int pageBlock = 3; //내가 페이지버튼을 몇개 만들것인가
			int startPage = (page / (pageBlock + 1)) * pageBlock + 1; //시작 페이지블록 ------------------------> 요부분이 이상한데 좀 더 만져보는게 좋을 것 같다!!!!!!
			int endPage = startPage + pageBlock - 1; //끝 페이지블록
			int tempEndPage = endPage; //임시 페이지 블록
			
			//총 만들어진 페이지(2페이지)에서, 블록으로 만든 페이지가 크면 줄여주기...
			if(endPage > pageCount){
				endPage = pageCount;
			}
						
			model.addAttribute("pageCount", pageCount); //2페이지
			model.addAttribute("pageBlock", pageBlock); //페이지 블록... 지금 5개로 맞춰놓음
			model.addAttribute("startPage", startPage); 
			model.addAttribute("endPage", endPage); 
			model.addAttribute("tempEndPage", tempEndPage); //끝 페이지블록 변경 전 내용
		}
		
	}	
	
	//양식 insert 함수
	public void insertBoard(ApprBoardDTO apprBoardDTO){
		boardDAO.insertBoard(apprBoardDTO);
	}
	
	//게시판 제목, 작성자 보여주기 함수
	public List<ApprBoardDTO> getApprHis(int doc_num){
		//게시판 제목, 작성자 불러오기
		List<ApprBoardDTO> list = boardDAO.getApprHis(doc_num);
		return list;
	}
	
	//결재내역 양식
	public List<ApprBoardDTO> getApprHisCont(int doc_num){
		List<ApprBoardDTO> list = boardDAO.getApprHisCont(doc_num);
		return list;
	}
	
	//조회수 올리기
	public void upCount(int doc_num){
		boardDAO.upCount(doc_num);
	}
	
	
}
