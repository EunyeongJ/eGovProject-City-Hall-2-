<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 결재 게시판 </title>
</head>
<body>

<jsp:include page="/WEB-INF/javascriptTag.jsp" flush="true" />

${sessionScope.session_mber_nm}님 <a href="/test/member/memberLogout"> 로그아웃 </a>
<hr/>

<a href=""> 결재 게시판 </a> | 
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
	    			<td><a href="/test/board/viewPage/${boardList.doc_num}">${boardList.doc_title}</a></td>
	    			<td>${boardList.mber_nm}</td>
	    			<td>${boardList.doc_date}</td>
	    			<td>${boardList.doc_cnt}</td>
	    			<td>조인해서 들고오기!</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	    
    </table>
    
    <hr>
	<c:if test="${count>0}">
	    <!-- 페이지네이션 블록 -->
	    <!-- 이전 페이지 만들기 -->
	    <c:if test="${startPage>pageBlock}">
	    	<a href="/test/board/apprBoard/${tempEndPage-pageBlock}"> 이전  </a>
	    </c:if>
	    
	    <c:forEach var="num" begin="${startPage}" end="${endPage}">
	    	<c:choose>
				<c:when test="${page == num}">
					<a href="/test/board/apprBoard/${num}">${num} &nbsp; </a>
				</c:when>
				
				<c:otherwise> 
					<a href="/test/board/apprBoard/${num}">${num} &nbsp; </a>
				</c:otherwise>
			</c:choose>
	    </c:forEach>
	    
	    <!-- 다음 페이지 만들기 -->
	    <c:if test="${endPage<pageCount}">
	    	<a href="/test/board/apprBoard/${startPage+pageBlock}"> 다음  </a>
	    </c:if>
	</c:if>
	<hr>
	
	<a href="/test/board/writeForm"> 양식 작성 </a> <br>
    
	게시글 갯수 : <input type="text" id="listCount"> <button id="listCountButton">보기</button> <br>
 	페이지 블록 갯수 : <input type="text" id="blockCount"> <button id="blockCountButton">보기</button> <br>

</body>
</html>