<!--희원5 상진5-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- 메인 -->
<script type="text/javascript">
	function optionDisplay(frm) {
		var option = frm.selectOption.selectedIndex;
		switch (option) {
		case 0:
			frm.option.value = '[필수] 옵션을 선택하세요';
			break;
		case 1:
			frm.option.value = 'iPhone X/XS';
			break;
		case 2:
			frm.option.value = 'iPhone X/XS Max';
			break;
		case 3:
			frm.option.value = 'iPhone 11';
			break;
		case 4:
			frm.option.value = 'iPhone 11 Max';
			break;
		case 5:
			frm.option.value = 'iPhone 12';
			break;
		case 6:
			frm.option.value = 'iPhone 12 Max';
			break;
		}
		return true;
	}
</script>
<main class="mainH">
	<div class="container">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4>스마트톡</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath}/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">스마트톡</li>
					</ol>
				</nav>
			</div>
		</div>
		<div>
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="${contextPath}/resources/img/smartTok.png" alt="스마트톡" />
					</div>
					<div class="col-md-6">
						<!-- 상품명 -->
						<div class="row">
							<div class="col-md-3">상품명 :</div>
							<div class="col-md-9">스마트톡</div>
						</div>
						<br>
						<!-- 상품가격-->
						<div class="row">
							<div class="col-md-3">상품가격 :</div>
							<div class="col-md-9">10000원</div>
						</div>
						<br>
						<!-- 배송비 -->
						<div class="row">
							<div class="col-md-3">배송비 :</div>
							<div class="col-md-9">2500원</div>
						</div>
						<hr>
						<!-- 색상/기종 -->
						<!-- <div class="row">
							<div class="col-md-3">색상/기종 :</div>
							<div class="col-md-9">							
								<select id="option" class="form-control" style="width: 200px;" onchange="selectOption">
									<option selected>색상/기종 선택</option>
									<option>iPhoneX/XS</option>
									<option>iPhoneX/XS Max</option>
									<option>iPhone11</option>
									<option>iPhone11 Max</option>
									<option>iPhone12</option>
									<option>iPhone12 Max</option>
								</select>
							</div>
						</div> -->
						<form name="frm">
							<table border="1" width="500" align="center">
								<tr>
									<td align="left" width="120">색상/기종 선택</td>
									<td width="400"><select name="selectOption"
										onchange="optionDisplay(this.form)">
											<option selected value=0>[필수] 옵션을 선택하세요
											<option value=1>iPhone X/XS
											<option value=2>iPhone X/XS Max
											<option value=3>iPhone 11
											<option value=4>iPhone 11 Max
											<option value=5>iPhone 12
											<option value=6>iPhone 12 Max
									</select></td>
								</tr>
								<tr>
									<td align="left" width="120">색상/기종</td>
									<td width="400"><input name="option" type="text" size="50"
										maxlength="50"></td>
								</tr>
							</table>
						</form>
						<hr>
						<!-- 선택한 상품-->
						<div class="row">
							<div class="col-md-5">선택된 상품명</div>
							<div class="col-md-4">선택된 상품의 수량</div>
							<div class="col-md-3">금액</div>
						</div>
						<!-- 총 가격-->
						<hr>
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-2"></div>
							<div class="col-md-3">총 가격 :</div>
							<div class="col-md-3">10000원</div>
						</div>
						<br>
						<!-- 바로구매/장바구니/관심상품 버튼-->
						<div class="d-flex justify-content-around">
							<div class="p-2 bd-highlight">
								<a href="${contextPath}resources/img/orderList.do"
									class="btn btn-lg btn-outline-secondary">바로구매</a>
							</div>
							<div class="p-2 bd-highlight">
								<a href="#" class="btn btn-lg btn-outline-secondary">장바구니</a>
							</div>
							<div class="p-2 bd-highlight">
								<a href="#" class="btn btn-lg btn-outline-secondary">관심상품</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-3">
			<h2 class="fw-bolder mb-4">Recommend Items</h2>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="${contextPath }/resources/img/케이스이미지2.PNG" alt="케이스이미지" />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">귤곰 케이스</h5>
								<!-- Product price-->
								12000원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">자세히보기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="${contextPath}/resources/img/케이스이미지3.PNG" alt="케이스이미지" />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">곰귤 케이스</h5>
								<!-- Product reviews-->
								<!-- <div class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div> -->
								<!-- Product price-->
								12000원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">자세히보기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="${contextPath}/resources/img/케이스이미지4.PNG" alt="케이스이미지" />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">귤곰 케이스</h5>
								<!-- Product price-->
								12000원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">자세히보기</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="${contextPath}/resources/img/케이스이미지.PNG" alt="케이스이미지" />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">곰귤 케이스</h5>
								<!-- Product reviews-->
								<!-- <div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div> -->
								<!-- Product price-->
								12000원
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">자세히보기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 상세설명란 -->
	<div class="py-5">
		<nav>
		<div class="d-flex justify-content-center mt-5">
			<div class="nav nav-tabs" id="nav-tab" role="tablist">
				<a class="nav-item nav-link active" id="nav-home-tab"
					data-toggle="tab" href="#nav-home" role="tab"
					aria-controls="nav-home" aria-selected="true">상품 상세정보</a>
				<a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
					href="#nav-profile" role="tab" aria-controls="nav-profile"
					aria-selected="false">구매 가이드</a>
				<a class="nav-item nav-link" id="nav-contact-tab1" data-toggle="tab" 
					href="#nav-contact1" role="tab" aria-controls="nav-contact" 
					aria-selected="false">REVIEW</a>
				<a class="nav-item nav-link" id="nav-contact-tab2" data-toggle="tab"
					href="#nav-contact2" role="tab" aria-controls="nav-contact"
					aria-selected="false">Q&A</a>
			</div>
		</div>
		</nav>
		<div class="text-center">
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
				aria-labelledby="nav-home-tab">
				<img hspace="5" vspace="0"
					src="${contextPath }/resources/img/smartTok.png" alt="스마트톡">
			</div>
			<div class="tab-pane fade" id="nav-profile" role="tabpanel"
				aria-labelledby="nav-profile-tab">구매 가이드란</div>
			<div class="tab-pane fade" id="nav-contact1" role="tabpanel"
				aria-labelledby="nav-contact-tab1">REVIEW</div>
			<div class="tab-pane fade" id="nav-contact2" role="tabpanel"
				aria-labelledby="nav-contact-tab2">Q&A</div>
		</div>
		</div>
	</div>
	</div>
</main>