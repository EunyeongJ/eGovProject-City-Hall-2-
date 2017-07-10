$(document).ready(function(){
	alert("들어옴!");	
	getCode();
});

function getCode(){
	
	$.ajax({
		type:"POST",
		url:'/test/board/selectCode',
		success:function(data){
			console.log("성공");
			
			//$("#group_cd").find("option").remove().end().append("<option> ---대분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
			for(var a=0; a<data.length; a++){
				console.log(data[a].cd+ " , "+data[a].cdnm); //콘솔 확인			
				$("#group_cd").append("<option value='"+data[a].cd+"'>"+ data[a].cdnm +"</option>") //대분류 가져오기
			}
			
			
	
		},
		error:function(e){
			e.responseText;
		}
	});
	
}
