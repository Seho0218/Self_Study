<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

body {
  line-height: 1.5;
  min-height: 100vh;
  font-family: "Be Vietnam Pro", sans-serif;
  background: #f2f2f2;
}


.responsive-wrapper {
  width: 90%;
  max-width: 1280px;
  margin-left: auto;
  margin-right: auto;
}

.content {
  margin-top: 2rem;
  display: flex;
  align-items: flex-start;
}

.content-panel {
  display: none;
  max-width: 280px;
  width: 25%;
  padding: 2rem 1rem 2rem 1rem;
  margin-right: 3rem;
}

@media (min-width: 800px) {
  .content-panel {
    display: block;
  }
}

.vertical-tabs {
  display: flex;
  flex-direction: column;
  background-color: white;
  border-radius: 8px;
}
.vertical-tabs a {
  display: flex;
  align-items: center;
  padding: 0.75em 1em;
  background-color: transparent;
  border-radius: 3px;
  text-decoration: none;
  font-weight: 500;
  color: #3e3e3e;
  transition: 0.15s ease;
}
.vertical-tabls a:first-child {
  border-left: 5px solid red;
}

.vertical-tabs div {
  display: flex;
  align-items: center;
  padding: 0.75em 1em;
}
.vertical-tabs div span {
  width: 40px;
  height: 40px;
  border-radius: 8px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
}
.vertical-tabs div span img {
  max-height: 100%;
}
.vertical-tabs div h3 {
  margin-left: 0.75rem;
  font-weight: 500;
}
.vertical-tabs div h4 {
  margin-left: 0.75rem;
  font-weight: 500;
}

.content-main-top {
    background: white;
    width: 100%;
    height: 200px;
    margin-bottom: 30px;
    border-radius: 8px;
}

.content-main-top p{
  margin-top: 0;
  margin-bottom: .5rem;
  font-weight: 500;
  line-height: 1.2;
  padding: 1rem;
}

.content-main {
  padding-top: 2rem;
  padding-bottom: 6rem;
  flex-grow: 1;
}

.card-grid {
  display: grid;
  grid-template-columns: repeat(1, 1fr);
  -moz-column-gap: 1.5rem;
       column-gap: 1.5rem;
  row-gap: 1.5rem;
}
/* 태그 파트 안됨 
@media (min-width: 600px) {
  .card-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}
@media (min-width: 1200px) {
  .card-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}
*/
.card {
  background-color: #fff;
  border-radius: 8px;
  overflow: hidden;
  display: flex;
  flex-direction: column;
}

.card-header {
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  padding: 1.5rem 1.25rem 1rem 1.25rem;
}
.card-header div {
  display: flex;
  align-items: center;
}
.card-header div span {
  width: 40px;
  height: 40px;
  border-radius: 8px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
}
.card-header div span img {
  max-height: 100%;
}
.card-header div h3 {
  margin-left: 0.75rem;
  font-weight: 500;
}

.card-body {
  padding: 1rem 1.25rem;
  font-size: 0.875rem;
}

.card-footer {
  margin-top: auto;
  padding: 1rem 1.25rem;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  border-top: 1px solid var(--c-border-primary);
}
.card-footer a {
  color: #3e3e3e;
  text-decoration: none;
  font-weight: 500;
  font-size: 0.875rem;
}
</style>

<script>

</script>

<main class="main">

	<div class="responsive-wrapper">

		<div class="content">
			<div class="content-panel">
				<div class="vertical-tabs">
					<div>
						<span><img src="https://pngimg.com/uploads/circle/circle_PNG23.png" /></span>
						<h3>회원정보</h3>
					</div>
					<a href="#"><ul class="fa-ul"><li><i class="fa-li fa fa-envelope"></i>Inbox</li></ul></a>
					<a href="#"><ul class="fa-ul"><li><i class="fa-li fa fa-square"></i>상품관리</li></ul></a>
					<a href="#"><ul class="fa-ul"><li><i class="fa-li fa fa-square"></i>주문관리</li></ul></a>
					<a href="#"><ul class="fa-ul"><li><i class="fa-li fa fa-square"></i>고객관리</li></ul></a>
					<a href="#"><ul class="fa-ul"><li><i class="fa-li fa fa-square"></i>More</li></ul></a>				
				</div>
			</div>
			<div class="content-main">
				<div class="content-main-top">
					<p>관리자 관련 정보를 한번에 볼 수 있는 Dashboard</p>
				</div>
				<div class="card-grid">
					<article class="card">
						<div class="card-header">
							<div>
								<span><img src="https://pngimg.com/uploads/circle/circle_PNG23.png" /></span>
								<h3>카테고리</h3>
							</div>

						</div>
						<div class="card-body">
							<c:forEach var="vo" items="${list }">
								<h3>${vo.category_id}</h3>
								<p>${vo.product_category}</p>
							</c:forEach>
						</div>
						<div class="card-footer">
							<a href="#">더 보기</a>
						</div>
					</article>
					<!-- 태그 파트 절반 
					<article class="card">
						<div class="card-header">
							<div>
								<span><img src="https://pngimg.com/uploads/circle/circle_PNG23.png" /></span>
								<h3>태그</h3>
							</div>
						</div>
						<div class="card-body">
							<c:forEach var="vo" items="${list }">
								<h3>${vo.product_tag_id}</h3>
								<p>${vo.product_tag}</p>
							</c:forEach>
						</div>
						<div class="card-footer">
							<a href="#">더 보기</a>
						</div>
					</article>
					-->
				</div>
			</div>
		</div>
	</div>
</main>