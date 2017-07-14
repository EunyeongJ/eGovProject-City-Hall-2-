$(document).ready(function(){
	
	//default 5,5...ㅜㅜ
	//listCountChange("defaultCount", 5);
	
	//게시글 갯수 
	$("#listCountButton").click(function(){
		
		if( !($("#listCount").val()) || $("#listCount").val().trim() == ''){
			alert("개수를 입력해주세요.");
			
			return false;
		};
		
		var listCount = $("#listCount").val();	
		listCountChange("listCount", listCount);
		$("#listCount").val('');		
	});
	
	//블럭 갯수
	$("#blockCountButton").click(function(){
		
		if( !($("#blockCount").val()) || $("#blockCount").val().trim() == ''){
			alert("개수를 입력해주세요.");
			
			return false;
		};		
		
		var blockCount = $("#blockCount").val();
		listCountChange("blockCount", blockCount);
		$("#blockCount").val('');
	});
	
});

//ajax...
function listCountChange(checkNm, listCheck){
	
	//var result = '';
	
	$.ajax({
		type:"POST",
		async:false,
		url:"/test/board/apprBoard/1",
		data:{"checkNm" : checkNm, "listCheck" : listCheck},
		success:function(data){
			location.href="/test/board/apprBoard/1";
			return false;
		},
		error:function(e){
			result = 'error';
		}
	});	
	
	//return result;
}







