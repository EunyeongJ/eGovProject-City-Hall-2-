package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.dao.MemberDTO;
import com.mvc.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

	//회원가입 폼 띄우기
	@RequestMapping(value = "/memberJoinForm")
	public String memberJoinForm(Model model) {
		System.out.println("회원가입  ctrl");
		return "member/memberJoinForm";
	}
	
	//회원가입
	@RequestMapping(method=RequestMethod.POST, value = "/memberJoin")
	public String memberJoin(MemberDTO memberJoinDTO){
		System.out.println("회원가입 정보 ctrl");
		System.out.println(memberJoinDTO.getMber_nm()); //이름 한글깨짐 확인
		memberService.memberJoin(memberJoinDTO);		
		return "member/memberJoinSuccess";
	}
	
	//아이디 중복 확인
	@RequestMapping(value = "/memberJoinConfirmId")
	@ResponseBody
	public String memberJoinConfirmId(HttpServletRequest request){
		System.out.println("아이디 중복 확인 ctrl");		
		return memberService.memberJoinConfirmId(request);
	}
	
	//로그인
	@RequestMapping(value = "/memberLogin")
	@ResponseBody
	public String memberLogin(HttpServletRequest request, HttpSession session){
		System.out.println("로그인 ctrl");		
		return memberService.memberLogin(request, session);
	}
	
	//로그아웃
	@RequestMapping(value = "/memberLogout")
	public String memberLogout(HttpSession session){
		System.out.println("로그아웃 ctrl");		
		return memberService.memberLogout(session);
	}
}
