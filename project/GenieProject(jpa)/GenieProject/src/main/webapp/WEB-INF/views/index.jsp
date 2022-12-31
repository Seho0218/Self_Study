<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/top.jspf"%>
<link rel="stylesheet" href="/js_css/css/index_style.css" type="text/css"/>

<!--Genie 메인화면--->
<section class="index">
   <div class="index-list">      
      <a href="/genie"><img src="/image/main_banner1.png"></a>
      <button class="button"><a href="/genie">Genie 바로가기 ▶</a></button>
   </div>

   <div class="category" id="category">
      <h1>카테고리</h1>
      <div class="category-list">
         <span><a href="/product?product_category=생일"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20220223091003_007dc2b6f60645a8bc2682e97914b829.jpg"></a><br>생일</span>
         <span><a href="/product?product_category=기념일"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20201230162217_a70c12a712654a93abff864fa4b8c4c8.jpg"></a><br>기념일</span>
         <span><a href="/product?product_category=명절"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20210914165131_70edddb11adf42b9990c00dbc256e159.jpg"></a><br>명절</span>
         <span><a href="/product?product_category=집들이"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20220719152430_cebe5a5c6ffe441d915d86fb9252cd3c.jpg"></a><br>집들이</span>
         <span><a href="/product?product_category=서프라이즈"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20220824221511_46cfa4fe71924de994089f8e72fa3f0b.jpeg"></a><br>서프라이즈</span>
         <span><a href="/product?product_category=응원"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20211005162429_5cbf39fcbe2d46808d8062529a6dce0c.jpg"></a><br>응원</span>
         <span><a href="/product?product_category=캠핑"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20210204142320_8234442ad995426b9d435a6c517b03f6.jpg"></a><br>캠핑</span>
         <span><a href="/product?product_category=반려동물"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20220811095044_2727e0aefe8041bc80816bb2608ba7d1.jpg"></a><br>반려동물</span>
         <span><a href="/product?product_category=운동"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20211118135132_e0dcbca05541406bb068af2ae1060846.jpg"></a><br>운동</span>
         <span><a href="/product?product_category=키덜트"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20211120143602_cdfc50813bb04f8fb564baedc545944b.jpg"></a><br>키덜트</span>
         <span><a href="/product?product_category=요리"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20200306123008_899deea4eb61446592892a873765dc55"></a><br>요리</span>
         <span><a href="/product?product_category=홈파티"><img src="https://img1.kakaocdn.net/thumb/C600x600.fwebp.q82/?fname=https%3A%2F%2Fst.kakaocdn.net%2Fproduct%2Fgift%2Fproduct%2F20211209174807_32d9b22304584f5e9323e8978631440e.jpg"></a><br>홈파티</span>
      </div>
   </div>
   
   <!--
   <div class="ranking-list">
      <h1>고민될 땐 선물랭킹!<h1>
      <div>
         <a href="/product?product_tag=여성"><img src="/image/gender_female_long.png"></a>
         <a href="/product?product_tag=남녀공용"><img src="/image/gender_all_long.png"></a>
         <a href="/product?product_tag=남성"><img src="/image/gender_male_long.png"></a>
      </div>
   <div>
   -->

   <div class="best-tag" id="tag">
      <h1>모두의 인기 태그</h1>
      <div class="tag-button">
      <!-- 
      <c:forEach var="tvo" items="${tlist}">
         <button onclick="location.href='/product?product_tag=${tvo.product_tag}'">#${tvo.product_tag}</button>
      </c:forEach>
      -->
         <button onclick="location.href='/product?product_tag=집들이'" style="background-color:#fc7592">#집들이</button>
         <button onclick="location.href='/product?product_tag=20대'" style="background-color:#fbbb63">#20대</button>
         <button onclick="location.href='/product?product_tag=여성'" style="background-color:#fd977c">#여성</button>
         <button onclick="location.href='/product?product_tag=부모님'" style="background-color:#25dae6">#부모님</button>
         <button onclick="location.href='/product?product_tag=회사동료'" style="background-color:#25dae6">#회사동료</button>
         <button onclick="location.href='/product?product_tag=결혼'" style="background-color:#fc7592">#결혼</button> 
         <button onclick="location.href='/product?product_tag=백일'" style="background-color:#fc7592">#백일</button> 
         <button onclick="location.href='/product?product_tag=연인'" style="background-color:#25dae6">#연인</button> 
         <button onclick="location.href='/product?product_tag=가족/친척'" style="background-color:#25dae6"> #가족/친척</button> 
         <button onclick="location.href='/product?product_tag=스승/멘토'" style="background-color:#25dae6">#스승/멘토</button> 
         <button onclick="location.href='/product?product_tag=30대'" style="background-color:#fbbb63">#30대</button> 
         <button onclick="location.href='/product?product_tag=친구'" style="background-color:#25dae6">#친구</button> 
         <button onclick="location.href='/product?product_tag=출산'" style="background-color:#fc7592">#출산</button> 
         <button onclick="location.href='/mbti/mbtiMain'" style="background-color:#44baff">#mbti</button>
         <button onclick="window.open('https://kr.vonvon.me/quiz/19484', 'window_name', 'width=430, height=700, location=no, status=no, scrollbars=yes');" style="background-color:#44baff">#내 mbti는?</button>   
      </div>
   </div>

   <div class="mbti" id="mbti">
      <h1>MBTI 추천 선물</h1>
      <div class="mbti-list">      
         <a href="/mbti/mbtiMain"><img src="/image/mbti_banner1.png"></a>
         <button class="button"><a href="/mbti/mbtiMain">추천받기 ▶</a></button>
      </div>
   </div>
   
      <!--
      <div class="recommend">
         <div class="box1">금주의 추천상품</div>
         <a href="/product" class="box2"></a>
         <a href="/product" class="box3"></a>
         <a href="/product" class="box4"></a>
         <div class="box5" style="font-size: 2rem;"><a href="/">브랜드1 상품명</a></div>
         <div class="box6" style="font-size: 1.5rem;"><a href="/">브랜드1 가격</a></div>
         <div class="box7" style="font-size: 2rem;"><a href="/">브랜드2 상품명</a></div>
         <div class="box8" style="font-size: 1.5rem;"><a href="/">브랜드2 가격</a></div>
      </div>
      -->

   <div class="genieContainer" id="product_list">
      <h1>금주의 추천상품</h1>
      <h4>소중한 분들을 위한 추천 상품입니다.<br>
          공간과 마음을 채우는 특별한 선물로 소중한 사람들에게 감사의 마음을 전해보세요.</h4>
      <div class="genieRow">
      
      <!-- 
         <div class="card-col">
            <div class="card_header">
               <img id="img-caption"  src="https://image.idus.com/image/files/de982f5b2908436a90e816c0369da844_720.jpg" alt="Img_1">
            </div>
            <div class="card_bottom">
               <h3>제품이름</h3>
               <p>제품 정보</p>
            </div>
         </div>
      -->

         <c:forEach var="pvo" items="${comlist}">
            <div class="card-col">
               <a class="product-title" href="/product_detail?product_id=${pvo.product_id}" >
               <div class="card_header">
                  <img id="img-caption"  src="${pvo.product_image1}" alt="Img_1">
               </div>
               <div class="card_bottom">
                  <h5 style="color:gray; font-size: 16px;">${pvo.company_name}</h5>
                  <p>${pvo.product_name}</p>	
                  <p  style="margin-top: 8px;"><b><fmt:formatNumber value="${pvo.product_price}" pattern="#,###원"/></b></p></a>	
               </div>
            </div>
         </c:forEach>

      </div>
   </div>

</section>

	 <!-- Footer -->

   <div class="blank"></div>
  
	<section class="contact" id="contact">
		<div class="main-contact">
			<div class="contact-content">
				<img src="/image/logo_western.png">
			</div>

			<div class="contact-content">
			   <li><a href="/#">Home</a></li>
            <li><a href="/#mbti">MBTI</a></li>
            <li><a href="/#category">카테고리</a></li>
            <li><a href="/#tag">인기태그</a></li>
			</div>

			<div class="contact-content">
				<li><a href="/user/login">Login</a></li>
				<li><a href="/cart">Cart</a></li>
				<li><a href="/user/MyPage">마이페이지</a></li>
				<li><a href="#">문의하기</a></li>
			</div>

			<div class="contact-content">
				<li><a href="#">GENIE<br></a></li>
            <li><a href="#">강남구 역삼동 멀티캠퍼스</a></li>
				<li><a href="#">genie@genie.com</a></li>
				<li><a href="#">02-475-3421</a></li>
			</div>

		</div>
	</section>