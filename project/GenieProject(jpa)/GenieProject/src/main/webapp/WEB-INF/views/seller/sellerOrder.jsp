<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
  .content-wrapper{
	overflow-y:scroll;
	-ms-overflow-style: none;
}

  .content-wrapper::-webkit-scrollbar{
  display:none;
}

  #orderbody{
		padding-top: 10px;
		padding-left: 100px;
		padding-right: 100px;
	}

	.info-box-text{
		font-size: 13px;
	}
	.info-box{
		width: 300px;
		height: 200px;
	}

	#icon {
		width: 100%;
		height: 100%;
    border-radius: 25px;
    text-shadow: 1px 1px 1px gray;

	}

  .table{
    font-size: 82%;
    text-align: center;
  }

  #orderListBtn{
    background-color: #4846f5;
    opacity: 80%;
    color: white;
    border-color: transparent;
    border-radius: 5px 5px 0px 0px;
  }

  .table [type="button"]{
	  width: 42px;
   
    font-size: 12px;
    letter-spacing: -1px;
    border: 1px solid #ccc;
    border-radius: 2px;
    color: #0073e9;
    text-align: center;
    background: #fff;
    cursor: pointer;
    border: 1px solid #ccc;
}

.deliveryinfo{
  border-color: gray;
  color: #0073e9;
  border-radius: 3px;
}

#subtitle{
	padding-left:80px;
}



</style>


<script>
	function fn_modify_order_state(order_num, select_id) { // order_num 와 select_id 를 매개변수로 받는 함수를 실행
		// 주문상태를 나타내는 셀렉트 박스에 접근
		var s_delivery_status = document.getElementById(select_id); // 's_delivery_status${i.index}' 태그에 접근
		// 함수로 전달받은 셀렉트 박스에서 선택한 옵션의 인덱스로 배송 상태 값을 가져옴
		var index = s_delivery_status.selectedIndex; // 드롭다운 리스트에서 선택된 옵션의 '인덱스 번호'를 반환한다.
		var value = s_delivery_status[index].value; // 인덱스 번호의 '값'을 반환한다.
		
		$.ajax({
			type: "post",
			async: false, // 동기요청 필요 -> 한 작업이 끝나야 그 다음 작업 가능
			url: "/seller/updateDeliveryStatus", // 어디로 보낼까?
			// 주문 번호와 배송 상태 값을 컨트롤러로 전송 
			data : { // 서버로 보내질 어떤 데이터?
				order_num:order_num,
				"recipient_delivery_status":value
			},
			success: function(data, textStatus){ // 요청이 성공하면 실행되는 콜백함수
					console.log(data);
				if(data.trim()=="mod_success"){
					alert("배송 상태를 수정했습니다."); // 성공메세지
					location.href="sellerOrder"; // 리턴페이지
				}else if(data.trim()=='failed'){
					alert("다시 시도해 주세요."); 
				}
			},
			error: function(data, textStatus){ // 요청이 실패했을때 실행되는 콜백함수
				alert("에러가 발생했습니다.");
			}
		});	
	}
