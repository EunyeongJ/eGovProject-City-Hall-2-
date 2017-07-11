package com.mvc.dao;

import java.sql.Date;
import java.util.Arrays;

public class ApprBoardInsertDTO {
	
	//게시판
	private int doc_num; //문서 번호
	private String doc_title; //문서 제목
	private int mber_num; //작성자 번호
	private Date doc_date; //작성일(보여주기 위함)
	private int doc_group; //원글 번호
	private int doc_step; //답글 번호
	private int doc_indent; //들여쓰기 번호
	private int doc_cnt; //조회수
	
	//양식
	private int sp_num; //연번
	private String[] group_cd; //대분류 번호
	private String[] cd; //소분류 번호
	private String[] sp_div; //지출구분
	private Date[] sp_date; //지출일
	private String[] sp_cont; //지출내용
	private int[] sp_pay; //지출금액
	
	private String reg_id; //시스템 등록자 ID
	private Date rgsde; //시스템 등록일
	
	//회원
	private String mber_nm; //회원 이름
	private String mber_id; //회원 아이디
	
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
	public int getSp_num() {
		return sp_num;
	}
	public void setSp_num(int sp_num) {
		this.sp_num = sp_num;
	}
	public String[] getGroup_cd() {
		return group_cd;
	}
	public void setGroup_cd(String[] group_cd) {
		this.group_cd = group_cd;
	}
	public String[] getCd() {
		return cd;
	}
	public void setCd(String[] cd) {
		this.cd = cd;
	}
	public String[] getSp_div() {
		return sp_div;
	}
	public void setSp_div(String[] sp_div) {
		this.sp_div = sp_div;
	}
	public Date[] getSp_date() {
		return sp_date;
	}
	public void setSp_date(Date[] sp_date) {
		this.sp_date = sp_date;
	}
	public String[] getSp_cont() {
		return sp_cont;
	}
	public void setSp_cont(String[] sp_cont) {
		this.sp_cont = sp_cont;
	}
	public int[] getSp_pay() {
		return sp_pay;
	}
	public void setSp_pay(int[] sp_pay) {
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
	public String getMber_nm() {
		return mber_nm;
	}
	public void setMber_nm(String mber_nm) {
		this.mber_nm = mber_nm;
	}
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	
	@Override
	public String toString() {
		return "ApprBoardInsertDTO [doc_num=" + doc_num + ", doc_title=" + doc_title + ", mber_num=" + mber_num
				+ ", doc_date=" + doc_date + ", doc_group=" + doc_group + ", doc_step=" + doc_step + ", doc_indent="
				+ doc_indent + ", doc_cnt=" + doc_cnt + ", sp_num=" + sp_num + ", group_cd=" + Arrays.toString(group_cd)
				+ ", cd=" + Arrays.toString(cd) + ", sp_div=" + Arrays.toString(sp_div) + ", sp_date="
				+ Arrays.toString(sp_date) + ", sp_cont=" + Arrays.toString(sp_cont) + ", sp_pay="
				+ Arrays.toString(sp_pay) + ", reg_id=" + reg_id + ", rgsde=" + rgsde + ", mber_nm=" + mber_nm
				+ ", mber_id=" + mber_id + "]";
	}
	
	
		
}
