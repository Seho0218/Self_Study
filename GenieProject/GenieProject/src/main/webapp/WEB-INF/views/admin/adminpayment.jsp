<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf" %>

<style>
/* 뒤에 회색배경 */
.registration {
    width: 100%;
    padding: 3% 33%;
    background: #f5f5f7;
}
/* 안쪽 흰색폼 설정 */
.wrapper {
	display: flex;
    flex-direction: column; 
    width: 100%;
	padding: 5%;
    background: #fff;
	border-radius: 10px;
	box-shadow: 0 0 15px #b4b4b4;
}
/* 일반회원 회원가입 */
.wrapper h1 {
	margin: 1em;
	font-weight: bold;
	text-align: center;
}
/* 전체적인 (글자) */
.wrapper li {
	font-weight: bold;
	margin: .5em;
}
/* 아이디를 입력하세요 */
#genie_id {
	width: 63%;
}
/* 아이디중복검사 */
#idCheck {
	width: 33%;
	padding: .5em;
	font-size: 1em;
	background: #F7D25A;
	color: #fff;
	border: none;
	border-radius: 10px;
	cursor: pointer;
}
/* ------------------------------------------------------------------------------- */
input[type=text], input[type=password], input[type=email] {
	width: 100%;
	height: 5vh;
	background-color: #f5f5f7;
	color: #1d1d1f;
	font-size: 1em;
	padding: 1em;
	margin: .3em;
	border: none;
	border-radius: 10px;
}
/* 폰입력 설정 */
#user_phone_num1 {
	width: 25%;
	height: 5vh;
	margin-left: 1em;
	background-color: #f5f5f7;
	color: #1d1d1f;
	font-size: 1em;
	border: none;
	border-radius: 10px;
}
#user_phone_num2, #user_phone_num3 {
	width:30%;
}
/* 우편번호 설정*/
#user_zipcode {
	width: 63%;
}

#address_kakao {
	width: 33%;
	padding: .5em;
	font-size: 1em;
	background: #F7D25A;
	color: #fff;
	border: none;
	border-radius: 10px;
	cursor: pointer;
}
/* --------------------------------------------------------------------------------- */
input[type=radio] {
	margin-left: 1.5em;
}
label {
	font-weight: bold;
}
/* --------------------------------------------------------------------------------- */
#formSubmit {
	display: flex;
	justify-content: center;
	padding: .5em 5em;
	margin: 10% auto;
	font-size: 1.5em;
	background: #F7D25A;
	color: #fff;
	border:none;
	border-radius: 10px;
	cursor: pointer;
}
</style>

<script>
$(function(){
	$("#idCheck").click(function(){
		window.open("/user/idCheck?genie_id="+$("#genie_id").val(),"idCheck","width=400,height=300");
	});

	$("#genie_id").change(function(){
		$("#idCheckState").val("N");
	});
});
</script>
<section class="registration">
	<div class="wrapper">
		<h1>결제페이지 테스트</h1>
		<form method="post" action="/admin/adminpaymentOk" id="logFrm">
			<input type="hidden" value="1" name="member_type"/>
			<ul id="idForm">
				<li>카트넘버</li>
				<input type="text" name="cart_num" id="cart_num" value="2" placeholder="카트넘버">
			</ul>
			<ul id="idForm">
				<li>지니아이디</li>
				<input type="text" name="genie_id" id="genie_id" value="1234" placeholder="지니아이디">
			</ul>
			<ul id="idForm">
				<li>제품아이디</li>
				<input type="text" name="product_id" id="product_id" value="1234" placeholder="제품아이디">
			</ul>
			<ul id="idForm">
				<li>가격</li>
				<input type="text" name="cart_price" id="cart_price" value="10000" placeholder="가격">
			</ul>
			<ul id="idForm">
				<li>카트수량</li>
				<input type="text" name="cart_qty" id="cart_qty" value="1" placeholder="수량">
			</ul>
			<ul id="idForm">
				<li>날짜</li>
				<input type="text" name="cart_writedate" id="cart_writedate" value="2022.09.30" placeholder="날짜">
			</ul>
				<input type = "submit" id="formSubmit" value = "결제하기"/>
		</form>
		
	</div>	
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>