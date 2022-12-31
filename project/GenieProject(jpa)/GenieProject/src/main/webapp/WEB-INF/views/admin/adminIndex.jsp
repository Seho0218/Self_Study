<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../inc/top.jspf"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

body {
  line-height: 1.5;
  min-height: 100vh;
  font-family: "Be Vietnam Pro", sans-serif;
  background: #f2f2f2;
}

/* --------------첫번째 하얀부분 설정---------------- */
.index-list {
	background: #fff;
	padding: 2em 19em;
	border-radius: 1rem;
	box-shadow: 0 0 15px #fbfbfb
}
/* ------------첫번째 h1문구 설정(NOW IS THE PRESENT 2022)------------ */
.index-list h1 {
	position: relative;
	margin-bottom: 1.5em;
	color: #1d1d1f;
	font-size: 2em;
}
/* ------------두번째 부재 설정(어떤 선물을 찾고 있나요? 고민이 되신다면 AI추천서비스를 이용해보세요)-------------- */
.index-text p {
	color: #6e6e73;
	font-size: 1em;
	font-weight: bold;
	margin: .5vh;
}
/* -------------------선물상자 버튼설정----------------- */
.index-btn {
	position: relative;
	font-size: 1.3em;
	padding: .5em;
	background: #96aee0;
	color: #fff;
	border-radius: 10px;
	transition: ease .40s;
	top: -5vh;
	left: 25vw;
}
.index-btn:hover {
	background: #fff;
	transform: scale(1.1);
	box-shadow: 0 0 15px #fbfbfb;
	color: #96aee0;
}

/* --------------------------------------------------------------------------- */
/* --------------------카테고리 설정--------------------- */
.category h2{
	margin: 2em;
	text-align: left;
}
.category-list{
	display: grid;
	grid-template-columns: 10vw 10vw 10vw 10vw 10vw 10vw;
	justify-content: space-evenly;
	align-content: space-evenly;
	gap: 2em;
    padding-left: 3rem;
    padding-right: 3rem;
}
.category-list div{
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 1em;
	font-weight: bold;
	padding: 1em;
	height: 20vh;
	background: #fff;
	border-radius: 1rem;
	box-shadow: 0 0 15px #fbfbfb;
    background: linear-gradient(to top, #FF5673, #FF8C48);
    color: #fff;
}

/* --------------------------------------------------------------------------- */
/* --------------------메인페이지 2--------------------- */
.Mainpage2{
	margin:10em;
}

.Mainpage2 h2{	
	text-align:center;
	margin:2em;

}
.Mainpage2-category-list{

	display: grid;
	grid-template-columns: 10vw 10vw 10vw 10vw 10vw 10vw;
	gap: 2em;
	text-align:center;
	
}

.Mainpage2-category-list div{
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 1em;
	font-weight: bold;
	padding: 1em;
	height: 20vh;
	background: #fff;
	border-radius: 20px;
	box-shadow: 0 0 15px #fbfbfb;
}

.Mainpage2-choice{
	padding:10em;
	display:flex;
}

.Mainpage2-choice div{
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 1em;
	font-weight: bold;
	padding: 1em;
	height: 10vh;
	width:20em;
	
	background: #fff;
	border-radius: 20px;
	box-shadow: 0 0 15px #fbfbfb;
}





.responsive-wrapper {
  width: 90%;
  max-width: 1280px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 10vh;
}

.portfolio-content{
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(350px, auto));
	align-items: center;
	gap: 2rem;
	margin-top: 5rem;
}

.portfolio h1{
    margin-top: 80px;
	font-size: 25px;
	font-weight: 700;
}
.portfolio h3{
	font-size: 20px;
	font-weight: 500;
    color: #888b8d;
}
.row img{
	height: auto;
	width: 100%;
	border-radius: 1rem;
	margin-bottom: 1.5rem;
}
.row{
	padding: 25px;
	background: #fff;
	border-radius: 1rem;
	transition: all .40s ease;
	box-shadow: 0 0 15px #fbfbfb;
}
.main-row{
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-bottom: 1rem;
}

