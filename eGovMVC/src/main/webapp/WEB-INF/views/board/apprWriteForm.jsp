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
		
		<tr>
			<td> 
				<input type="text"> 
			</td>
			
			<td>
				<input type="text">
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
				<select id="group_cd" onchange="changeSelectCheck(this.value)">
					<option value="null"> ---대분류--- </option>
					<c:forEach var="groupCode" items="${groupCode}" varStatus="status">
						<option value="${groupCode.cd}"> ${groupCode.cdnm} </option>
					</c:forEach>				
				</select>
			</td>
			
			<!-- 소분류 -->
			<td>				
				<select id="cd" name="cd">
					<option value="null"> ---소분류--- </option>
				</select>
			</td>
			
			<!-- 지출구분 -->
			<td>
				<select id="sp_div">
					<option value="null"> ---구분--- </option>
					<c:forEach var="apprGroupCode" items="${apprGroupCode}" varStatus="status">
						<option value="${apprGroupCode.cd}"> ${apprGroupCode.cdnm} </option>
					</c:forEach>				
				</select>				
			</td>
				
			<!-- 지출일 -->
			<td>
				<input type="date" id="sp_date">
			</td>
				
			<!-- 지출내용 -->
			<td>
				<input type="text" id="sp_cont">
			</td>
			
			<!-- 지출금액 -->
			<td>
				<input type="text" id="sp_pay">
			</td>		
		</tr>			
	</table>

	<button id="column_add" name="column_del" value=""> 추가 </button>
	<button id="column_del" name="column_del" value=""> 삭제 </button>
	
</body>
</html>