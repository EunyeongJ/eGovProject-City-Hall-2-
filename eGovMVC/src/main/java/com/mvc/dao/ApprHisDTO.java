package com.mvc.dao;

import java.sql.Date;

import org.springframework.stereotype.Component;

//결재 내역 양식 DTO
@Component
public class ApprHisDTO {
	
	private int doc_num;
	private int sp_num; //내역번호
	private String sp_div; //지출구분
	private Date sp_date; //지출일
	private String sp_cont; //지출내용
	private int sp_pay; //지출금액
	private String reg_id; //시스템 등록자 ID
	private Date rgsde; //시스템 등록일
	
	public int getDoc_num() {
		return doc_num;
	}
	public void setDoc_num(int doc_num) {
		this.doc_num = doc_num;
	}
	
	public int getSp_num() {
		return sp_num;
	}
	public void setSp_num(int sp_num) {
		this.sp_num = sp_num;
	}
	
	public String getSp_div() {
		return sp_div;
	}
	public void setSp_div(String sp_div) {
		this.sp_div = sp_div;
	}
	
	public Date getSp_date() {
		return sp_date;
	}
	public void setSp_date(Date sp_date) {
		this.sp_date = sp_date;
	}
	
	public String getSp_cont() {
		return sp_cont;
	}
	public void setSp_cont(String sp_cont) {
		this.sp_cont = sp_cont;
	}
	
	public int getSp_pay() {
		return sp_pay;
	}
	public void setSp_pay(int sp_pay) {
		this.sp_pay = sp_pay;
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
