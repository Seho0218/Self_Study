<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ include file="../inc/top.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
.home{
		position: relative;
		width: 100%;
		/*height: 100vh;*/
		/*background: url(../img/background.jpg);*/
		background: #fafbfc;
		background-size: cover;
		background-position: center;
		display: grid;
		grid-template-columns: repeat(1, 1fr);
		align-items: center;
}
	.container{
		padding:30px;
		width:600px;
		height:1600px;
		background-color:white;
		margin:0 auto;
		font-size:20px;
		box-sizing: border-box;
		border-radius:15px;
		-webkit-border-radius: 10px 10px 10px 10px;
		-webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
    	box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
	    overflow:auto;
	}
	.tab {
		width:100%;
		height:50px;
		font-size:30px;
	}
	.tab>li:nth-child(2n+1){
		width:50%;
		text-align:center;
		float:left
	}
	.tab>li:nth-child(2n+2){
		width:50%;
		text-align:center;
		float:right;
	}
	#login{
		padding:10px 100px 10px 100px;
		display:block;
		margin:50px auto;
		font-size: 30px;
		background: #56D8FF;
		color: #fff;
		border-radius: 10px;
		transition: ease .40s;
	}
	
	.loginForm{
		width:400px;
		height:1000px;
		margin:30px auto;
        margin-top:0;
		padding:10px;
        padding-bottom:30px;
	}
	#idForm p,#passwordForm p,#phoneForm p,#addrForm p, #emailForm p,#user_gender p,#user_detailaddr p{
		padding:10px;
        padding-left:0;
	}
	#user_id, #user_pwd, #user_addr, #user_email,#user_detailaddr{
		width:100%;
		height:50px;
		border-radius:15px;
		font-size:30px;
		padding:20px;			
	}
    #user_phone_num1,#user_phone_num2,#user_phone_num3{
        width:29%;
		height:50px;
		border-radius:15px;
		text-align:center;
		font-size:20px;
    }
    #user_zipcode{
        width:33%;
		height:50px;
		border-radius:15px;
		font-size:30px;
		padding:10px;
    }
	#login:hover{
		background: #56D8FF;
		color: #48FFD5;
		transform: scale(1.1);
	}
    #address_kakao, #idCheck{
        padding:10px;
		display:inline-block;
		font-size: 15px;
		background: #56D8FF;
		color: #fff;
		border-radius: 10px;
		transition: ease .40s;
    }
	#idCheck{
		float:right;
		margin-bottom:10px;
	}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	window.onload = function(){
		document.getElementById("address_kakao").addEventListener("click", function(){ 
			//카카오 지도 발생
			new daum.Postcode({
				oncomplete: function(data) { //선택시 입력값 세팅
					document.getElementById("user_zipcode").value = data.zonecode; 
					document.getElementById("user_addr").value = data.address; 
				}
			}).open();
		});
	}
</script>
<script>
$(function(){
       	$("#logFrm").submit(function(){
			
			 //비밀번호
			if($("#user_pwd").val()==""){
				alert("비밀번호를 입력하세요");
				$("#user_pwd").focus();
				return false;
			}
			if($("#user_pwd").val()!=$("#userpwd2").val()){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}

			// 전화번호
			if($("#user_phone_num1").val()=="" || $("#user_phone_num2").val()=="" || $("#user_phone_num3").val()==""){
				alert("연락처를 입력하세요");
				return false;
			}
			return true;
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
    });
</script>
</head>
<body>
<section class="home">
	<div class="container">
			회원정보 수정
			<form method="get" action="/user/UserEditOk" id="logFrm">
				<ul class="loginForm">
					<div id="idForm">
						<p>아이디</p>
						<input type="text" id="user_id" name="user_id" value= "${vo.user_id}" readonly>
						<input type ="hidden" id = "idCheckState" value = "Y"/>
					</div>
					<div id="passwordForm">
						<p>비밀번호</p>
						<input type="password" id="user_pwd" name="user_pwd" placeholder="비밀번호를 입력하세요">
						<p>비밀번호 확인</p>
						<input type="password" id="user_pwd" name="user_pwd2" placeholder="비밀번호를 입력하세요">
					</div>
                    <div id="phoneForm">
						<p>휴대폰 번호</p>
                        <select id = "user_phone_num1" name = "user_phone_num1" size = "1" value = "${vo.user_phone_num1}">
							<option value="">선택하세요</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select>-
				        <input type ="text" name = "user_phone_num2" id ="user_phone_num2" maxlength = "4" value ="${vo.user_phone_num2}"/> -
			 	        <input type ="text" name = "user_phone_num3" id ="user_phone_num3" maxlength = "4" value ="${vo.user_phone_num3}"/>
					</div>
                    <div id="emailForm">
						<p>이메일</p>
						<input type="email" id="user_email" name="user_email" value =" ${vo.user_email}" placeholder="이메일을 입력하세요">
					</div>
                    <div id="addrForm">
                        <p>우편번호</p>
                        <p><input type ="text" name = "user_zipcode" id ="user_zipcode" value ="${vo.user_zipcode}" readonly />
                            <input type = "button" value = "우편번호찾기" id = "address_kakao"/><br/>
                        <p>주소</p>
                        <p><input type = "text" name = "user_addr" id ="user_addr" value="${vo.user_addr}" readonly/></p>
                        <p>상세주소</p>
                        <p><input type ="text" name = "user_detailaddr" id ="user_detailaddr" value="${vo.user_detailaddr}"/></p>	

					 <li><input type = "submit" id="login" value = "회원정보 수정"/></li>
				</ul>
			</form>
		</div>	
	</section>
	</body>
</html>
