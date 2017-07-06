package com.mvc.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.dao.MemberDAO;
import com.mvc.dao.MemberDTO;

@Component
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	//회원가입
	public void memberJoin(MemberDTO memberJoinDTO){
		System.out.println("memberService");
		memberDAO.memberJoin(memberJoinDTO);
	}
	
	//아이디 중복확인
	public String memberJoinConfirmId(HttpServletRequest request){
		String mber_id = request.getParameter("mber_id");
		int confirmResult = memberDAO.memberJoinConfirmId(mber_id); 
		if(confirmResult >= 1){ //아이디가 1개 이상이면 가입자가 있다.
			return "fail";
		}else{ //아이디가 1개 이상이지 않다. -> 가입자 없다.
			return "success";
		}
	}
	
	//회원 로그인
	public String memberLogin(HttpServletRequest request, HttpSession session){
		String mber_id = request.getParameter("mber_id"); //아이디
		String mber_pw = request.getParameter("mber_pw"); //비밀번호
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("mber_id", mber_id);
		map.put("mber_pw", mber_pw);
		
		int loginResult = memberDAO.memberLogin(map);
		if(loginResult >= 1){ //로그인이 되었다.
			System.out.println("로그인 성공");
			MemberDTO memberDTO = memberDAO.getMemberInfo(mber_id); //아이디로 멤버정보 가져와서 세션에 저장
			session.setAttribute("session_mber_num", memberDTO.getMber_num()); //멤버 번호
			session.setAttribute("session_mber_id", memberDTO.getMber_id()); //멤버 아이디
			session.setAttribute("session_mber_nm", memberDTO.getMber_nm()); //멤버 이름
			session.setAttribute("session_mber_ps", memberDTO.getMber_ps()); //멤버 직급		
			
			return "success";
		}else{ //로그인 실패
			System.out.println("로그인 실패");
			return "fail";
		}	
	}
	
	//회원 로그아웃
	public String memberLogout(HttpSession session){
		System.out.println("로그아웃");
		session.removeAttribute("mber_num");
		session.removeAttribute("mber_id");
		session.removeAttribute("mber_nm");
		session.removeAttribute("mber_ps");
		session.invalidate(); //세션 삭제
		
		return "redirect:main";
	}	
	
}
