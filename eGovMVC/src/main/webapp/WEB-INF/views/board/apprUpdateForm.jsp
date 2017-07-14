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
	<form action="/test/board/updateForm" method="post" name="insertForm">
		<table id="apprTable" border="1">
			<tr>
				<th>제목</th>
				<th>작성자</th>
			</tr>
				
			<c:forEach items="${boardCont}" var="boardCont">		
				<tr>						
					<td><input type="text" value="${boardCont.doc_title}" /></td>		
					<td><input type="text" disabled="disabled" value="${boardCont.mber_nm}"/></td>
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
					<td>
						<select id="group_cd" name="group_cd" onchange="changeSelectCheck(this.value)">
							<option value="null"> ---대분류--- </option>
							<c:forEach var="groupCode" items="${groupCode}" varStatus="status">
								<option value="${groupCode.cd}" selected="selected"> ${groupCode.cdnm} </option>
							</c:forEach>				
						</select>
					</td>
					
					<!-- 소분류 -->
					<td>
						<select id="cd" name="cd">
							<option value="null"> ---소분류--- </option>
							<c:forEach var="boardApprCont" items="${boardApprCont}" varStatus="status">
								<option value="${boardApprCont.cd}" selected="selected"> ${boardApprCont.cdnm} </option>
							</c:forEach>	
						</select>
					
						<input type="text" value="${boardApprCont.cd}" />
					</td>
					
					<!-- 지출구분 -->
					<td>
						<select id="sp_div" name="sp_div">
							<option value="null"> ---구분--- </option>
							<c:forEach var="boardApprCont" items="${boardApprCont}" varStatus="status">
								<option value="${boardApprCont.sp_div}" selected="selected"> ${boardApprCont.cdnm} </option>
							</c:forEach>				
						</select>		
						
						<input type="text" value="${boardApprCont.sp_div}" />
					</td>
						
					<!-- 지출일 -->
					<td><input type="date" value="${boardApprCont.sp_date}" /></td>
						
					<!-- 지출내용 -->
					<td><input type="text" value="${boardApprCont.sp_cont}" /></td>
					
					<!-- 지출금액 -->
					<td><input type="text" value="${boardApprCont.sp_pay}" /></td>				
				</tr>
			</c:forEach>	
		</table>
		
		<input type="submit" value="수정하기">
	</form>
	
	<button id="column_add" name="column_del"> 추가 </button>
	<button id="column_del" name="column_del"> 삭제 </button>
	<a href="/test/board/apprBoard/1"> 목록 </a>
</body>
</html>