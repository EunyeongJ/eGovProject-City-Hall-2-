//대분류에 맞춰서 중분류 가져오기
function changeSelectCheck(val){
	console.log("onchange 여기 들어옴!");
	
	$.ajax({
		type:"POST",
		url:'../board/selectChangeCheck',
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


$(document).ready(function(){
	//table 추가
	$("#column_add").click(function(){
		
		//item의 최대번호 구하기
		var lastItemNo = $("#apprTable tr:last").attr("class").replace("item", ""); //속성이 "class"인...
		var newItem = $("#apprTable tr:eq(1)").clone();
		newItem.removeClass();
		newItem.find("td:eq(0)").attr("rowspan","1");
		newItem.addClass("item"+(parseInt(lastItemNo)+1)); //클래스에 1씩 더해준다.
		
		$("#apprTable").append(newItem);
	});
});


//table 삭제
$(document).on("click", "button[name=column_del]", function(){
	//var trHtml = $(this).parent().parent();    
    //trHtml.remove(); //tr 태그 삭제     
});