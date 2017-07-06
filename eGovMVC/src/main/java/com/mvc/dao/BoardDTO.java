package com.mvc.dao;

import java.sql.Date;

import org.springframework.stereotype.Component;

//게시판DTO
@Component
public class BoardDTO {
	
	private int doc_num; //문서 번호
	private String doc_title; //문서 제목
	private int mber_num; //작성자 번호
	private Date doc_date; //작성일(보여주기 위함)
	private int doc_group; //원글 번호
	private int doc_step; //답글 번호
	private int doc_indent; //들여쓰기 번호
	private int doc_cnt; //조회수
	private String reg_id; //시스템 저장 등록자
	private Date rgsde; //시스템 저장 등록일
	
	public int getDoc_num() {
		return doc_num;
	}
	public void setDoc_num(int doc_num) {
		this.doc_num = doc_num;
	}
	
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	
	public int getMber_num() {
		return mber_num;
	}
	public void setMber_num(int mber_num) {
		this.mber_num = mber_num;
	}
	
	public Date getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
	}
	
	public int getDoc_group() {
		return doc_group;
	}
	public void setDoc_group(int doc_group) {
		this.doc_group = doc_group;
	}
	
	public int getDoc_step() {
		return doc_step;
	}
	public void setDoc_step(int doc_step) {
		this.doc_step = doc_step;
	}
	
	public int getDoc_indent() {
		return doc_indent;
	}
	public void setDoc_indent(int doc_indent) {
		this.doc_indent = doc_indent;
	}
	
	public int getDoc_cnt() {
		return doc_cnt;
	}
	public void setDoc_cnt(int doc_cnt) {
		this.doc_cnt = doc_cnt;
	}
	
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	
	public Date getRgsde() {
		return rgsde;
	}
	public void setRgsde(Date rgsde) {
		this.rgsde = rgsde;
	}
	
	
}
