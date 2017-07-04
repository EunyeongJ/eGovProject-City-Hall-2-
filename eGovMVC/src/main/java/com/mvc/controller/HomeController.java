package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.service.Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	Service service;
	
	//연결 확인
	@RequestMapping(value = "/java")
	public String home(Model model) {
		System.out.println("HomeController");
		model.addAttribute("dual", service.connect());
		return "home";
	}
	
	//메인화면
	@RequestMapping(value = "/main")
	public String main(Model model) {		
		model.addAttribute("dual", service.connect()); //mySql 연결확인
		return "main";
	}
			
	
}
