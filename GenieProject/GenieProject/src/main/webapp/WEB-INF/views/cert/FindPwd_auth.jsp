<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

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
       margin-bottom: 15px;
   }
   
   button{
       width: 100px;
       background-color: #56baed;
       box-shadow: 0 0 15px #fbfbfb;
       border: none;
       padding: 10px;
       border-radius: 8px;
       color: #fff;
   }
   
   /*추가 되는 부분*/
   
   </style>

    <main>
		<div class="find_info">	
			<div class="find">
				<div id="find_by_email">
					<input type="radio" id="email" value="email" name="find">
					<label for="email">가입한 이메일로 찾기</label>
					
					<div class="auth">
						<input type="email" class="email" placeholder="이메일을 입력해주세요" maxlength="50">
						<button type="button" id="send_email">인증번호받기</button>
						<input type="text" class="auth_num" name="authNum" maxlength="6" readonly placeholder="인증번호6자리입력">
						<button id="next" disabled >다음</button>
                        <span class="timer"></span>
					</div>
				</div>			
			</div>
			
			
		</div>
	</main>
    
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>   
<script>

  $(document).ready(function(){
	
    const URLSearch = new URLSearchParams(location.search);
    const genie_id = URLSearch.get("genie_id"); 
    const inputBox = $("input[name=authNum]");
    const nextBox = $("#next");
   /* 인증번호 발송했는지 여부
    const authNum = (function(){
        let send = false;
        const isSend = function(set){
            if(!set) {
                return send;
            } else {
                send = set;
            }
        }
        return {isSend :send}
    })();
    */
    let send = false;
    const isSend = function(set){
            if(!set) {
                return send;
            } else {
                send = set;
            }
    }

         // 이메일로 인증번호 보내기
    $("#send_email").click(function(){
        const data = {
            user_email : $(".email").val(),
            genie_id : genie_id
        }
        if($(".email").val()=="") {
            alert("이메일을 정확히 입력해주세요");
            return;
        }
        
       
        
        $.ajax({
            url: "/cert/emailCheck",
            type: "GET",
            data : data
        })
        .then(function(result){
            if(result) {
                sendAuthNum({user_email : data.user_email}, function(){
                    sendAuthNumFnc();
                });
                
            } else {
                alert("가입하신 이메일과 일치하지 않습니다");
            }
        })
            .fail(function(){
                alert("이메일 에러");
            })
        })	

    // 인증번호 보내기
        function sendAuthNum(data, func){
            $.ajax({
                url: "/cert/authNum",
                type: "POST",
                data: data 
            })
            .then(function(result){
                alert(result); 
                sendAuthNumFnc();
            })
            .fail(function(){
                alert("인증번호 보내기 에러");
            })
        }
   
	
    // 인증번호 보낸 뒤 함수
    function sendAuthNumFnc(){
        inputBox.prop("readonly", false);
        nextBox.prop("disabled",false);
        inputBox.focus();
        // timer.start();
        //console.log(authNum);
        isSend(true);
        //console.log(send);
    }
    
 
  
 
    // 인증번호 입력 후 다음 버튼
    $("#next").click(function(){
        console.log("authNum.isSend->"+send);
        if(send == false) {
            alert("인증번호를 발송해주세요");
            return;
        }
        let authNumber = "";
        
        $("input[type=radio]:checked").each(function(){
            authNumber = $(this).siblings(".auth").find(".auth_num").val(); 
        })
        
        if(authNumber=="") {
            alert("인증번호 입력하세요...");
            return;
        }
        console.log(authNumber);
        $.ajax({
            url: "/cert/authNumCheck",
            type: "POST",
            data: {authNum : authNumber}
        })
        .then(function(ffff){

            authCompletion();
        })
        .fail(function(result){
            alert(result.responseText);
        })
    })

    // 인증완료 후 함수
    function authCompletion(){
        $.ajax({
            url: "/cert/authCOM",
            type: "POST",
        })
        .then(function(){
            location.href = "/cert/modify_pwd?genie_id=" + genie_id;
        })
        .fail(function(result){
            alert(result.responseText);
        })
    }
 
})

</script>