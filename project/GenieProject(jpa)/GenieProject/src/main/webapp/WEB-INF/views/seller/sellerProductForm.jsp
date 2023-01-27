<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<style>
#formbody{
	padding-top: 10px;
	padding-left: 100px;
	padding-right: 100px;
}
.content-wrapper{
	overflow-y:scroll;
	-ms-overflow-style: none;
}
.content-wrapper::-webkit-scrollbar{
  display:none;
}

/*---------------------------------*/
#main {
  margin-left: 100px;
  margin-right: 100px;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

#formSubmit{
		padding:10px 100px 10px 100px;
		display:block;
		margin:50px auto;
		font-size: 17px;
		background: #3385ff;
		color: #fff;
		border:none;
		border-radius: 10px;
		transition: ease .40s;
	}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: none;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.col-65 {
  float: left;
  width: 65%;
  margin-top: 6px;
}

.row{
	margin-bottom: 10px;
}

input[type=checkbox]{
	margin-right: 5px;
}

input[type=text]{
	margin-bottom: 5px;
}

#mbticheck{
	padding-top: 13px;
}

#subtitle{
	padding-left:80px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		
		
		$("#productFrm").submit(function(){
			//유효성검사
			//상품명
			if($("#product_name").val()==""){
				alert("상품명을 입력하세요.");
				return false;
			}
			//금액
			if($("#product_price").val()==""){
				alert("판매금액을 입력하세요.");
				return false;
			}
			//상품설명
			if($("#product_info").val()==""){
				alert("상품설명을 입력하세요.");
				return false;
			}
			//상품수량
			if($("#product_quantity").val()==""){
				alert("상품수량을 입력하세요.");
				return false;
			}
			//이미지1
			if($("#product_image1").val()==""){
				alert("상품이미지(1)의 링크를 입력하세요.");
				return false;
			}
			//이미지2
			if($("#product_image2").val()==""){
				alert("상품이미지(2)의 링크를 입력하세요.");
				return false;
			}
			//이미지3
			if($("#product_image3").val()==""){
				alert("상품이미지(3)의 링크를 입력하세요.");
				return false;
			}
			//카테고리
			if($("input:checkbox[name=categoryList]:checked").length<1){
				alert("카테고리를 선택하세요.")
				return false;
			}
			if($("input:checkbox[name=categoryList]:checked").length>2 ){
				alert("카테고리를 2개 이하로 선택하세요.")
				return false;
			}
			//태그
			if($("input:checkbox[name=tagList]:checked").length<4){
				alert("태그를 선택하세요.")
				return false;
			}
			if($("input:checkbox[name=tagList]:checked").length>8){
				alert("태그를 각각 2개 이하로 선택하세요.")
				return false;
			}
			//mbti
			if($("input:checkbox[name=mbtiList]:checked").length<1){
				alert("MBTI를 선택하세요.")
				return false;
			}
			if($("input:checkbox[name=mbtiList]:checked").length>4){
				alert("MBTI를 4개 이하로 선택하세요.")
				return false;
			}
			//---유효성검사 끝------------------------
			return true;
		});
		
	});
	
	
