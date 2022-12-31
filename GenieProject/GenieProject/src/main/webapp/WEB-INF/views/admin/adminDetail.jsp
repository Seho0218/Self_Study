<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../inc/top.jspf"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700;800&display=swap');

*{
    padding: 0;
    margin: 0;
    font-family: 'Open Sans', sans-serif;
}
body {
  line-height: 1.5;
  min-height: 100vh;
  font-family: "Be Vietnam Pro", sans-serif;
  background: #fafafa;
}
.card-wrapper{
    max-width: 1200px;
    margin: 0 auto;
}
img{
    width: 100%;
    display: block;
     border-radius: 12px;
}
.img-display{
    overflow: hidden;
}
.img-showcase{
    display: flex;
    width: 100%;
    transition: all 0.5s ease;
    border-radius: 12px;
}
.img-showcase img{
    min-width: 100%;

}
.img-select{
    display: flex;
}
.img-item{
    margin: 0.3rem;
}
.img-item:nth-child(1),
.img-item:nth-child(2),
.img-item:nth-child(3){
    margin-right: 0;
}
.product-content{
    padding: 2rem 1rem;
}
.product-title{
    font-size: 3rem;
    text-transform: capitalize;
    font-weight: 700;
    position: relative;
    color: #12263a;
    margin: 1rem 0;
}
.product-link{
    text-decoration: none;
    font-weight: 300;
    font-size: 0.8rem;
    display: inline-block;
    margin-bottom: 0.5rem;
    background: #FF8723;
    border-radius: 25px;
    color: #fff;
    padding: 0 0.3rem;
}
.product-rating{
    color: #ffc107;
}
.product-rating span{
    font-weight: 600;
    color: #252525;
}
.product-price{
    margin: 1rem 0;
    font-size: 1rem;
    font-weight: 700;
}
.product-price span{
    font-weight: 400;
}
.last-price span{
    color: #f64749;
    text-decoration: line-through;
}
.new-price span{
    color: #FF8723;
}
.product-detail h2{
    text-transform: capitalize;
    color: #12263a;
    padding-bottom: 0.6rem;
}
.product-detail p{
    font-size: 0.9rem;
    padding: 0.3rem;
    opacity: 0.8;
}
.product-detail ul{
    margin: 1rem 0;
    font-size: 0.9rem;
}
.product-detail ul li{
    margin: 0;
    list-style: none;
    background-size: 18px;
    margin: 0.4rem 0;
    font-weight: 600;
    opacity: 0.9;
}
.product-detail ul li span{
    font-weight: 400;
}
.purchase-info{
    margin: 1.5rem 0;
}
.purchase-info input,
.purchase-info .btn{
    border-radius: 12px;
    text-align: center;
    padding: 1rem ;
    outline: 0;
    margin-right: 0.2rem;
    margin-bottom: 1rem;
    border:0;
}
.purchase-info input{
    width: 60px;
}
.purchase-info .btn{
    cursor: pointer;
    color: #fff;
}
.purchase-info .btn:first-of-type{
    background: #FF8723;
}
.purchase-info .btn:last-of-type{
    background: #f64749;
}

