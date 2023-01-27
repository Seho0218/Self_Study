<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
 @import url('https://fonts.googleapis.com/css?family=Poppins');

/* 기본구조 */

*{
  font-family: 'Noto Sans KR', sans-serif;
}

h1 {
  text-align: center;
  font-size: 30px;
  font-weight: 600;
  color: rgb(50, 50, 50); 
  margin-bottom: 50px;
  text-align: left;
}

h2 {
  text-align: center;
  font-size: 16px;
  font-weight: 600;
  text-transform: uppercase;
  display:inline-block;
  margin: 40px 8px 10px 8px; 
  color: #cccccc;
}
h3 {
  text-align: left;
  font-size: 16px;
  font-weight: 600;
  margin-left: 30px;
  color: #ccc; 
  margin-bottom: 50px;
}
p{
  text-align: left;
  font-size: 16px;
  font-weight: 600;
  margin-left: 30px;
  
  color: #363636; 
}
/*메인구조 */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 20px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.15);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.15);
  text-align: center;
}


/*타입별로 css 주기*/

input[type=button], input[type=submit] {
  background-color: #56baed;
  border: none;
  color: #fff;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 20px;
  width: 40%;
  border: 2px solid #f6f6f6;
  border-radius: 10px 10px 10px 10px;
}

input[type=text] {
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 10px;
  width: 88%;
  border: 2px solid #f6f6f6;
  border-radius: 10px 10px 10px 10px;
}

#fourth{
  background-color: #221a91;
  border: none;
  color: #fff;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 90%;
  border: 2px solid #f6f6f6;
  border-radius: 10px 10px 10px 10px;
}

#delete{
  background-color: #ff0000;
}

.comReg{
  background-color: #E162A2;
  border: none;
  color: #fff;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  border-radius: 10px 10px 10px 10px;
}
  </style>

<script>
function adcategoryDel(){
	if(confirm("${vo.category_id} 태그를 삭제하시겠습니까?")){
		location.href="/admin/adminCategoryDel?category_id=${vo.category_id}";
	}
}
</script>

<div class="wrapper">
  <div id="formContent">
    <!-- 타이틀 -->
    <h1>카테고리 관리</h1>

    <!-- 로그인폼-->
    <form method="post" action="/admin/adminCategoryPopEdit" id="adcategoryPopFrm">
    <p>카테고리아이디</p>
     	<input type="text" id="category_id" class="second" name="category_id" value=${vo.category_id}>
   	<p>카테고리</p>
   		<input type="text" id="category_id" class="second" name="product_category" value=${vo.product_category}>  	
      <input type="submit" class="fourth" value="수정">
      <a href="javascript:adminTagDel()"><input type="button" id="delete" value="삭제"></a>
      <a href="javascript:window.history.back()"><input type="button" id="fourth" value="뒤로가기"></a>
    </form>
  </div>
</div>