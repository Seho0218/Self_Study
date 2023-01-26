$(function(){
	$("#PwdEdit").click(function(){
		window.open("/user/PwdEdit","PwdEdit","width=400,height=300");
	});
	
	//유효성 검사
    $("#logFrm").submit(function(){
		// 전화번호
		if($("#userPhoneNum1").val()==="" || $("#userPhoneNum2").val()==="" || $("#userPhoneNum3").val()===""){
			alert("연락처를 입력하세요");
			return false;
		}
		// 우편번호
		if($("#zipCode").val()===""){
			alert("우편번호를 선택하세요");
			$("#zipCode").focus();
			return false;
		}
		if($("#addr").val()===""){
			alert("주소를 입력하세요");
			$("#addr").focus();
			return false;
		}
		if($("#detailAddr").val()===""){
			alert("상세 주소를 입력하세요");
			$("#detailAddr").focus();
			return false;
		}
		// 이메일
		if($("#userEmail").val()===""){
			alert("이메일을 입력하세요");
			$("#userEmail").focus();
			return false;
		}			
		return true;
	});
})