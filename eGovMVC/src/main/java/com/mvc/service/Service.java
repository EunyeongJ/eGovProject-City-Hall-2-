package com.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.dao.HomeDAO;

@Component
public class Service {
	
	@Autowired
	HomeDAO dao;
	
	public int connect(){
		System.out.println("서비스");
		return dao.connect();
	}

}
