//게시글 쓰기전에 막기
function apprInsertCheck(){
	
	//group_cd가 비워져 있으면
	if(!($("input[name=group_cd]").val()) || $("input[name=group_cd]").val() == 'null'){
		alert("내역을 선택해 주세요.");
		
		return false;
	}
	
	//cd가 비워져 있으면
	if(!($("input[name=cd]").val()) || $("input[name=cd]").val() == 'null'){
		alert("상세 내역을 선택해 주세요.");
		
		return false;
	}
	
	//sp_div가 비워져 있으면
	if(!($("input[name=sp_div]").val()) || $("input[name=sp_div]").val() == 'null'){
		alert("지출구분을 선택해 주세요.");
		
		return false;
	}
	
	//sp_date가 비워져 있으면
	if(!($("input[name=sp_date]").val()) || $("input[name=sp_date]").val().trim() == 'null'){
		alert("지출일자를 선택해 주세요.");
		
		return false;
	}
	
	//sp_cont가 비워져 있으면
	if(!($("input[name=sp_cont]").val()) || $("input[name=sp_cont]").val().trim() == 'null'){
		alert("지출내역을 작성해 주세요.");
		
		return false;
	}
	
	//sp_pay가 비워져 있으면
	if(!($("input[name=sp_pay]").val()) || $("input[name=sp_pay]").val().trim() == 'null'){
		alert("지출 금액을 작성해 주세요.");
		
		return false;
	}
	
}











