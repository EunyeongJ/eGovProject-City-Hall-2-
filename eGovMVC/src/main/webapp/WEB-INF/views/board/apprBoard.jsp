<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 결재 게시판 </title>
</head>
<body>

${sessionScope.session_mber_nm}님 <a href="../member/memberLogout"> 로그아웃 </a>
<hr/>

<a href=""> 결재 게시판 </a>
<a href=""> 결재 대기 게시판 </a>
<hr/>

	<table border="1">
		<thead>
	        <tr>
	            <th>No</th>
	            <th>제목</th>
	            <th>작성자</th>
	            <th>작성날짜</th>
	            <th>조회수</th>
	            <th>진행상황</th>
	        </tr>
	    </thead>
	    
	    <tbody>
	    	<c:forEach items="${boardList}" var="boardList">
	    		<tr>
	    			<td>${boardList.doc_num}</td>
	    			<td>${boardList.doc_title}</td>
	    			<td>${boardList.mber_num}</td>
	    			<td>${boardList.doc_date}</td>
	    			<td>${boardList.doc_cnt}</td>
	    			<td>조인해서 들고오기!</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
    </table>
    
    <a href="../../board/writeForm"> 양식 작성 </a>

</body>
</html>