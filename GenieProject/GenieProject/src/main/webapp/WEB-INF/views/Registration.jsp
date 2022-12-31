<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/top.jspf" %>
<link rel="stylesheet" href="./js_css/css/Registration.css">

<section class="registration">
	<div class="wrapper">
		<h1>일반회원 회원가입</h1>
		<%-- <input type="text" value="${logStatus=='Y' && role=='ROLE_USER'}"/> --%>
		<%-- <input type="text" value="${role}"/> --%>
		<form method="post" action="/UserWrite" id="logFrm">
			<input type="hidden" value="USER" name="ROLE"/>
			<ul class="idForm">
				<li>아이디</li>
				<li>
					<input type="text" id="genie_id" name="genie_id" placeholder="아이디를 입력하세요"/>
					<input type="button" id="idCheck" value="아이디 중복검사"/>
				</li>
				<input type ="hidden" id = "idCheckState" value = "N"/>
			</ul>
			<ul id="passwordForm">
				<li>비밀번호</li>
				<input type="password" id="genie_pwd" name="genie_pwd" value="123" placeholder="비밀번호를 입력하세요">
				<li>비밀번호 확인</li>
				<input type="password" id="genie_pwd2" name="genie_pwd2" value="123" placeholder="비밀번호를 입력하세요">
			</ul>
			<ul id="idForm">
				<li>이름</li>
				<input type="text" name="user_name" id="user_name" value="123" placeholder="이름을 입력하세요">
			</ul>
			<ul id="phoneForm">
				<li>휴대폰 번호</li>
				<select id = "user_phone_num1" name = "user_phone_num1" size = "1">
					<option value="">선택하세요</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
				<input type ="text" name = "user_phone_num2" id ="user_phone_num2" value="1234" maxlength = "4"/>
				<input type ="text" name = "user_phone_num3" id ="user_phone_num3" value="1234"maxlength = "4"/>
			</ul>
			<ul id="emailForm">
				<li>이메일</li>
				<input type="email" id="user_email" name="user_email" value="asdf@gmail.com"placeholder="이메일을 입력하세요">
			</ul>
			<ul id="user_gender">
				<li>성별</li>
				<input type="radio" name="user_gender" value="1"><label for="radio_male">남성</label>
				<input type="radio" name="user_gender" value="0"><label for="radio_female">여성</label>
			</ul>
				<input type = "submit" id="formSubmit" value = "회원가입하기"/>
		</form>
		
	</div>	
</section>KakaoAddress
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="../js_css/js/Registration.js"></script>