</script>
<%@ include file="../inc/sellerNav.jsp"%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<div class="content-header">
			<div class="container-fluid">
			<div class="row mb-2">
				
				<div class="col-sm-6" id="subtitle">
				<ol class="breadcrumb float-sm-left" >
					<li class="breadcrumb-item"><a href="/seller/sellerMain"style="color:gray;">Main</a></li>
					<li class="breadcrumb-item active" style="color: #047bff;">Product Register</li>
					</ol>
				</div><!-- /.col -->
			</div><!-- /.row -->
			</div><!-- /.container-fluid -->
		</div>
		
		<!-- Main content -->
		<div id="main">
			<div class="card card-primary card-outline">	
				<div class="content" id="formbody">
					<div class="container">
						<form method="post" action="/seller/productWrite" id="productFrm">
							<div class="row">
								<div class="col-25">
									<label for="product_name" style="font-size: 20px; color:#047bff; margin-bottom: 0px;">상품등록</label>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-25">
									<label for="product_name">상품명</label>
								</div>
								<div class="col-75">
									<input type="text" id="product_name" name="product_name" placeholder="상품명을 입력하세요"/>
								</div>
							</div>
								
							<div class="row">
								<div class="col-25">
									<label for="product_price">판매금액</label>
								</div>
								<div class="col-75">
									<input type="text" id="product_price" name="product_price" placeholder="판매금액을 입력하세요"/>
								</div>
							</div>
								
							<div class="row">
								<div class="col-25">
									<label for="product_quantity">상품수량</label>
								</div>
								<div class="col-75">
									<input type="text" id="product_quantity" name="product_quantity" placeholder="상품수량을 입력하세요"/>
								</div>
							</div>
								
							<div class="row">
								<div class="col-25">
									<label for="product_image">상품이미지</label>
								</div>
								<div class="col-75" id="proimage">
									<input type="text" name="product_image1" id="product_image1" placeholder="이미지링크를 입력하세요"/>
									<input type="text" name="product_image2" id="product_image2" placeholder="이미지링크를 입력하세요"/>
									<input type="text" name="product_image3" id="product_image3" placeholder="이미지링크를 입력하세요"/>
								</div>
							</div>	
							<div class="row">
								<div class="col-25">
									<label for="product_info">상품설명</label>
								</div>
								<div class="col-75">
									<textarea rows="4" id="product_info" name="product_info"></textarea>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-25">
									<label for="category">카테고리</label>
								</div>
								<div class="col-75">
									<label><span><input type="checkbox" name="categoryList" value="생일"/>생일</span></label>
									<label><span><input type="checkbox" name="categoryList" value="기념일"/>기념일</span></label>
									<label><span><input type="checkbox" name="categoryList" value="명절"/>명절</span></label>
									<label><span><input type="checkbox" name="categoryList" value="집들이"/>집들이</span></label>
									<label><span><input type="checkbox" name="categoryList" value="서프라이즈"/>서프라이즈</span></label>
									<label><span><input type="checkbox" name="categoryList" value="응원"/>응원</span></label>
									<label><span><input type="checkbox" name="categoryList" value="캠핑"/>캠핑</span></label>
									<label><span><input type="checkbox" name="categoryList" value="반려동물"/>반려동물</span></label>
									<label><span><input type="checkbox" name="categoryList" value="운동"/>운동</span></label>
									<label><span><input type="checkbox" name="categoryList" value="키덜트"/>키덜트</span></label>
									<label><span><input type="checkbox" name="categoryList" value="요리"/>요리</span></label>
									<label><span><input type="checkbox" name="categoryList" value="홈파티"/>홈파티</span></label>
								</div>
							</div>	
							<hr>
							<div class="row">
								<div class="col-25">
									<label for="product_tag">태그</label>
								</div>
								<div class="col-75">
									<li><label for="subTag">대상</label></li>
									<label><span><input type="checkbox" name="tagList" value="부모님"/>부모님</span></label>
									<label><span><input type="checkbox" name="tagList" value="배우자"/>배우자</span></label>
									<label><span><input type="checkbox" name="tagList" value="연인"/>연인</span></label>
									<label><span><input type="checkbox" name="tagList" value="가족/친척"/>가족/친척</span></label>
									<label><span><input type="checkbox" name="tagList" value="친구/지인"/>친구/지인</span></label>
									<label><span><input type="checkbox" name="tagList" value="회사동료"/>회사동료</span></label>
									<label><span><input type="checkbox" name="tagList" value="스승/멘토"/>스승/멘토</span></label>
								</div>
							</div>
						
							<div class="row">
								<div class="col-25">
									<label for="product_tag" style="opacity:0%">태그</label>
								</div>
								<div class="col-75">
									<li><label for="subTag">특정기념일</label></li>
									<label><span><input type="checkbox" name="tagList" value="감사"/>감사</span></label>
									<label><span><input type="checkbox" name="tagList" value="위로"/>위로</span></label>
									<label><span><input type="checkbox" name="tagList" value="결혼"/>결혼</span></label>
									<label><span><input type="checkbox" name="tagList" value="출산"/>출산</span></label>
									<label><span><input type="checkbox" name="tagList" value="임신"/>임신</span></label>
									<label><span><input type="checkbox" name="tagList" value="백일"/>백일</span></label>
									<label><span><input type="checkbox" name="tagList" value="개업"/>개업</span></label>
								</div>
							</div>
			
							<div class="row">
								<div class="col-25">
									<label for="product_tag" style="opacity:0%">태그</label>
								</div>
								<div class="col-75">
									<li><label for="subTag">나이</label></li>
									<label><span><input type="checkbox" name="tagList" value="10대이하"/>10대이하</span></label>
									<label><span><input type="checkbox" name="tagList" value="20대"/>20대</span></label>
									<label><span><input type="checkbox" name="tagList" value="30대"/>30대</span></label>
									<label><span><input type="checkbox" name="tagList" value="40대"/>40대</span></label>
									<label><span><input type="checkbox" name="tagList" value="50대"/>50대</span></label>
									<label><span><input type="checkbox" name="tagList" value="60대"/>60대이상</span></label>
								</div>
							</div>
					
							<div class="row">
								<div class="col-25">
									<label for="product_tag" style="opacity:0%">태그</label>
								</div>
								<div class="col-75">
									<li><label for="subTag">성별</label></li>
									<label><span><input type="checkbox" name="tagList" value="남성"/>남성</span></label>
									<label><span><input type="checkbox" name="tagList" value="여성"/>여성</span></label>
								</div>
							</div>
							<hr>	
							<div class="row">
								<div class="col-25">
									<label for="category">MBTI</label>
								</div>
								<div class="col-75" id="mbticheck">
									<p class="subTag">E : 외향형 (사교적,활동적) / I : 내향형 (정적,신중함)</p>
									<label><span><input type="checkbox" name="mbtiList" value="E"/>E</span></label>
									<label><span><input type="checkbox" name="mbtiList" value="I"/>I</span></label>
									<p class="subTag">S : 감각형 (실용적,현실적) / N : 직관형 (이상적,비약적)</p>
									<label><span><input type="checkbox" name="mbtiList" value="S"/>S</span></label>
									<label><span><input type="checkbox" name="mbtiList" value="N"/>N</span></label>
									<p class="subTag">T : 사고형 (객관적,합리적) / F : 감정형 (상황적,공감성)</p>
									<label><span><input type="checkbox" name="mbtiList" value="T"/>T</span></label>
									<label><span><input type="checkbox" name="mbtiList" value="F"/>F</span></label>
									<p class="subTag">J : 판단형 (계획적,체계적) / P : 인식형 (즉흥적,융통성)</p>
									<label><span><input type="checkbox" name="mbtiList" value="J"/>J</span></label>
									<label><span><input type="checkbox" name="mbtiList" value="P"/>P</span></label>
								</div>
							</div>
							<div class="row">
								<input type="submit" id="formSubmit" value="상품등록"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>		
		<!-- /.content -->
	</div>

  <%@ include file="../inc/sellerFooter.jsp"%>
<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/js_css/dist/js/adminlte.min.js"></script>
                  