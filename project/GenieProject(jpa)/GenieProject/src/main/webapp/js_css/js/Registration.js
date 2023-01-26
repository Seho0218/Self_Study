$(function(){
	$("#idCheck").click(function(){
		window.open("/idCheck?genieId="+$("#genieId").val(),"idCheck","width=400,height=300");
	});

	$("#genieId").change(function(){
		$("#idCheckState").val("N");
	});
	//유효성 검사
	$("#logFrm").submit(function(){
		
		$("#genieId").change(function(){
			$("#idCheckState").val("N");
		});

		// 아이디, 비밀번호
		if($("#genieId").val().trim()===""){
			alert("아이디를 입력하세요");
			$("#genieId").focus();
			return false;
		}

		//아이디 중복검사여부
		if($("#idCheckState").val()!=='Y'){
			alert("아이디를 중복검사 하세요");
			return false;
		}

		if($("#geniePwd").val()===""){
			alert("비밀번호를 입력하세요");
			$("#geniePwd").focus();
			return false;
		}

		if($("#geniePwd").val()!==$("#geniePwd2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}

		// 전화번호
		if($("#userPhoneNum1").val()==="" || $("#userPhoneNum2").val()==="" || $("#userPhoneNum3").val()===""){
			alert("연락처를 입력하세요");
			return false;
		}

		// 이메일
		if($("#userEmail").val().trim()===""){
			alert("이메일을 입력하세요");
			$("#userEmail").focus();
			return false;
		}
		
		return true;

	});
});