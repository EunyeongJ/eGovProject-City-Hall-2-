$(document).ready(function(){
	//게시글 보고싶은 갯수대로 보기
	$("#listCountButton").click(function(){
		//적은 숫자 넘겨오기
		var listCount = $("#listCount").val();
		
		$.ajax({
			type:"POST",
			url:"/test/board/apprBoard",
			data:{"listCount" : listCount},
			success:function(data){
				alert("성공!!!!");
			},
			error:function(e){
				alert(e.responstText);
			}
		});
	});	
	
	
	//게시글 삭제 하시겠습니까?
	
	
});



