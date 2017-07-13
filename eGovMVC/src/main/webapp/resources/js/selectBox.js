var count = 1;
$(document).ready(function(){
	alert("ajax 들어옴!!!");	
	
	//doc_num 가져옴
	var doc_num = $("#updateForm").val();
	console.log('doc_num : '+doc_num);	
	
	if(doc_num == null){//양식 작성 
		selectAdd();
		aaa();
	}else{//양식 수정 form
		getUpdateCode(doc_num);
	}	
		
	//추가 버튼 누르면 행 추가되게 만들기
	$("#column_add").click(function(){ 
		selectAdd();
		aaa();
	});	
});


//tr 한줄 추가
function selectAdd(){
		
	var contents = '';	
	contents += '<tr>';
	contents += 	'<td>';			
	contents += 		'<select id="group_cd'+count+'" name="group_cd" onchange="getCode('+count+')">';				
	contents += 			'<option value="00"> ---대분류--- </option>';		
	contents += 		'</select>';
	contents += 	'</td>';
	contents += 	'<td>';
	contents += 		'<select id="cd'+count+'" name="cd">';
	contents += 			'<option value="00"> ---소분류--- </option>';
	contents += 		'</select>';
	contents += 	'</td>';
	contents += 	'<td>';
	contents += 		'<select id="sp_div'+count+'" name="sp_div">';				
	contents += 			'<option value="00"> ---구분--- </option>';
	contents += 		'</select>';
	contents += 	'</td>';
	contents += 	'<td><input type="date" id="sp_date'+count+'" name="sp_date"></td>';
	contents += 	'<td><input type="text" id="sp_cont'+count+'" name="sp_cont"></td>';			
	contents += 	'<td><input type="text" id="sp_pay'+count+'" name="sp_pay"></td>';	
	contents += '</tr>';
		
	$("#apprTable").append(contents);	
	count++;
}

//대분류랑 구분 가져오기
function aaa() {
	var num = count -1;
	var data = '';
	
	//대분류
	data = getSelectCode('g_cd', null);
	if (data != 'error') {
		for(var a=0; a<data.list.length; a++){
			$("#group_cd"+num).append("<option value='"+data.list[a].cd+"'>"+ data.list[a].cdnm +"</option>")
		}	
	}	
	
	//구분
	data = getSelectCode('s_cd', null);
	if (data != 'error') {
		for(var a=0; a<data.list.length; a++){			
			$("#sp_div"+num).append("<option value='"+data.list[a].cd+"'>"+ data.list[a].cdnm +"</option>") //구분 가져오기
		}
	}
}

//소분류 가져오는 함수
function getCode(num){	
	var cdVal = $("#group_cd"+num).val();
	var data = getSelectCode('c_cd', cdVal);	
	
	if(data != 'error'){
		//대분류를 누르면 소분류를 가져온다.
		$("#cd"+num).find("option").remove().end().append("<option value='null'> ---소분류--- </option>"); //옵션 뜬거 지우고 새로 띄우기
		for(var a=0; a<data.list.length; a++){				
			$("#cd"+num).append("<option value='"+data.list[a].cd+"'>"+ data.list[a].cdnm +"</option>");
		}
	}
}

//ajax 바깥으로 꺼냄
function getSelectCode(str1, str2){	
	var result = '';
	
	$.ajax({
		type:"POST",
		url:'/test/board/selectCode',
		async:false, //전역변수에 받기
		data:{"chkCD":str1, "cdVal":str2},
		success:function(data){
			console.log("성공");
			result = data;
		},
		error:function(e){
			e.responseText;
			result = 'error';
		}
	});
	
	return result;
}

//저장 내역 가져오기
function getUpdateCode(doc_num){
	
	$.ajax({
		type:"POST",
		url:'/test/board/updateForm',
		data:{"doc_num" : doc_num},
		success:function(data){
			console.log("수정 게시글 가져오기 성공");
			console.log(data);
			
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
			
			
			//꺼내온 애들 for문
			for(var a=0; a<data.apprList.length; a++){
				selectAdd(); 
				aaa();	
				
				var num = count-1;				
				$("#group_cd"+num).val(data.apprList[a].group_cd).prop("selected", true);
				$("#sp_div"+num).val(data.apprList[a].sp_div).prop("selected", true);
				$("#sp_date"+num).val(data.apprList[a].sp_date).prop("selected", true);
				$("#sp_cont"+num).val(data.apprList[a].sp_cont).prop("selected", true);
				$("#sp_pay"+num).val(data.apprList[a].sp_pay).prop("selected", true);
				
				getCode(num);				
				$("#cd"+num).val(data.apprList[a].cd).prop("selected", true);
				
				
			}							
		},
		error:function(e){
			e.responseText;
		}
	});	
	
}



