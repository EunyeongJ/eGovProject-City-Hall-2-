var count = 1;
$(document).ready(function(){
	alert("들어옴!");		
	getCode(1); //처음에는 1이니까 1로 시작...
	
	//추가 버튼 누르면 행 추가되게 만들기
	$("#column_add").click(function(){      
		++count;
		
		var contents = '';
		
		contents += '<tr>';
		contents += 	'<td>';			
		contents += 		'<select id="group_cd'+count+'" name="group_cd" onchange="getCode('+count+')">';				
		contents += 			'<option value="null"> ---대분류--- </option>';		
		contents += 		'</select>';
		contents += 	'</td>';
		contents += 	'<td>';
		contents += 		'<select id="cd'+count+'" name="cd">';
		contents += 			'<option value="null"> ---소분류--- </option>';
		contents += 		'</select>';
		contents += 	'</td>';
		contents += 	'<td>';
		contents += 		'<select id="sp_div'+count+'" name="sp_div">';				
		contents += 			'<option value="null"> ---구분--- </option>';
		contents += 		'</select>';
		contents += 	'</td>';
		contents += 	'<td><input type="date" id="sp_date" name="sp_date"></td>';
		contents += 	'<td><input type="text" id="sp_cont" name="sp_cont"></td>';			
		contents += 	'<td><input type="text" id="sp_pay" name="sp_pay"></td>';	
		contents += '</tr>';
			
		$("#apprTable").append(contents);	
		getCode(count); //추가를 누르고 나서는 count를 올려준 애를 call
		
	});	
});

function getCode(code){	
	//얘는 누르는 애의 번호를 가져와서 붙여야 한다.
	alert("getCode");
	
	//1이면 대분류, 2면 소분류, 3이면 구분...
	var value1 = $("#group_cd"+code).val(); //1의 value
	var value2 = $("#cd"+code).val(); //2의 value
	var value3 = $("#sp_div"+code).val(); //3의 value
	console.log('value1 : '+value1+', value2 : '+value2+', value3 : '+value3);
	
	$.ajax({
		type:"POST",
		url:'/test/board/selectCode',
		data:{"1":value1, "2":value2, "3":value3},
		success:function(data){
			console.log("성공");
			
			//대분류랑 구분 가져오기...
			if(data.code1 == 1 && data.code3 == 3){ //조건정리
				//$("#group_cd").find("option").remove().end().append("<option value='null'> ---대분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
				for(var a=0; a<data.list1.length; a++){
					console.log(data.list1[a].cd+ " , "+data.list1[a].cdnm); //콘솔 확인			
					$("#group_cd"+code).append("<option value='"+data.list1[a].cd+"'>"+ data.list1[a].cdnm +"</option>") //대분류 가져오기
				}
				
				for(var a=0; a<data.list3.length; a++){
					console.log(data.list3[a].cd+ " , "+data.list3[a].cdnm); //콘솔 확인			
					$("#sp_div"+code).append("<option value='"+data.list3[a].cd+"'>"+ data.list3[a].cdnm +"</option>") //구분 가져오기
				}
			}
			
			//대분류를 누르면 소분류를 가져온다.
			if(data.code2 == 2){ //조건 정리
				$("#cd"+code).find("option").remove().end().append("<option value='null'> ---소분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
				for(var a=0; a<data.list2.length; a++){
					console.log(data.list2[a].cd+ " , "+data.list2[a].cdnm); //콘솔 확인			
					$("#cd"+code).append("<option value='"+data.list2[a].cd+"'>"+ data.list2[a].cdnm +"</option>") //대분류 가져오기
				}
			}			
	
		},
		error:function(e){
			e.responseText;
		}
	});
	
	console.log('count : '+count);	
}

