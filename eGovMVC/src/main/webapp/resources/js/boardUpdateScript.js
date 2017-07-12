$(document).ready(function(){
	
	//수정 버튼 클릭하면
	/*$("#updateForm").click(function(){
		
		var doc_num = $("#updateForm").val();
		
		$.ajax({
			type:"POST",
			url:'/test/board/updateForm',
			data:{"doc_num" : doc_num},
			success:function(data){
				console.log("수정 게시글 가져오기 성공");
				console.log(data);
				
				//게시글 번호, 제목, 작성자 번호, 이름, 아이디
				for(var a=0; a<data.boardList.length; a++){
					console.log(data.boardList[a].doc_num+ " , "
							+data.boardList[a].doc_title+ " , "
							+data.boardList[a].mber_nm+ " , "
							+data.boardList[a].mber_num+ " , "
							+data.boardList[a].mber_id);
				}
				
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
				
				
				
				
				
				
				
				
			},
			error:function(e){
				e.responseText;
			}
		});	
		
	});*/
	
});