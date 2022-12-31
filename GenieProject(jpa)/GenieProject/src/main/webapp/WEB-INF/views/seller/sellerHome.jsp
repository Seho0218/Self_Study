<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seller Dashboard</title>
    <!-- material icons cdn -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@48,400,1,0" />
    <!-- google fonts (Korean)-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <!-- google fonts (English)-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- stylesheet -->
    <link rel="stylesheet" href="../js_css/css/sellerstyle.css">
</head>
<body>
    <!-- start of nav bar -->
    <nav>
        <div class="container">
            <img src="../images/seller/logo.png" class="logo">
            <div class="search-bar">
                <span class="material-symbols-sharp">search</span>
                <input type="search" placeholder="검색하기">
            </div>
            <div class="profile-area">
                <div class="theme-btn">
                    <span class="material-symbols-sharp active">light_mode</span>
                    <span class="material-symbols-sharp">dark_mode</span>
                </div>
                <div class="profile">
                    <div class="profile-photo">
                        <img src="../images/seller/profile-1.png">
                    </div>
                    <h5>Minjin Kim</h5>
                    <span class="material-symbols-sharp">expand_more</span>
                </div>
                <button id="menu-btn">
                    <span class="material-symbols-sharp">menu</span>
                </button>
            </div>
        </div>
    </nav>
    <!-- end of nav bar -->

    <main>
        <!-- aside start -->
        <aside>
            <button id="close-btn">
                <span class="material-symbols-sharp">close</span>
            </button>
            <!-- sidebar start -->
            <div class="sidebar">
                <a href="#" class="active">
                    <span class="material-symbols-sharp">dashboard</span>
                    <h4>대시보드</h4>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">place_item</span>
                    <h4>상품등록</h4>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">manage_search</span>
                    <h4>상품관리</h4>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">sell</span>
                    <h4>주문관리</h4>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">paid</span>
                    <h4>매출관리</h4>
                </a>
                <a href="#">
                    <span class="material-symbols-sharp">live_help</span>
                    <h4>문의관리</h4>
                </a>
            </div>
            <!-- end of sidebar -->

            <div class="updates">
                <span class="material-symbols-sharp">update</span>
                <h4>업데이트 가능</h4>
                <p>보안 업데이트</p>
                <p>대시보드 업데이트</p>
                <a href="#">실시간 업데이트</a>
            </div>
        </aside>
        <!-- end of aside -->

        <!-- 가운데 섹션 시작 -->
        <section class="middle">
            <div class="header">
                <h1>한눈에 보기</h1>
                <input type="date">
            </div>

            <div class="cards">
                <div class="card">
                    <div class="top">
                        <div class="left">
                            <span class="material-symbols-sharp">local_shipping</span>
                            <h2>주문/배송</h2>
                        </div>
                        <div class="right">
                           <!--카드에 오른쪽 상단에 추가하고싶은 내용이나, 아이콘 넣을 공간-->
                        </div>
                    </div>
                    <div class="middle">
                        <h1>3 건의 주문이 있습니다.</h1>
                    </div>
                    <div class="bottom">
                        <!--카드 아래에 추가내용--> 
                    </div>
                </div>
                <!-- end of card 1 -->
                <div class="card">
                    <div class="top">
                        <div class="left">
                            <span class="material-symbols-sharp">inventory_2</span>
                            <h2>이달의 상품</h2>
                        </div>
                        <div class="right">
                             <!--카드에 오른쪽 추가하고싶은 내용이나, 아이콘 넣을 공간-->
                        </div>
                    </div>
                    <div class="middle">
                        <h1>토이스토리 우디</h1>
                    </div>
                    <div class="bottom">
                       <!--카드 아레에 추가내용-->
                    </div>
                </div>
                <!-- end of card 2 -->
                <div class="card">
                    <div class="top">
                        <div class="left">
                            <span class="material-symbols-sharp">support_agent</span>
                            <h2>미답변 문의</h2>
                        </div>
                        <div class="right">
                            <!--카드 오른쪽 상단에 추가하고싶은 내용이나, 아이콘 넣을 공간-->
                        </div>
                    </div>
                    <div class="middle">
                        <h1>10 건의 미답변 문의가 있습니다.</h1>
                    </div>
                    <div class="bottom">
                        <!--카드 아레에 추가내용-->
                    </div>
                </div>
                <!-- end of card 3 -->
            </div>
            <!-- end of cards -->

            <div class="monthly-report">
                <div class="report">
                    <h3>주문건수</h3>
                    <div>
                        <details>
                            <h1>777건</h1>
                            <h6 class="success">+30.56%</h6>
                        </details>
                        <p class="text-muted">지난달 대비</p>
                    </div>
                </div>
                <!-- end of orders report -->
                <div class="report">
                    <h3>매출</h3>
                    <div>
                        <details>
                            <h1>$100,000</h1>
                            <h6 class="success">+20.42%</h6>
                        </details>
                        <p class="text-muted">지난달 대비</p>
                    </div>
                </div>
                <!-- end of income report -->
                <div class="report">
                    <h3>평점</h3>
                    <div>
                        <details>
                            <h1>4.9점</h1>
                            <h6 class="success">+4.22%</h6>
                        </details>
                        <p class="text-muted">지난달 대비</p>
                    </div>
                </div>
                <!-- end of ratings report -->
                <div class="report">
                    <h3>새로운 고객</h3>
                    <div>
                        <details>
                            <h1>53명</h1>
                            <h6 class="success">+15.82%</h6>
                        </details>
                        <p class="text-muted">지난달 대비</p>
                    </div>
                </div>
                <!-- end of customer report -->
            </div>
            <!-- end of monthly report-->

            <div class="fast-payment">
                <h2>재고 추가</h2><br/>
                <div class="badges">
                    <div class="badge">
                        <span class="material-symbols-sharp">add</span>
                    </div>
                    <div class="badge">
                        <span class="bg-primary"></span>
                        <div>
                            <h5>키덜트</h5>
                            <h4>100개</h4>
                        </div>
                    </div>
                    <div class="badge">
                        <span class="bg-primary"></span>
                        <div>
                            <h5>가벼운선물</h5>
                            <h4>50개</h4>
                        </div>
                    </div>
                    <div class="badge">
                        <span class="bg-primary"></span>
                        <div>
                            <h5>생일</h5>
                            <h4>30개</h4>
                        </div>
                    </div>
                    <div class="badge">
                        <span class="bg-primary"></span>
                        <div>
                            <h5>추석</h5>
                            <h4>50개</h4>
                        </div>
                    </div>
                    <div class="badge">
                        <span class="bg-primary"></span>
                        <div>
                            <h5>건강/회복</h5>
                            <h4>10개</h4>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end of fast payment-->

            <canvas id="chart"></canvas>

        </section>
        <!-- 가운데 섹션 끝 -->

        <!-- 오른쪽 섹션 시작-->
        <section class="right">
            <div class="investments">
                <div class="header">
                    <h2>아이템별 매출</h2>
                    <a href="#">더보기 <span class="material-symbols-sharp">chevron_right</span></a>
                </div>

                <div class="investment">
                    <img src="../images/seller/kidult1.jpeg">
                    <h4>오징어게임 영희</h4>
                    <div class="date-time">
                        <p>최근 판매일: 9월 5일</p>
                        <small class="text-muted">9:14pm</small>
                    </div>
                    <div class="amount">
                        <h4>8,000,000원</h4>
                        <small class="success">+4.20%</small>
                    </div>
                </div>

                <div class="investment">
                    <img src="../images/seller/kidult2.jpeg">
                    <h4>토이스토리 우디</h4>
                    <div class="date-time">
                        <p>최근 판매일: 9월 3일</p>
                        <small class="text-muted">7:20pm</small>
                    </div>
                    <div class="amount">
                        <h4>2,000,000원</h4>
                        <small class="danger">-2.20%</small>
                    </div>
                </div>

                <div class="investment">
                    <img src="../images/seller/kidult3.jpeg">
                    <h4>토이스토리 외계인</h4>
                    <div class="date-time">
                        <p>최근 판매일: 9월 1일</p>
                        <small class="text-muted">12:34pm</small>
                    </div>
                    <div class="amount">
                        <h4>1,400,000원</h4>
                        <small class="success">+13.50%</small>
                    </div>
                </div>
            </div>
            <!------------------- end of recent investments ------------------------>

            <div class="recent-transactions">
                <div class="header">
                    <h2>재고 수량</h2>
                    <a href="#">더보기 <span class="material-symbols-sharp">chevron_right</span></a>
                </div>

                <div class="transaction">
                    <div class="service">
                        <div class="icon bg-purple-light">
                            <span class="material-symbols-sharp">smart_toy</span>
                        </div>
                        <div class="details">
                            <h4>키덜트</h4>
                        </div>
                    </div>
                    <h4>120개</h4>
                </div>
                <!-- end of transaction -->

                <div class="transaction">
                    <div class="service">
                        <div class="icon bg-danger-light">
                            <span class="material-symbols-sharp">event</span>
                        </div>
                        <div class="details">
                            <h4>추석</h4>
                        </div>
                    </div>
                    <h4>90개</h4>
                </div>
                <!-- end of transaction -->
                
                <div class="transaction">
                    <div class="service">
                        <div class="icon bg-primary-light">
                            <span class="material-symbols-sharp">redeem</span>
                        </div>
                        <div class="details">
                            <h4>선물</h4>
                        </div>
                    </div>
                    <h4>50개</h4>
                </div>
                <!-- end of transaction -->
                
                <div class="transaction">
                    <div class="service">
                        <div class="icon bg-success-light">
                            <span class="material-symbols-sharp">cake</span>
                        </div>
                        <div class="details">
                            <h4>생일</h4>
                        </div>
                    </div>
                    <h4>30개</h4>
                </div>
                <!-- end of transaction -->
            </div>
            <!------------------- end of recent transactions ------------------------>
        </section>
        <!-- 오른쪽 섹션 끝 -->
    </main>
    <!-- ============== end of aside ==================== -->

    <!-- 차트 (chart js)-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.0/chart.min.js" integrity="sha512-GMGzUEevhWh8Tc/njS0bDpwgxdCJLQBWG3Z2Ct+JGOpVnEmjvNx6ts4v6A2XJf1HOrtOsfhv3hBKpK9kE5z8AQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <script src="../js_css/js/sellerhome.js"></script>

    
</body>
</html>