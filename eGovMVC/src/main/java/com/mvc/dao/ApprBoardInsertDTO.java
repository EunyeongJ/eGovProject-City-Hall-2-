package com.mvc.dao;

import java.sql.Date;
import java.util.Arrays;

public class ApprBoardInsertDTO {
	
	//게시판
	private int doc_num; //문서 번호
	private String doc_title; //문서 제목
	//양식
	private String[] group_cd; //대분류 번호
	private String[] cd; //소분류 번호
	private String[] sp_div; //지출구분
	private Date[] sp_date; //지출일
	private String[] sp_cont; //지출내용
	private int[] sp_pay; //지출금액
	//회원
	private String mber_id; //회원 아이디
	private int mber_num; //회원 번호
	private String mber_nm; //회원 이름
	
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
	
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	
	public int getMber_num() {
		return mber_num;
	}
	public void setMber_num(int mber_num) {
		this.mber_num = mber_num;
	}
	
	public String getMber_nm() {
		return mber_nm;
	}
	public void setMber_nm(String mber_nm) {
		this.mber_nm = mber_nm;
	}
	
	@Override
	public String toString() {
		return "ApprBoardInsertDTO [doc_num=" + doc_num + ", doc_title=" + doc_title + ", group_cd="
				+ Arrays.toString(group_cd) + ", cd=" + Arrays.toString(cd) + ", sp_div=" + Arrays.toString(sp_div)
				+ ", sp_date=" + Arrays.toString(sp_date) + ", sp_cont=" + Arrays.toString(sp_cont) + ", sp_pay="
				+ Arrays.toString(sp_pay) + ", mber_id=" + mber_id + ", mber_num=" + mber_num + ", mber_nm=" + mber_nm
				+ "]";
	}
	
	
	
	
	
}
