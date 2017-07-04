//로그인 회원아이디, 비밀번호 체크//////////////////////////////////////////////
function memberLoginCheck(){
	var mber_id = $("#mber_id").val();
	var mber_pw = $("#mber_pw").val();
	
	if( !($("#mber_id").val()) || $("#mber_id").val().trim() == ""){
		alert("회원 아이디를 입력해주세요.");
		$("#mber_id").focus();
		return false;
	}
	
	if( !($("#mber_pw").val()) || $("#mber_pw").val().trim() == ""){
		alert("회원 비밀번호를 입력해주세요.");
		$("#mber_pw").focus();
		return false;
	}
	
	$.ajax({
		type:"POST",
		url:"../member/memberLogin",
		data:{"mber_id" : mber_id, "mber_pw" : mber_pw},
		success:function(data){
			if(data == 'success'){
				location.href = "../member/apprBoard";
			}else{
				alert("로그인에 실패하였습니다. 아이디와 비밀번호를 다시 입력해주세요.");
				$("#mber_id").val('');
				$("#mber_pw").val('');
			}
		},
		error:function(e){
			alert(e.responstText);
		}
	});
}