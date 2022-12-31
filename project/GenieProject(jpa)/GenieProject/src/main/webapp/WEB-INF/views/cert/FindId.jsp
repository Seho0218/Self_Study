<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
 
 * {
	font-family: 'Noto Sans KR', sans-serif;
 }
.find_info {
	width: 350px;
	max-width: 90%;
	margin: 0 auto;
	margin-top: 50px;
}
 
.find_id_page .find_info input, .find_password_page .find_info input {
	border-radius: 15px;
	width: 75%;
	min-width: 150px;
	height: 30px;
	
}
input {
	background-color: #f5f5f7;
	border: 1px solid #c6c6c6;
	box-shadow: 0 0 15px #fbfbfb;
	padding: 10px;
	border-radius: 8px;
}

button{
	background-color: #56baed;
	box-shadow: 0 0 15px #fbfbfb;
	border: none;
	padding: 10px;
	border-radius: 8px;
	color: #fff;
}

/*추가 되는 부분*/
.alert {
    color: #004085;
    background-color: #cce5ff;
    border-color: #b8daff;
	padding: 10px;
	border-radius: 15px;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$(".find_btn").click(function() {
			const user_email = $("#user_email").val();
			if($("#user_email").val()==""){
          		alert("이메일을 입력하세요..");
          		return false;
        	}
		
			$.ajax({
				url: "/cert/sendUserId",
				type: "POST",
				data: { user_email : user_email }
			}).done(function() {
			const html =`<div class="send_email">
							<div class="alert">
								<h1>메일보내기 성공!</h1>
								<span>입력하신 이메일로 아이디를 전송했습니다.</span><br><br>
								<div>올바르지 않은 이메일 주소를 입력하신 경우에는 메일을 받을 수 없습니다.</div>	
							</div>		
						</div>`;
 



						
					$(".home").html(html);
 
			});
		});
	});
</script>

<section class="home">
    <div class="find_info">
		<h3>가입하신 이메일을 입력해주세요</h3>
		<input type="email" name="user_email" id="user_email">
		<button class="find_btn">찾기</button>
	</div>
<section>