</script>
<script>

  $(function(){
  

    $('.deliveredpro').click(function(){
      console.log("aaaa")
      $('.table tbody').empty();
        var deliveryStatus  ="";
       
        //서버에 접속하여 배송완료....
        $.ajax({
            type: "post",
            //async: false, // 동기요청 필요 -> 한 작업이 끝나야 그 다음 작업 가능
            url: "/seller/sellerOrder1", // 어디로 보낼까?
            success: function(data){ // 요청이 성공하면 실행되는 콜백함수
              console.log(data);
              $.each(data, function(i, value){
                deliveryStatus += '<tr>'
                  +'<td>' + value.order_num + '</td>'
                  +'<td>' + value.order_writedate + '</td>'
                  +'<td>' + value.product_name + '</td>'
                  +'<td>' + value.order_qty + '</td>'
                  +'<td>'+value.order_price+'</td>'
                  +'<td>' + value.genie_id +'</td>'
                  +'<td>' 
                      +'<select class="deliveryinfo" name="s_delivery_status" id="s_delivery_status'+i+'">'
                      + '<option value="delivered" selected>배송완료</option>'                                              
                      + '<option value="returned">반품</option>'
                      + '</select>'
                  +'</td>'
                  +'</tr>'
               });
              $('.table').append(deliveryStatus);
              console.log(deliveryStatus)
              $('.deliveredpro').hide();
              $('.deliveredpro').after('<button class="deliveryList" id="orderListBtn" style="font-size: 13px;" ><i class="fa fa-arrow-left" aria-hidden="true"></i> 뒤로가기</button>');
              $('.deliveryList').click(function(){
                 location.reload();
              });
            },
            error: function(data, textStatus){ // 요청이 실패했을때 실행되는 콜백함수
              alert("에러가 발생했습니다.");
            }
           
          });	


        // success 
     
    });//click
  });//function
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
              <li class="breadcrumb-item active" style="color: #047bff;">주문관리</li>
              </ol>
            </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->


    <!-- Main content -->
    <div class="content" id="orderbody">
      <div class="container-fluid">
        <!-- info boxes -->
        <div class="row">
          <div class="col-12 col-sm-6 col-md-4">
            <div class="info-box" style="background-color: transparent; box-shadow: none;">
              <span class="info-box-icon elevation-1" id="icon" style="background: linear-gradient(#a7b1dc,#798ff2); color:white;"><i class="fas fa-gift">
                <div class="info-box-content">
                  <span class="info-box-text">배송 준비 중</span>
                  <span class="info-box-number">
                    <h2><b>${deliveryPending} 건</b></h2>
                  </span>
                </div>
              </i></span>
            </div>
          </div>
          <div class="col-12 col-sm-6 col-md-4">
            <div class="info-box mb-3" style="background-color: transparent; box-shadow: none;">
              <span class="info-box-icon elevation-1" id="icon" style="background:linear-gradient(#b6b0d6, #7c65ee); color:white;"><i class="fas fa-shopping-cart">
                <div class="info-box-content">
                  <span class="info-box-text">오늘 들어온 주문</span>
                  <span class="info-box-number">
                    <h2><b>${todayOrder} 건</b></h2>
                  </span>
                </div>
              </i></span> 
            </div>
          </div>
          <div class="col-12 col-sm-6 col-md-4">
            <div class="info-box mb-3" style="background-color: transparent; box-shadow: none;">
              <span class="info-box-icon elevation-1" id="icon" style="background:linear-gradient(#9ec7cc,#0eabbc); color:white;"><i class="fas fa-check"> 
                <div class="info-box-content">
                  <span class="info-box-text">배송 중</span>
                  <span class="info-box-number">
                    <h2><b>${deliveringOrder} 건</b></h2>
                  </span>
                </div>
              </i></span>
            </div>
          </div>
        </div> <!-- /.row -->
          <div class="row">
            <div class="col-lg-12">
              <div class="card card-primary card-outline">
                <div class="card-body">
                  <button class="deliveredpro" id="orderListBtn" style="font-size: 13px;">배송완료목록 바로가기 <i class="fa fa-arrow-right" aria-hidden="true"></i></button>
                  <br>
                  <h5 class="card-title"></h5> <!--주문목록-->
                  <p class="card-text">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>주문코드</th>
                          <th>주문날짜</th>
                          <th>상품명</th>
                          <th>수량</th>
                          <th>결제금액</th>
                          <th>주문자명</th>
                          <th>배송상태</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                      <!-- 주문 상품 목록을 리스트로 표시 -->
                        <c:forEach var="vo" items="${list}" varStatus="i"> 
                          <tr>
                            <td>${vo.order_num}</td>
                            <td>${vo.order_writedate}</td>
                            <td>${vo.product_name}</td>
                            <td>${vo.order_qty}</td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${vo.order_price}" /> 원</td>
                            <td>${vo.genie_id}</td>
                            <td >
                                <select class="deliveryinfo" name="s_delivery_status${i.index }" id="s_delivery_status${i.index }">
                                  <option value="delivery_prepared" <c:if test="${vo.recipient_delivery_status=='delivery_prepared' }">selected</c:if>>배송준비중</option>
                                  <option value="delivering" <c:if test="${vo.recipient_delivery_status=='delivering' }">selected</c:if>>배송중</option>
                                  <option value="delivered" <c:if test="${vo.recipient_delivery_status=='delivered' }">selected</c:if>> 배송완료</option>
                                  <option value="cancelled" <c:if test="${vo.recipient_delivery_status=='cancelled' }">selected</c:if>>주문취소</option>
                                  <option value="returned" <c:if test="${vo.recipient_delivery_status=='returned' }">selected</c:if>>반품</option>
                                </select>
                            </td>
                            <td width=10%>
                                <!-- 수정을 클릭하면 선택한 셀렉트 박스의 id를 함수로 전달 -->
                                <input type="button" value="수정" onClick="fn_modify_order_state('${vo.order_num}','s_delivery_status${i.index}')"/>
                            </td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </p>
                </div>
              </div><!— /.card —>
            </div>
        </div> <!— /.row —>
      </div> <!— /.container-fluid —>
    </div> <!— /.content —>
  </div> <!— /.content-wrapper —>
  


<!— REQUIRED SCRIPTS —>

<!— jQuery —>
<script src="plugins/jquery/jquery.min.js"></script>
<!— Bootstrap 4 —>
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!— AdminLTE App —>
<script src="/js_css/dist/js/adminlte.min.js"></script>


<%@ include file="../inc/sellerFooter.jsp"%>
                  