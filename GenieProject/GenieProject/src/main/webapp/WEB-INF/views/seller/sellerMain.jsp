<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<style>
.content-wrapper{
	overflow-y:scroll;
	-ms-overflow-style: none;
}

.content-wrapper::-webkit-scrollbar{
  display:none;
}

#mainbody{
	padding-top: 10px;
	padding-left: 100px;
	padding-right: 100px;
}

.container {
  display: grid; 
  grid-template-columns: 1fr 1fr 1fr; 
  grid-template-rows: 0.1fr 0.1fr 0.1fr 0.1fr; 
  gap: 1px 13px; 
  grid-template-areas: 
    "banner banner banner"
    "order_delivery1 order_delivery2 month_bestseller"
    "total_sales total_sales category_sales"
    "items_sales items_sales items_sales"; 
}

.banner { grid-area: banner; }
.order_delivery1 { grid-area: order_delivery1; }
.order_delivery2 { grid-area: order_delivery2; }
.month_bestseller { grid-area: month_bestseller; }
.category_sales { grid-area: category_sales; }
.total_sales { grid-area: total_sales; }
.items_sales { grid-area: items_sales; }

.thumb {
  width: 30%;
  aspect-ratio: 1/1;
  object-fit:cover;
}

.banner .card {
  background-color: #FDF5C4;
  vertical-align: middle;
}
.banner .card-body{
  padding: 10px;
}

.banner a{
  vertical-align: middle;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 15px;
  display: block;
  float: right;
  background: #67AD5B;
  color: white;
  border-radius: 6px;
  padding: 0.5rem 1rem;
   
}

.banner a:hover{
  box-shadow: 0 0.5rem 0.5rem rgba(71, 7, 234, 0.2);
}

.table {
  table-layout: fixed;
  width: 100%;
  text-align: center;
}

.order_delivery1 .card, .order_delivery2 .card, .month_bestseller .card{
  min-height: 200px;
}

.total_sales .card, .category_sales .card{
  min-height: 410px;
}


</style>

<%@ include file="../inc/sellerNav.jsp"%>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0"></h1>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content" id="mainbody">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
          <div class="container">

            <div class="banner">
              <div class="card">
                <div class="card-body"> 
                  <img class="mr-4" src="../image/banner_icon.png" style="width:6rem; float:left; margin-left:20px;"/>
                  <a href="#"><i class="fas fa-play"></i> &nbsp&nbsp&nbsp Watch Now</a>
                    <h5 class="mt-2">지니셀러님들을 위한 반품 안심케어를 무료로 사용하시고 더욱 쉽게 주문을 관리해보세요.</h5> 
                    영상을 통해 더 자세히 알아보세요.
                </div>
              </div>
            </div>
            <div class="order_delivery1">
              <div class="card">
                <div class="card-header">
                  <h5 class="m-0">주문</h5>
                </div>
                <div class="card-body">
                  <p class="card-text">오늘 <b>${todayOrder} 건</b>의 <br/>
                  새로운 주문이 있어요.</p>
                  <a href="/seller/sellerOrder" class="card-link">주문관리</a>
                </div>
              </div>
            </div>
            <div class="order_delivery2">
              <div class="card">
                <div class="card-header">
                  <h5 class="m-0">배송</h5>
                </div>
                <div class="card-body">
                  <p>총 <b>${deliveryPending} 건</b>의 주문이 <br/>
                    배송을 기다리고 있어요.</p>
                  <a href="/seller/sellerOrder" class="card-link">배송처리</a>
                </div>
              </div>
            </div>
            <div class="month_bestseller">
              <div class="card">
                <div class="card-header">
                  <h5 class="m-0">이달의 상품</h5>
                </div>
                <div class="card-body">
                  <p class="card-text">가장 인기있는 상품은 <br/>
                    <b>${bestSeller}</b> 이에요.</p>
                  <a href="/seller/sellerProduct" class="card-link">상품관리</a>
                </div>
              </div>
            </div>
                
                
            <div class="items_sales">
              <div class="card">
                <div class="card-header">
                  <h5 class="m-0">아이템별 매출</h5>
                </div>
                <div class="card-body">
                  
                  <p class="card-text"  style="font-size: 5px;">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>이미지</th>
                          <th>상품명</th>
                          <th>결제건수</th>
                          <th>매출</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="vo" items="${revenueByProduct}" varStatus="i">
                          <tr>
                            <td><img src="${vo.product_image1}" class="thumb"></td>
                            <td>${vo.product_name}</td>
                            <td>${vo.sold_counts}</td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${vo.total_sales}"/> 원</td>

                          </tr>
                        </c:forEach>
                        
                      </tbody>
                    </table>
                  </p>
                  <a href="#" class="card-link"></a>
                </div>
              </div>
            </div>
            <div class="total_sales">
              <div class="card">
                <div class="card-header">
                  <h5 class="m-0">매출 통계</h5>
                </div>
                <div class="card-body">
                  <p class="card-text">
                    이번 달 총 매출은 <b><fmt:formatNumber type="number" maxFractionDigits="3" value="${orderSum}" /> 원</b> 이에요.
                  </p>
                  <br>
                  <!-- 차트 (chart js)-->
                  <canvas id="chart" style="width:200px; height:75px;"></canvas>
                  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
                </div>
              </div>
            </div>
            <div class="category_sales">
              <div class="card">
                <div class="card-header">
                  <h5 class="m-0">카테고리별 판매건수</h5>
                </div>
                <div class="card-body">
                  <p class="card-text">
                    
                  </p>
                  <canvas id="chart2"></canvas>
                  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
                </div>
              </div>
            </div>
          </div> <!-- container -->
        </div>
        </div> <!-- ./row -->
      </div> <!-- ./container-fluid -->
    </div> <!-- ./content -->
  </div> <!-- /.content-wrapper -->
  
  <%@ include file="../inc/sellerFooter.jsp"%>
