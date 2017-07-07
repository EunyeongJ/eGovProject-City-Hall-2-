<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 양식 작성 </title>
</head>
<body>

<jsp:include page="/WEB-INF/javascriptTag.jsp" flush="true" />

	<h2> 경비 지출 보고서 </h2>	
	
		<table id="apprTable" border="1">
			<tr>
				<th>제목</th>
				<th>작성자</th>
			</tr>
				
			<c:forEach items="${boardCont}" var="boardCont">		
				<tr>						
					<td>${boardCont.doc_title}</td>				
					<td>${boardCont.mber_nm}</td>	
				</tr>
			</c:forEach>
		
			<tr>	
				<th>연번</th>
				<th>내역</th>
				<th>상세내역</th>
				<th>지출구분</th>
				<th>지출일</th>
				<th>지출내용</th>
				<th>지출금액</th>
			</tr>
			
			<c:forEach items="${boardApprCont}" var="boardApprCont">		
				<tr class="item1">						
					<!-- 연번 -->
					<td>${boardApprCont.sp_num}</td>
				
					<!-- 대분류 -->
					<td>${boardApprCont.group_cd}</td>
					
					<!-- 소분류 -->
					<td>${boardApprCont.cd}</td>
					
					<!-- 지출구분 -->
					<td>${boardApprCont.sp_div}</td>
						
					<!-- 지출일 -->
					<td>${boardApprCont.sp_date}</td>
						
					<!-- 지출내용 -->
					<td>${boardApprCont.sp_cont}</td>			
					
					<!-- 지출금액 -->
					<td>${boardApprCont.sp_pay}</td>						
				</tr>
			</c:forEach>	
		</table>
		
		<a href="/test/board/apprBoard"> 목록 </a>
	
</body>
</html>