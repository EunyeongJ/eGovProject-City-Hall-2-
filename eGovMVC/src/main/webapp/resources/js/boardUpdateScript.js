$(document).ready(function(){
	alert("수정 ajax!!!");
	var doc_num = $("#updateForm").val();
	console.log(doc_num);
	
	$.ajax({
		type:"POST",
		url:'/test/board/updateForm',
		data:{"doc_num" : doc_num},
		success:function(data){
			console.log("수정 게시글 가져오기 성공");
			console.log(data);
			
			//게시글 번호, 제목, 작성자 번호, 이름, 아이디
			/*for(var a=0; a<data.boardList.length; a++){
				console.log(data.boardList[a].doc_num+ " , "
						+data.boardList[a].doc_title+ " , "
						+data.boardList[a].mber_nm+ " , "
						+data.boardList[a].mber_num+ " , "
						+data.boardList[a].mber_id);
			}*/
			
			//양식 내용 뽑아보기
			for(var a=0; a<data.apprList.length; a++){
				console.log(data.apprList[a].sp_num+" , "
						+data.apprList[a].group_cd+" , "
						+data.apprList[a].group_cd_nm+" , "
						+data.apprList[a].cd+" , "
						+data.apprList[a].cd_nm+" , "
						+data.apprList[a].sp_div+" , "
						+data.apprList[a].sp_div_nm+" , "
						+data.apprList[a].sp_date+" , "
						+data.apprList[a].sp_cont+" , "
						+data.apprList[a].sp_pay);
			}
			
			/*
			//대분류랑 구분 가져오기...
			if(data.code1 == 1 && data.code3 == 3){ //조건정리
				//$("#group_cd").find("option").remove().end().append("<option value='null'> ---대분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
				for(var a=0; a<data.list1.length; a++){
					console.log(data.list1[a].cd+ " , "+data.list1[a].cdnm+", "+data.list1[a].group_cd); //콘솔 확인
					$("#group_cd"+code).append("<option value='"+data.list1[a].cd+"'>"+ data.list1[a].cdnm +"</option>") //대분류 가져오기
				}
				
				for(var a=0; a<data.list3.length; a++){
					console.log(data.list3[a].cd+ " , "+data.list3[a].cdnm+", "+data.list3[a].group_cd); //콘솔 확인				
					$("#sp_div"+code).append("<option value='"+data.list3[a].cd+"'>"+ data.list3[a].cdnm +"</option>") //구분 가져오기
				}
			}
			
			//대분류를 누르면 소분류를 가져온다.
			if(data.code2 == 2){ //조건 정리
				$("#cd"+code).find("option").remove().end().append("<option value='null'> ---소분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
				for(var a=0; a<data.list2.length; a++){
					console.log(data.list2[a].cd+ " , "+data.list2[a].cdnm+", "+data.list2[a].group_cd); //콘솔 확인					
					$("#cd"+code).append("<option value='"+data.list2[a].cd+"'>"+ data.list2[a].cdnm +"</option>") //대분류 가져오기
				}
			}*/
			
			
		},
		error:function(e){
			e.responseText;
		}
	});	
	
});