<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/js_css/dist/js/adminlte.min.js"></script>

<!-- 차트 (chart js)-->
<script>
  var jsonData = ${json}; // Controller 에서 가공하여 넘겨준 데이터를 jstl 문법을 통해 변수에 담기
  var jsonObject = JSON.stringify(jsonData); // js에서 문자열형태로 사용할 수 있도록 변환
  var jData = JSON.parse(jsonObject); // json객체로 사용할수 있게 json.parse 메소드 이용
  // -> js 에서 jData 변수를 사용하여 데이터 다룰수 있게됨.
  
  // 차트표현을 위해 필요한 핵심데이터들이 각각 들어갈 js 배열 객체 선언
  var labelList = new Array();
  var valueList = new Array();
  var colorList = new Array();
  
  // jData 에 담겨있는 변수들을 추출하여 위에서 선언한 각각의 js array 에 분배
  for(var i=0; i<jData.length; i++){ // jData 길이만큼 반복문 수행
    var d = jData[i]; // 각각의 json 데이터안에 입력디어 있는 값중
    labelList.push(d.date); // date (month_day) 에 해당하는 부분을 labelList에 삽입
    valueList.push(d.sales); // sales (total_sales) 에 해당하는 부분을 valueList에 삽입
    colorList.push(colorize()); // 랜덤한 색상값을 생성해 반환
  }
  
  function colorize(){
    var r = Math.floor(Math.random()*200);
    var g = Math.floor(Math.random()*200);
    var b = Math.floor(Math.random()*200);
    var color = 'rgba(' + r + ', ' + g + ', ' + b +  ', 0.7)';
    return color;
  }
  
  // 각각의 리스트를 chart js 형식에 넣어주기
  var data = {
      labels: labelList,
      datasets: [{
        label: '매출(원)',
        backgroundColor: colorList,
        data: valueList
        
      }]
  };
  
  const chart = document.querySelector("#chart").getContext('2d');
  new Chart(chart, {
    type: 'line',
    data: data,
    options: {
      scales: {
        x: {
          grid: {
            display: false
          }
        },
        y: {
          beginAtZero: false,
          grid: {
            display: false
          }
        }
      }
    }
  })
  
  </script>

<!-- 파이 차트 (chart js)-->
<script>
  var jsonData2 = ${json2}; // Controller 에서 가공하여 넘겨준 데이터를 jstl 문법을 통해 변수에 담기
  var jsonObject2 = JSON.stringify(jsonData2); // js에서 문자열형태로 사용할 수 있도록 변환
  var jData2 = JSON.parse(jsonObject2); // json객체로 사용할수 있게 json.parse 메소드 이용
  // -> js 에서 jData 변수를 사용하여 데이터 다룰수 있게됨.
  
  // 차트표현을 위해 필요한 핵심데이터들이 각각 들어갈 js 배열 객체 선언
  var labelList2 = new Array();
  var valueList2 = new Array();
  var colorList2 = new Array();
  
  // jData 에 담겨있는 변수들을 추출하여 위에서 선언한 각각의 js array 에 분배
  for(var i=0; i<jData2.length; i++){ // jData 길이만큼 반복문 수행
    var d2 = jData2[i]; // 각각의 json 데이터안에 입력디어 있는 값중
    labelList2.push(d2.category); // date (month_day) 에 해당하는 부분을 labelList에 삽입
    valueList2.push(d2.sold_counts); // sales (total_sales) 에 해당하는 부분을 valueList에 삽입
    colorList2.push(colorize()); // 랜덤한 색상값을 생성해 반환
  }
  
  function colorize(){
    var r = Math.floor(Math.random()*200);
    var g = Math.floor(Math.random()*200);
    var b = Math.floor(Math.random()*200);
    var color = 'rgba(' + r + ', ' + g + ', ' + b +  ', 0.7)';
    return color;
  }
  
  // 각각의 리스트를 chart js 형식에 넣어주기
  var data2 = {
      labels: labelList2,
      datasets: [{
        backgroundColor: colorList,
        data: valueList2
        
      }],
      options: {
        title: {
          display: true
        },
        legend: {
          display: false
        }
      }
  };
  
  const chart2 = document.querySelector("#chart2").getContext('2d');
  new Chart(chart2, {
    type: 'doughnut',
    data: data2
  })
  
  </script>

