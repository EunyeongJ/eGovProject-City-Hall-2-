<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>	
<jsp:include page="/WEB-INF/javascriptTag.jsp" flush="true" />

	<form action="../member/memberJoin" method="post" name="memberJoinForm" onsubmit="return memberJoinCheck()">
		<table>				
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mber_id" id="mber_id">
					<input type="button" id="confirm_mber_id" value="ID 중복확인" onclick="confirmId()">
				</td>
				
				<input type="hidden" id="id_check" value="N"> <!-- 중복확인 했는지 확인! -->
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mber_pw" id="mber_pw"></td>
			</tr>
						
			<tr>
				<th>이름</th>
				<td><input type="text" name="mber_nm" id="mber_nm"></td>
			</tr>
			
			<tr>
				<th>직급</th>
				<td>
					<select name="mber_ps" id="mber_ps">
						<option value='01'>사원</option>
						<option value='02'>과장</option>
						<option value='03'>부장</option>
						<option value='04'>사장</option>
					</select>
				</td>
			</tr>			

			<tr>
				<td colspan="2" align="center">				
					<input type="submit"value="회원가입">
				</td>
			</tr>
		</table>			
	</form>	

</body>
</html>