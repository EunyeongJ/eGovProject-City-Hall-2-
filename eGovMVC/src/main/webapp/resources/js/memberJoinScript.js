//아이디 중복확인/////////////////////////////////////////////////////////////
function confirmId(){
	var mber_id = $("#mber_id").val();
	
	if( !($("#mber_id").val()) ||  $("#mber_id").val().trim == ""){
		alert("회원 아이디를 입력하세요.");
	}
	
	$.ajax({
		type:"POST",
		url:"../member/memberJoinConfirmId",
		data:{"mber_id" : mber_id},
		success:function(data){
			if(data == 'success'){
				alert("사용가능한 ID입니다.");
				$("#id_check").val('Y'); //중복확인 했다.
			}else{
				alert("이미 사용중인 ID입니다.");
				$("#id_check").val('N');
			}
		},
		error:function(e){
			alert(e.responstText);
		}
	});	
}

//아이디 수정하면 다시 중복확인하게하기//////////////////////////////////////
function reConfirmId(){
	
}

//회원가입 입력 확인///////////////////////////////////////////////////
function memberJoinCheck(){
	
	//아이디 입력
	if( !($("#mber_id").val()) ||  $("#mber_id").val().trim == ""){
		alert("아이디를 입력하세요.");
		$("#mber_id").focus();
		return false;
	}
	
	//아이디 중복확인
	if($("#id_check").val() == 'N'){
		alert("아이디 중복 확인을 해주세요.");
		$("#mber_id").focus();
		return false;
	}
	
	//비밀번호 입력
	if( !($("#mber_pw").val()) ||  $("#mber_pw").val().trim == ""){
		alert("비밀번호 입력하세요.");
		$("#mber_pw").focus();
		return false;		
	}
	
	//비밀번호 입력
	if( !($("#mber_nm").val()) ||  $("#mber_nm").val().trim == ""){
		alert("이름을 입력하세요.");
		$("#mber_nm").focus();
		return false;
	}	
}