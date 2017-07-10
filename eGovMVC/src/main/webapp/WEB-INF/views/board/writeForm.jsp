<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 양식 작성 </title>
</head>
<body>

<jsp:include page="/WEB-INF/javascriptTag.jsp" flush="true" />
<script src="${pageContext.request.contextPath}/resources/js/selectBox.js"></script>

<h2> 경비 지출 보고서 </h2>
	<table id="apprTable" border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" id="doc_title" name="doc_title"> </td>
			
			<th>작성자</th>
			<td><input type="text" id="mber_nm" name="mber_nm" value="${sessionScope.session_mber_nm}" disabled="disabled"></td>
			<input type="hidden" id="mber_num" name="mber_num" value="${sessionScope.session_mber_num}">
			<input type="hidden" id="mber_id" name="mber_id" value="${sessionScope.session_mber_id}"> <!-- 작성자 아이디 -->
		</tr>
	
		<tr>	
			<th>내역</th>
			<th>상세내역</th>
			<th>지출구분</th>
		</tr>
		
		<tr class="item1">			
			<!-- 대분류 -->
			<td>				
				<select id="group_cd" name="group_cd">
					<option value="null"> ---대분류--- </option>			
					
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
				<select id="sp_div" name="sp_div">
					<option value="null"> ---구분--- </option>
					
				</select>				
			</td>
		</tr>
	</table>

	<button id="add" name="add"> 추가 </button>
	<button id="del" name="del"> 삭제 </button>

</body>
</html>