<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 양식 수정 </title>
</head>
<body>

<jsp:include page="/WEB-INF/javascriptTag.jsp" flush="true" />
<%-- <script src="${pageContext.request.contextPath}/resources/js/selectBox.js"></script> --%>

<h2> 경비 지출 보고서 </h2>
	<form action="/test/board/insertForm" method="post">
		<table id="apprTable" border="1">
			<tr>
				<th>보고서 번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
			
			<tr>
				<td>${boardCont.doc_num}</td>
				<td><input type="text" value="${boardCont.doc_title}" /></td>		
				<td>
					${boardCont.mber_nm}
					<input type="hidden" id="mber_num" name="mber_num" value="${boardCont.mber_num}"> <!-- 작성자 번호 -->
					<input type="hidden" id="mber_id" name="mber_id" value="${boardCont.mber_id}"> <!-- 작성자 아이디 -->
				</td>
			</tr>	
		
			<tr>	
				<th>내역</th>
				<th>상세내역</th>
				<th>지출구분</th>
				<th>지출일</th>
				<th>지출내용</th>
				<th>지출금액</th>
			</tr>
			
			<tr>			
				<!-- 대분류 -->
				<td>			
					<select id="group_cd1" name="group_cd" onchange="getCode(1)">				
						<option value="null"> ---대분류--- </option>
					</select>
				</td>
				
				<!-- 소분류 -->
				<td>				
					<select id="cd1" name="cd">				
						<option value="null"> ---소분류--- </option>
					</select>
				</td>
				
				<!-- 지출구분 -->
				<td>
					<select id="sp_div1" name="sp_div">				
						<option value="null"> ---구분--- </option>
					</select>				
				</td>
				
				<!-- 지출일 -->
				<td><input type="date" id="sp_date" name="sp_date"></td>
					
				<!-- 지출내용 -->
				<td><input type="text" id="sp_cont" name="sp_cont"></td>			
				
				<!-- 지출금액 -->
				<td><input type="text" id="sp_pay" name="sp_pay"></td>		
			</tr>
		</table>
		
		<input type="submit" value="작성하기">		
	</form>

	<button id="column_add" name="column_del"> 행 추가 </button>
	<button id="column_del" name="column_del"> 행 삭제 </button>
	<a href="/test/board/apprBoard"><button>목록</button></a>
</body>
</html>