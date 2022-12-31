// $(function(){
//     $("#buynow").click(function () {        
//     var IMP = window.IMP; // 생략가능        
//     IMP.init('imp49851084');         
//     // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용        
//     // i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드        
//     IMP.request_pay({
//         pg: 'inicis', // version 1.1.0부터 지원.            
//         /*                 
//         'kakao':카카오페이,                 
//         html5_inicis':이니시스(웹표준결제)                    
//         'nice':나이스페이                    
//         'jtnet':제이티넷                    
//         'uplus':LG유플러스                    
//         'danal':다날                    
//         'payco':페이코                    
//         'syrup':시럽페이                    
//         'paypal':페이팔                
//         */            
//         pay_method: 'card',            
//         /*                 
//         'samsung':삼성페이,                 
//         'card':신용카드,                 
//         'trans':실시간계좌이체,                
//         'vbank':가상계좌,                
//         'phone':휴대폰소액결제             
//         */            
//         merchant_uid: 'merchant_' + new Date().getTime(),            
//         /*                 
//         merchant_uid에 경우                            
//         */            
//         name: '${pvo.product_name}',            
//         //결제창에서 보여질 이름            
//         amount: '${pvo.product_price}',            
//         //가격             
//         buyer_email: '${uvo.user_email}',            
//         buyer_name: '${uvo.user_name}',           
//         buyer_tel: '${uvo.user_tel}',            
//         buyer_addr: '${uvo.user_addr}',            
//         buyer_postcode: '${uvo.user_zipcode}',          
//         m_redirect_url: 'https://www.yourdomain.com/payments/complete'           
//         /*                  
//         모바일 결제시,                
//         결제가 끝나고 랜딩되는 URL을 지정                 
//         (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
//         */        
//         }, function (rsp) {            
//             console.log(rsp);            
//             if (rsp.success) {                
//                 var msg = '결제가 완료되었습니다.';                
//                 msg += '고유ID : ' + rsp.imp_uid;                
//                 msg += '상점 거래ID : ' + rsp.merchant_uid;                
//                 msg += '결제 금액 : ' + rsp.paid_amount;                
//                 msg += '카드 승인번호 : ' + rsp.apply_num;            
//                 } else {                
//                     var msg = '결제에 실패하였습니다.';                
//                     msg += '에러내용 : ' + rsp.error_msg;            
//                 }           
//             alert(msg);        
//         });
//     });
// });
$(document).ready(()=>{
    $(".box-wrapper2").hide();
    $(".box-wrapper3").hide();
    $(".qna-wrapper").hide();
    $(".exchange-wrapper").hide();
});

function detail1(imgName){
    document.getElementsByClassName('box1')[0].style.backgroundImage = 'url('+imgName+')';
}


function content1(){
    $(".review-wrapper").show();
    $(".qna-wrapper").hide();
    $(".exchange-wrapper").hide();
}
function content2(){
    $(".review-wrapper").hide();
    $(".qna-wrapper").show();
    $(".exchange-wrapper").hide();
}
function content3(){
    $(".review-wrapper").hide();
    $(".qna-wrapper").hide();
    $(".exchange-wrapper").show();
}

// -----------------------------------장바구니------------------------------------------
$(function(){
    //유효성 검사
    $("#Cart").submit(function(){
        
        // 아이디, 비밀번호
        if($("#cart_qty").val().trim()==""){
            alert("최소 수량은 1개 이상입니다.");
            $("#cart_qty").focus();
            return false;
        }
        if($("#cart_qty").val().trim()=="0"){
            alert("최소 수량은 1개 이상입니다.");
            $("#cart_qty").focus();
            return false;
        };
    });
});
