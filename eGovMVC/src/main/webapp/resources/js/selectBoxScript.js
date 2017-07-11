//대분류에 맞춰서 중분류 가져오기
function changeSelectCheck(val){
	console.log("onchange 여기 들어옴!");
	
	$.ajax({
		type:"POST",
		url:'/test/board/selectChangeCheck',
		data:{"groupCodeCD" : val},
		success:function(data){
			console.log("성공");		
				
			//id가 cd인 아이 밑에다가 옵션을 붙여넣어야 함....
			$("#cd").find("option").remove().end().append("<option> ---소분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
			for(var a=0; a<data.list.length; a++){
				console.log(data.list[a].cd+ " , "+data.list[a].cdnm); //콘솔 확인			
				$("#cd").append("<option value='"+data.list[a].cd+"'>"+ data.list[a].cdnm +"</option>") //중분류 가져오기
			}
	
		},
		error:function(e){
			e.responseText;
		}
	}); 
}