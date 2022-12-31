$(function(){
	$("#idCheck").click(function(){
		window.open("/idCheck?genie_id="+$("#genie_id").val(),"idCheck","width=400,height=300");
	});

	$("#genie_id").change(function(){
		$("#idCheckState").val("N");
	});
	//유효성 검사
	$("#logFrm").submit(function(){
		
		$("#genie_id").change(function(){
			$("#idCheckState").val("N");
		});

		// 아이디, 비밀번호
		if($("#genie_id").val().trim()==""){
			alert("아이디를 입력하세요");
			$("#genie_id").focus();
			return false;
		}

		//아이디 중복검사여부
		if($("#idCheckState").val()!='Y'){
			alert("아이디를 중복검사 하세요");
			return false;
		}

		if($("#genie_pwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#genie_pwd").focus();
			return false;
		}

		if($("#genie_pwd").val()!=$("#genie_pwd2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}

		// 전화번호
		if($("#user_phone_num1").val()=="" || $("#user_phone_num2").val()=="" || $("#user_phone_num3").val()==""){
			alert("연락처를 입력하세요");
			return false;
		}

		// 이메일
		if($("#user_email").val().trim()==""){
			alert("이메일을 입력하세요");
			$("#user_email").focus();
			return false;
		}
		
		return true;

	});
});