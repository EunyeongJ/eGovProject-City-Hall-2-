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
	<form action="/test/board/insertForm" method="post" onsubmit="return apprInsertCheck">
		<table id="apprTable" border="1">
			<tr>
				<th>제목</th>
				<th>작성자</th>
			</tr>
				
			<tr>	
				<td><input type="text" id="doc_title" name="doc_title"> </td>
				<td>
					${sessionScope.session_mber_nm}
					<input type="hidden" id="mber_num" name="mber_num" value="${sessionScope.session_mber_num}"> <!-- 작성자 번호 -->
					<input type="hidden" id="mber_id" name="mber_id" value="${sessionScope.session_mber_id}"> <!-- 작성자 아이디 -->
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
		</table>
		
		<input type="submit" value="작성하기">		
	</form>

	<button id="column_add" name="column_del"> 행 추가 </button>
	<button id="column_del" name="column_del"> 행 삭제 </button>
	<a href="/test/board/apprBoard/1"><button>목록</button></a>
</body>
</html>