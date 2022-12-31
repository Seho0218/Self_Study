$(function(){
	$("#PwdEdit").click(function(){
		window.open("/user/PwdEdit","PwdEdit","width=400,height=300");
	});
	
	//유효성 검사
    $("#logFrm").submit(function(){
		// 전화번호
		if($("#user_phone_num1").val()=="" || $("#user_phone_num2").val()=="" || $("#user_phone_num3").val()==""){
			alert("연락처를 입력하세요");
			return false;
		}
		// 우편번호
		if($("#user_zipcode").val()==""){
			alert("우편번호를 선택하세요");
			$("#user_zipcode").focus();
			return false;
		}
		if($("#user_addr").val()==""){
			alert("주소를 입력하세요");
			$("#user_addr").focus();
			return false;
		}
		if($("#user_detailaddr").val()==""){
			alert("상세 주소를 입력하세요");
			$("#user_detailaddr").focus();
			return false;
		}
		// 이메일
		if($("#user_email").val()==""){
			alert("이메일을 입력하세요");
			$("#user_email").focus();
			return false;
		}			
		return true;
	});
})