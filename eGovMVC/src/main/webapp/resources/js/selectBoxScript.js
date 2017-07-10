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

//글을 작성하고 추가를 누르면 새로운 양식이 떠야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!수정하기
$(document).ready(function(){
	//table 추가
	$("#column_add").click(function(){		
		
		/*var count = 1;
		var contents='';
		
		content += '<tr class="item1">';	
		content +=	'<td>';				
		content +=	'<select id="group_cd" name="group_cd" onchange="changeSelectCheck(this.value)">';
		content +=		'<option value="null"> ---대분류--- </option>';
		content +=		'<c:forEach var="groupCode" items="${groupCode}" varStatus="status">';
		content +=			'<option value="${groupCode.cd}"> ${groupCode.cdnm} </option>';
		content +=		'</c:forEach>';				
		content +=	'</select>';
		content +=	'</td>';
		
		content +=	'<td>';				
		content +=		'<select id="cd" name="cd">'
		content +=			'<option value="null"> ---소분류--- </option>';
		content +=		'</select>';
		content +=	'</td>';
		
		content +=	'<td>';
		content +=		'<select id="sp_div" name="sp_div">';
		content +=			'<option value="null"> ---구분--- </option>';
		content +=			'<c:forEach var="apprGroupCode" items="${apprGroupCode}" varStatus="status">';
		content +=				'<option value="${apprGroupCode.cd}"> ${apprGroupCode.cdnm} </option>';
		content +=			'</c:forEach>';				
		content +=		'</select>';			
		content +=	'</td>';
		
		content +=	'<td><input type="date" id="sp_date" name="sp_date"></td>';
		content +=	'<td><input type="text" id="sp_cont" name="sp_cont"></td>';			
		content +=	'<td><input type="text" id="sp_pay" name="sp_pay"></td>';		
		content += '</tr>';
		
		$("#apprTable").append(contents);*/
		
	});
	
	
	
	//table 추가
	/*$("#column_add").click(function(){
		
		//item의 최대번호 구하기
		var lastItemNo = $("#apprTable tr:last").attr("class").replace("item", ""); //속성이 "class"인...		
		var newItem = $("#apprTable tr:eq(2)").clone(); //tr을 복제
		newItem.removeClass();
		newItem.find("td:eq(0)").attr("rowspan","1");
		newItem.addClass("item"+(parseInt(lastItemNo)+1)); //클래스에 1씩 더해준다.
		
		$("#apprTable").append(newItem);
	});*/
	
	//table 삭제
	$("#column_del").click(function(){
		
	});
});
