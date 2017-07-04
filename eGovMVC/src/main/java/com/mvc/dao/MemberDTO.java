package com.mvc.dao;

import org.springframework.stereotype.Component;

//회원가입 DTO
@Component
public class MemberDTO {
	
	private int mber_num;
	private String mber_id;
	private String mber_pw;
	private String mber_nm;
	private String mber_ps;
	
	public int getMber_num() {
		return mber_num;
	}
	public void setMber_num(int mber_num) {
		this.mber_num = mber_num;
	}
	
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	
	public String getMber_pw() {
		return mber_pw;
	}
	public void setMber_pw(String mber_pw) {
		this.mber_pw = mber_pw;
	}
	
	public String getMber_nm() {
		return mber_nm;
	}
	public void setMber_nm(String mber_nm) {
		this.mber_nm = mber_nm;
	}
	
	public String getMber_ps() {
		return mber_ps;
	}
	public void setMber_ps(String mber_ps) {
		this.mber_ps = mber_ps;
	}
	
}