@media screen and (min-width: 992px){
    .card{
        display: grid;
        grid-template-columns: repeat(2, 1fr);
        grid-gap: 1.5rem;
    }
    .card-wrapper{
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .product-imgs{
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    .product-content{
        padding-top: 0;
    }
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
    grid-template-columns: repeat(auto-fit, minmax(300px, auto));
    align-items: center;
    gap: 2rem;
    margin-top: 5rem;
}

.portfolio h1{
    margin-top: 2rem;
    margin-bottom: 1.5rem;
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
</style>

<div class="responsive-wrapper">
<h1>상세페이지</h1>
<!-- 상세페이지 -->
<div class = "card-wrapper">
    <div class = "card">
      <!-- 상세페이지 왼쪽 -->
      <div class = "product-imgs">
        <div class = "img-display">
          <div class = "img-showcase">
            <img src = "https://image.idus.com/image/files/2ab06e545f0f4e999689e60ea59bac38_720.jpg" alt = "">
            <img src = "http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg" alt = "">
            <img src = "https://image.idus.com/image/files/12138f51eaa44afb9fe3e1e5fabe3d29_720.jpg" alt = "">
            <img src = "http://image.babosarang.co.kr/product/detail/VSL/1563935780/_600.jpg" alt = "">
          </div>
        </div>
        <div class = "img-select">
          <div class = "img-item">
            <a href = "#" data-id = "1">
              <img src = "https://image.idus.com/image/files/2ab06e545f0f4e999689e60ea59bac38_720.jpg" alt = "">
            </a>
          </div>
          <div class = "img-item">
            <a href = "#" data-id = "2">
              <img src = "https://image.idus.com/image/files/12138f51eaa44afb9fe3e1e5fabe3d29_720.jpg" alt = "">
            </a>
          </div>
          <div class = "img-item">
            <a href = "#" data-id = "3">
              <img src = "https://image.idus.com/image/files/2ab06e545f0f4e999689e60ea59bac38_720.jpg" alt = "">
            </a>
          </div>
          <div class = "img-item">
            <a href = "#" data-id = "4">
              <img src = "https://image.idus.com/image/files/12138f51eaa44afb9fe3e1e5fabe3d29_720.jpg" alt = "">
            </a>
          </div>
        </div>
      </div>
      <!-- 상세페이지 오른쪽 세부사항 -->
      <div class = "product-content">
        <h2 class = "product-title">건강백서 비숑</h2>
        <a href = "#" class = "product-link">뉴트리나</a>
        <div class = "product-rating">
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star"></i>
          <i class = "fas fa-star-half-alt"></i>
          <span>4.7(21)</span>
        </div>
  
        <div class = "product-price">
          <p class = "new-price">가격: <span>19,990원</span></p>
        </div>
  
        <div class = "product-detail">
          <h2>상세설명 </h2>
          <p>조향사가 향수등급의 프리미엄 오일을<br/>
              직접 엄선,조향한 프리미엄 디퓨저입니다💕</p>
          <p>무더운 벌레많은 날씨에도, 날이 추워져도 잘 어울리는, 시나몬 그대로 허브방향제로 사용해보세요.
          시나몬 스틱이 디퓨저 스틱 역할을 하구요, 디퓨저보다 더 진한 발향이 되는 제품이랍니다
          </p>
          <ul>
            <li>제조사: <span>멀티캠퍼스</span></li>
            <li>카테고리: <span>디퓨져</span></li>
            <li>셀러명: <span>뉴트리나</span></li>
            <li>셀러주소: <span>서울시 강남구 </span></li>
            <li>배송문의: <span>무료배송</span></li>
          </ul>
        </div>
  
        <div class = "purchase-info">
          <button type = "button" class = "btn">
            장바구니 <i class = "fas fa-shopping-cart"></i>
          </button>
          <button type = "button" class = "btn" id="genie">결제하기</button>
        </div>

        <script>
            $("#genie").click(function () {        
            var IMP = window.IMP; // 생략가능        
            IMP.init('imp49851084');         
            // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용        
            // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드        
            IMP.request_pay({
                pg: 'inicis', // version 1.1.0부터 지원.            
                /*                 
                'kakao':카카오페이,                 
                html5_inicis':이니시스(웹표준결제)                    
                'nice':나이스페이                    
                'jtnet':제이티넷                    
                'uplus':LG유플러스                    
                'danal':다날                    
                'payco':페이코                    
                'syrup':시럽페이                    
                'paypal':페이팔                
                */            
                pay_method: 'kakaopay',            
                /*                 
                'samsung':삼성페이,                 
                'card':신용카드,                 
                'trans':실시간계좌이체,                
                'vbank':가상계좌,                
                'phone':휴대폰소액결제             
                */            
                merchant_uid: 'merchant_' + new Date().getTime(),            
                /*                 
                merchant_uid에 경우                            
                */            
                name: '주문명:결제테스트',            
                //결제창에서 보여질 이름            
                amount: 29900,             
                //가격             
                buyer_email: 'iamport@siot.do',            
                buyer_name: '구매자이름',           
                buyer_tel: '010-1234-5678',            
                buyer_addr: '서울특별시 강남구 삼성동',            
                buyer_postcode: '123-456',           
                m_redirect_url: 'https://www.yourdomain.com/payments/complete'           
                /*                  
                모바일 결제시,                
                결제가 끝나고 랜딩되는 URL을 지정                 
                (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
                */        
                }, function (rsp) {            
                    console.log(rsp);            
                    if (rsp.success) {                
                        var msg = '결제가 완료되었습니다.';                
                        msg += '고유ID : ' + rsp.imp_uid;                
                        msg += '상점 거래ID : ' + rsp.merchant_uid;                
                        msg += '결제 금액 : ' + rsp.paid_amount;                
                        msg += '카드 승인번호 : ' + rsp.apply_num;            
                        } else {                
                            var msg = '결제에 실패하였습니다.';                
                            msg += '에러내용 : ' + rsp.error_msg;            
                        }           
                    alert(msg);        
                    });    
            });
        </script>


      </div>
    </div>
  </div>
  
    <!---상품그리드--->
    <section class="portfolio" id="portfolio">
        <h1>관련 브랜드를 추천해드립니다</h1>
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
    
 </div>