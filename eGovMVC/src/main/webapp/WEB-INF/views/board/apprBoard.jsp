<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 결재 게시판 </title>
</head>
<body>

${sessionScope.mber_nm}님 <a href="../member/memberLogout"> 로그아웃 </a>
<hr/>
	<table border="1">
        <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성날짜</th>
            <th>조회수</th>
            <th>진행상황</th>
        </tr>
       
        <tr>
            <td>1</td>
            <td><a href="#">게시판</a></td>
            <td>전은영</td>
            <td>시간</td>
            <td>0</td>
            <td>결재대기</td>
        </tr>
        
    </table>
    
    <a href="../board/writeForm"> 양식 작성 </a>

</body>
</html>