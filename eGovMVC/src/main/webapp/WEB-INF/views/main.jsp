<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 메인화면 </title>
</head>
<body>
<jsp:include page="/WEB-INF/javascriptTag.jsp" flush="true" />

mySql 연결확인 : ${dual}	
<hr/>

	<form method="post" name="memberLogin">
		<table>				
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mber_id" id="mber_id"></td>				
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mber_pw" id="mber_pw"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">				
					<input type="button" value="로그인" onclick="memberLoginCheck()">
				</td>
			</tr>
		</table>
	</form>

<a href="../member/memberJoinForm"> 회원가입 </a>

</body>
</html>