.row h3{
	font-size: 25px;
	font-weight: 700;
}
.row h4{
	font-size: 20px;
	font-weight: 700;
}
.row h6{
	font-size: 16px;
	font-weight: 500;
    color: #888b8d;
}
.row-icon i{
	font-size: 21px;
}
.row:hover{
	transform: scale(1.01) translateY(-5px);
	cursor: pointer;
}


.grid-container {
    display: grid;
    grid-template-columns: auto auto auto auto;
    gap: 2rem;
    padding: 10px;
    margin-bottom: 5rem;
}

.grid-container > div {
	width: 150px;
	height: 150px;
    background: linear-gradient(to top, #2DCEF8, #2DCEF8);
    text-align: center;
    font-size: 20px;
    margin: 0 auto;
    border-radius: 1rem;
    line-height: 150px;
    color: white;
    font-weight: 500;
}


.content-line {
    background: linear-gradient(to top, #2DCEF8, #2DCEF8);
    width: 100%;
    height: 50px;
    border-radius: 0.5rem;
}
.content-line ul {
    list-style: none;
}
.content-line li {
    color: white;
    float: left;
    margin: 0 auto;
    text-align: center;
    padding-left: 200px;
    line-height: 50px;
    font-size: 20px;
    font-weight: 500;
}

</style>

<div class="responsive-wrapper">

<!--Genie 메인화면--->
<section class="index">
	<div class="index-list">
		<h1>NOW IS THE PRESENT 2022</h1>
		<div class="index-text">			
			<p>어떤 선물을 찾고 있나요?</p>
			<p>고민이 되신다면 AI추천서비스를 이용해보세요</p>
			<a href="/genie/genie_01" class="index-btn"><i class="fa-solid fa-robot"></i></a>
		</div>
	</div>
	<div class="category">
		<h2>Category</h2>
		<div class="category-list">
			<a href="#"><div>생일</div></a>
			<a href="#"><div>기념일</div></a>
			<a href="#"><div>명절</div></a>
			<a href="#"><div>집들이</div></a>
			<a href="#"><div>서프라이즈</div></a>
			<a href="#"><div>응원</div></a>
			<a href="#"><div>캠핑</div></a>
			<a href="#"><div>반려동물</div></a>
			<a href="#"><div>운동</div></a>
			<a href="#"><div>키덜트</div></a>
			<a href="#"><div>요리</div></a>
			<a href="#"><div>홈파티</div></a>
		</div>
	</div>
</section>
</div>

<div class="responsive-wrapper">

    <div class="grid-container">
      <div class="item1">All</div>
      <div class="item2">여성</div>
      <div class="item3">남성</div>  
      <div class="item4">청소년</div> 
    </div>
    
    <div class="content-line">
        <ul>
            <li>많이 선물한</li>
            <li>받고 싶어한</li>
            <li>위시로 받은</li>
        </ul>
    </div>
                    
        <!---상품그리드--->
        <section class="portfolio" id="portfolio">
    
            <div class="portfolio-content">
                <div class="row">
                    <img src="https://image.idus.com/image/files/2ab06e545f0f4e999689e60ea59bac38_720.jpg">
                    <div class="main-row">
                        <div class="row-icon">
                            <i class='bx bx-heart'></i>
                        </div>
                    </div>
                    <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                    <h6>#생일 #추석 #집들이선물</h6>
                </div>

                <div class="row">
                    <img src="http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg">
                    <div class="main-row">
                        <div class="row-icon">
                            <i class='bx bx-heart'></i>
                        </div>
                    </div>
                    <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                    <h6>#생일 #추석 #집들이선물</h6>
                </div>

                <div class="row">
                    <img src="https://image.idus.com/image/files/12138f51eaa44afb9fe3e1e5fabe3d29_720.jpg">
                    <div class="main-row">
                        <div class="row-icon">
                            <i class='bx bx-heart'></i>
                        </div>
                    </div>
                    <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                    <h6>#생일 #추석 #집들이선물</h6>
                </div>

                <div class="row">
                    <img src="http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg">
                    <div class="main-row">
                        <div class="row-icon">
                            <i class='bx bx-heart'></i>
                        </div>
                    </div>
                    <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                    <h6>#생일 #추석 #집들이선물</h6>
                </div>

                <div class="row">
                    <img src="https://image.idus.com/image/files/2ab06e545f0f4e999689e60ea59bac38_720.jpg">
                    <div class="main-row">
                        <div class="row-icon">
                            <i class='bx bx-heart'></i>
                        </div>
                    </div>
                    <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                    <h6>#생일 #추석 #집들이선물</h6>
                </div>

                <div class="row">
                    <img src="http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg">
                    <div class="main-row">
                        <div class="row-icon">
                            <i class='bx bx-heart'></i>
                        </div>
                    </div>
                    <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                    <h6>#생일 #추석 #집들이선물</h6>
                </div>
            </div>
            
        </section>


            <!---상품그리드 하단--->
            <section class="portfolio" id="portfolio">
    
                <h1>금주의 브랜드</h4>
                <h3>마음이 복잡할 땐 잠시 향멍을 추천드립니다.<br/>
                    공간과 마음을 채우는 특별한 선물로 소중한 사람들에게 감사의 마음을 전해보세요.</h3>

                <div class="portfolio-content">
                    <div class="row">
                        <img src="https://image.idus.com/image/files/2ab06e545f0f4e999689e60ea59bac38_720.jpg">
                        <div class="main-row">
                            <div class="row-icon">
                                <i class='bx bx-heart'></i>
                            </div>
                        </div>
                        <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                        <h6>조향사가 향수등급의 프리미엄 오일을<br/>
                            직접 엄선,조향한 프리미엄 디퓨저입니다💕</h6>
                    </div>
    
                    <div class="row">
                        <img src="http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg">
                        <div class="main-row">
                            <div class="row-icon">
                                <i class='bx bx-heart'></i>
                            </div>
                        </div>
                        <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                        <h6>조향사가 향수등급의 프리미엄 오일을<br/>
                            직접 엄선,조향한 프리미엄 디퓨저입니다💕</h6>
                    </div>
    
                    <div class="row">
                        <img src="https://image.idus.com/image/files/12138f51eaa44afb9fe3e1e5fabe3d29_720.jpg">
                        <div class="main-row">
                            <div class="row-icon">
                                <i class='bx bx-heart'></i>
                            </div>
                        </div>
                        <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                        <h6>조향사가 향수등급의 프리미엄 오일을<br/>
                            직접 엄선,조향한 프리미엄 디퓨저입니다💕</h6>
                    </div>
    
                    <div class="row">
                        <img src="http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg">
                        <div class="main-row">
                            <div class="row-icon">
                                <i class='bx bx-heart'></i>
                            </div>
                        </div>
                        <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                        <h6>조향사가 향수등급의 프리미엄 오일을<br/>
                            직접 엄선,조향한 프리미엄 디퓨저입니다💕</h6>
                    </div>
    
                    <div class="row">
                        <img src="https://image.idus.com/image/files/12138f51eaa44afb9fe3e1e5fabe3d29_720.jpg">
                        <div class="main-row">
                            <div class="row-icon">
                                <i class='bx bx-heart'></i>
                            </div>
                        </div>
                        <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                        <h6>조향사가 향수등급의 프리미엄 오일을<br/>
                            직접 엄선,조향한 프리미엄 디퓨저입니다💕</h6>
                    </div>
    
                    <div class="row">
                        <img src="http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg">
                        <div class="main-row">
                            <div class="row-icon">
                                <i class='bx bx-heart'></i>
                            </div>
                        </div>
                        <h4>상품명: 뉴트리나 건강백서 비숑</h4>
                        <h6>조향사가 향수등급의 프리미엄 오일을<br/>
                            직접 엄선,조향한 프리미엄 디퓨저입니다💕</h6>
                    </div>
                </div>
                
            </section>
    
 </div>