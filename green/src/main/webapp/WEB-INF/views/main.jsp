<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!-- 메인 -->
<main class="mainH">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="${contextPath}/resources/img/main1.jpg" class="d-block w-100 carousel-size"
					alt="...">
			</div>
			<div class="carousel-item">
				<img src="${contextPath}/resources/img/main2.jpg" class="d-block w-100 carousel-size"
					alt="...">
			</div>
			<div class="carousel-item">
				<img src="${contextPath}/resources/img/main3.jpg" class="d-block w-100 carousel-size" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<div class="container">
		<!-- 팝업 라인 -->
		<div class="d-flex justify-content-between my-5">
			<div class="bd-highlight flex-fill border mx-2 popupBox">
				<img src="${contextPath}/resources/img/popup1.jpg" class="d-block w-100"
					alt="...">
			</div>
			<div class="bd-highlight flex-fill border mx-2 popupBox">
				<img src="${contextPath}/resources/img/popup2.jpg" class="d-block w-100"
					alt="...">
			</div>
			<div class="bd-highlight flex-fill border mx-2 popupBox">
				<img src="${contextPath}/resources/img/popup3.jpg" class="d-block w-100"
					alt="...">
			</div>
			<!-- 공지사항 -->
			<div class="bd-highlight mx-2 flex-fill flex-column">
				<div
					class="bd-highlight d-flex justify-content-between pb-2 border-bottom">
					<div class="bd-highlight font-weight-bold">공지사항</div>
					<div class="bd-highlight">
						<a href=""> <img src="${contextPath }/resources/img/plus.svg" alt="">
						</a>
					</div>
				</div>
				<div class="p-0 bd-highlight">
					<ul class="list-group">
						<li
							class="list-group-item list-group-item-action p-0 pb-1 border-0">공지사항1</li>
						<li
							class="list-group-item list-group-item-action p-0 pb-1 border-0">공지사항2</li>
						<li
							class="list-group-item list-group-item-action p-0 pb-1 border-0">공지사항3</li>
						<li
							class="list-group-item list-group-item-action p-0 pb-1 border-0">공지사항4</li>
						<li
							class="list-group-item list-group-item-action p-0 pb-1 border-0">공지사항5</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- 신상품 -->
	<div class="bg-light">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="row mt-5 mb-3">
						<div class="col">
							<h3 class="font-weight-bold text-center">신상품</h3>
						</div>
					</div>
					<div class="d-flex justify-content-around  mb-5">
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 베스트상품 -->
	<div class="">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="row mt-5 mb-3">
						<div class="col">
							<h3 class="font-weight-bold text-center">베스트상품</h3>
						</div>
					</div>
					<div class="d-flex justify-content-around  mb-5">
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 세일상품 -->
	<div class="bg-light">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="row mt-5 mb-3">
						<div class="col">
							<h3 class="font-weight-bold text-center">세일상품</h3>
						</div>
					</div>
					<div class="d-flex justify-content-around  mb-5">
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
						<div
							class="bd-highlight flex-fill flex-column bg-white border rounded mx-2">
							<img src="${contextPath }/resources/img/img.webp" class="card-img-top itemImg" alt="...">
							<div class="p-2 bd-highlight d-flex justify-content-between mt-2">
								<div class="bd-highlight d-flex flex-column">
									<div class="bd-highlight font-weight-bold mb-1">타이틀</div>
									<div class="bd-highlight">
										2000<span>원</span>
									</div>
								</div>
								<div class="bd-highlight">
									<img src="${contextPath }/resources/img/heart.svg" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</main>