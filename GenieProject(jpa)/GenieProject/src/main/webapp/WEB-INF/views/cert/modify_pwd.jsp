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
   
   .pwd-button{
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

<section class="home">
<form method="post" action="/cert/modify_pwd" id="logFrm">
	<h3>비밀번호를 재 설정해주세요</h3>
    <div id="passwordForm">
		<input type="hidden" value="${genie_id}" name="genie_id"/>
		<p>새 비밀번호</p>
			<input type="password" id="genie_pwd" name="genie_pwd" placeholder="새 비밀번호를 입력하세요">
		<p>새 비밀번호 다시 입력</p>
			<input type="password" id="genie_pwd2" name="genie_pwd2" placeholder="새 비밀번호를 입력하세요"><br/><br/>
			<input type="submit" class="pwd-button" value="비밀번호 변경"/><br/>
	</div>
</form>
<section>

 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>   
<script>

    const URLSearch = new URLSearchParams(location.search);
    const genie_id = URLSearch.get("genie_id"); 


    $(function(){

        $("#logFrm").submit(function(){

            if($("#genie_pwd").val()==""){
                alert("비밀번호를 입력하세요..");
                $("#user_id").focus();

                return false;
            }

            if($("#genie_pwd").val() != $("#genie_pwd2").val()){
                alert("비밀번호가 일치하지 않습니다.");
                $("#genie_pwd").focus();

                return false;
            }
                return true;
            });
        });
    

</script>
