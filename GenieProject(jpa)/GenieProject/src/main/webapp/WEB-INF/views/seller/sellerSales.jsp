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

	#salesbody{
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
	}

	#chart{
		padding-bottom: 50px;
	}

	#chartbox{
		background-color: white;
		border-radius: 6px;
		box-shadow: 1px 1px 4px 1px lightgray;
	}

	#subtitle{
	padding-left:80px;
	}
	

</style>

<div class="wrapper">

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
				  <li class="breadcrumb-item active" style="color: #047bff;">매출관리</li>
				  </ol>
				</div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
	
    <!-- Main content -->
    <div class="content" id="salesbody">
      <div class="container-fluid">
		<!-- info boxes -->
        <div class="row">
			<div class="col-12 col-sm-6 col-md-4">
				<div class="info-box" style="background-color: transparent; box-shadow: none;">
					<span class="info-box-icon elevation-1" id="icon" style="background: linear-gradient(#a3c0d2, #0f7ac2);color:white;"><i class="fas fa-credit-card">
						<div class="info-box-content">
							<span class="info-box-text">이번달 총 매출</span>
							<span class="info-box-number">
								<h2><b><fmt:formatNumber type="number" maxFractionDigits="3" value="${orderSum}" /> 원</b></h2>
							</span>
						</div>
					</i></span>
					
				</div>
			</div>
			<div class="col-12 col-sm-6 col-md-4">
				<div class="info-box mb-3" style="background-color: transparent; box-shadow: none;">
					<span class="info-box-icon bg-success elevation-1" id="icon" style="background: linear-gradient(#99a1e9, #3753f1);"><i class="fas fa-shopping-cart">
						<div class="info-box-content">
							<span class="info-box-text">총 결제건수</span>
							<span class="info-box-number">
								<h2><b><fmt:formatNumber type="number" maxFractionDigits="3" value="${orderCount}" /> 건</b></h2>
							</span>
						</div>
					</i></span> 
				</div>
			</div>
			<div class="col-12 col-sm-6 col-md-4">
				<div class="info-box mb-3" style="background-color: transparent; box-shadow: none;">
					<span class="info-box-icon bg-info elevation-1" id="icon" style="background: linear-gradient(#bca9e3, #824fd3);"><i class="fas fa-thumbs-up"> 
						<div class="info-box-content">
							<span class="info-box-text">베스트 셀러</span>
							<span class="info-box-number">
								<h2 style="font-size: 28px;"><b>${bestSeller}</b></h2>
							</span>
						</div>
					</i></span>
				</div>
			</div>
		
          <div class="col-lg-12">
			<br>
            <div class="card-primary card-outline" id="chartbox">
              <div class="card-body">
                <p class="card-text">
                  
                </p>
				<!-- 차트 (chart js)-->
				<h3 style="text-align:center;">일별 매출</h3>
				<canvas id="chart" style="width:200px; height:100px;"></canvas>
				<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		          
			</div>
		</p>
            </div><!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
<!-- /.content-wrapper -->


<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/js_css/dist/js/adminlte.min.js"></script>
					
<!-- 차트 (chart js)-->
<script>
var jsonData = ${json} // Controller 에서 가공하여 넘겨준 데이터를 jstl 문법을 통해 변수에 담기
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
			
		}],
		options: {
			title: {
				display: true,
				text: '일별 매출'
			}
		}
};

const chart = document.querySelector("#chart").getContext('2d');
new Chart(chart, {
	type: 'line',
	data: data
})

</script>
<%@ include file="../inc/sellerFooter.jsp"%>
