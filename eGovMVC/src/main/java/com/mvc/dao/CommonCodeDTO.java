package com.mvc.dao;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CommonCodeDTO {
	
	private String group_cd; //대분류 코드?
	private String cd; //중분류코드?
	private String cdnm; //코드 이름(내용)
	private String use_yn; //쓸건지 말건지
	private int sn; //나중에 정렬하거나 순서를 매길때 사용?
	private Date regde;
	private String regid;
	
	public String getGroup_cd() {
		return group_cd;
	}
	public void setGroup_cd(String group_cd) {
		this.group_cd = group_cd;
	}
	
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	public String getCdnm() {
		return cdnm;
	}
	public void setCdnm(String cdnm) {
		this.cdnm = cdnm;
	}
	
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	
	public Date getRegde() {
		return regde;
	}
	public void setRegde(Date regde) {
		this.regde = regde;
	}
	
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	
}
