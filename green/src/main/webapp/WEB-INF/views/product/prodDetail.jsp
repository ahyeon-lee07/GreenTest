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
<<<<<<< HEAD
<main class="mainH">
	<div class="container py-1">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4>상품 상세창</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath}/main.do">홈</a></li>
						<li class="breadcrumb-item"><a
							href="${contextPath}/prodList.do?p_group=${prodList.p_group}">상품
								목록</a></li>
						<li class="breadcrumb-item active" aria-current="page">상품
							상세페이지</li>
					</ol>
				</nav>
			</div>
		</div>
		<div>
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="${contextPath}/resources/img/${prodList.p_group}/${product_M}"
							alt="${prodList.productName}" />
					</div>
					<div class="col-md-6">
						<!-- 상품명 -->
						<div class="row">
							<div class="col-md-3">상품명 :</div>
							<div class="col-md-9">${prodList.productName}</div>
						</div>
						<br>
						<!-- 상품가격-->
						<div class="row">
							<div class="col-md-3">상품가격 :</div>
							<div class="col-md-9">${prodList.price}</div>
						</div>
						<br>
						<!-- 배송비 -->
						<div class="row">
							<div class="col-md-3">배송비 :</div>
							<div class="col-md-9">2500원</div>
						</div>
						<hr>
						<!-- 색상/기종 -->
						<form name="frm">
							<table width="500" align="center">
								<tr>
									<td align="left" width="120">색상/기종</td>
									<td width="400"><select name="prodOption" id="prodOption"
										class='total_cartAdd' style="width: 350px;">
											<option value="">(필수)옵션 선택</option>
											<c:forEach var="prodOption" items="${prodOption}" varStatus="index">
												<option value="${prodOption}">${prodOption.p_option}</option>
											</c:forEach>
									</select></td>
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

						<form id="frm" name="frm" method="post">
							<div>
								<table style="border: 1px;" id="dynamicTable">
									<thead>
									</thead>
									<tbody id="dynamicTbody">
									</tbody>
								</table>
							</div>
						</form>

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
								<a href="${contextPath}/orderList.do"
									class="btn btn-lg btn-outline-success"> 바로구매</a>
							</div>
							<div class="p-2 bd-highlight">
								<a href="${contextPath}/cart.do"
									class="btn btn-lg btn-outline-success"
									onclick="cart_checkform()">장바구니</a>
							</div>
							<div class="p-2 bd-highlight">
								<a href="${contextPath}/wist_list.do"
									class="btn btn-lg btn-outline-success"> 관심상품</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
						aria-controls="nav-home" aria-selected="true">상품 상세정보</a> <a
						class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
						href="#nav-profile" role="tab" aria-controls="nav-profile"
						aria-selected="false">구매 가이드</a> <a class="nav-item nav-link"
						id="nav-contact-tab1" data-toggle="tab" href="#nav-contact1"
						role="tab" aria-controls="nav-contact" aria-selected="false">REVIEW</a>
					<a class="nav-item nav-link" id="nav-contact-tab2"
						data-toggle="tab" href="#nav-contact2" role="tab"
						aria-controls="nav-contact" aria-selected="false">Q&A</a>
				</div>
			</div>
		</nav>
		<div class="text-center">
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<img hspace="5" vspace="0"
						src="${contextPath}/resources/img/${prodList.p_group}/${product_S}"
						alt="${prodList.productName}">
				</div>
				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<div class="d-flex justify-content-center mt-5">
						<div
							class="bd-highlight border d-flex flex-column text-center rounded py-3 px-5"
							style="width: 94%; max-width: 1060px; border: 1px solid #e7e7e7; border-radius: 7px; margin: 50px auto 85px; box-sizing: border-box;">
							<!-- 결제 정보 -->
							[상품 결제정보]<br> 고액결제의 경우 안전을 위해 카드사에서 확인전화를 드릴 수도 있습니다.<br>
							확인과정에서 도난 카드의 사용이나 타인 명의의 주문등 정상적인 주문이<br> 아니라고 판단될 경우 임의로
							주문을 보류 또는 취소할 수 있습니다.<br> <br> 무통장 입금은 상품 구매 대금은 PC뱅킹,
							인터넷뱅킹, 텔레뱅킹 혹은 가까운 은행에서 직접 입금하시면 됩니다.<br> 주문시 입력한 입금자명과
							실제입금자의 성명이 반드시 일치하여야 하며,<br> 7일 이내로 입금을 하셔야 하며 입금되지 않은 주문은
							자동취소 됩니다.<br> <br>
							<!-- 배송 안내 -->
							[배송 안내]<br> - 그린케이스는 우체국택배를 이용하며, 출고 이후 1-3일의 배송일이 소요됩니다.
							(주말제외)<br> <br> - 산간지역이나 도서지방은 별도의 추가금액을 지불하셔야 하는 경우가
							있습니다.<br> 고객님께서 주문하신 상품은 입금 확인후 배송해 드립니다.<br> 다만, 상품종류에
							따라서 상품의 배송이 다소 지연될 수 있습니다.<br> <br>
							<!-- 교환 및 반품 안내 -->
							[교환 및 반품 안내]<br> 교환 및 반품이 가능한 경우<br> - 업체측의 오배송 / 불량상품
							수령시 교환 및 반품이 가능합니다.<br> (불량 사유가 아닌 경우 : 1. 각 기종별 사출(공케이스)을
							달리 사용함으로서 동일한 프린팅에도 미세한 색감차이가 발생할 수 있습니다.<br> 2. 곡선(카메라,
							옆면)은 열처리로 인하여 발생하는 폰케이스 안쪽의 잉크스밈이 발생할 수 있습니다.<br> 3. 주문확인 후
							1:1 수작업으로 제작이 되기에 중앙에서 1-3mm의 이미지 오차가 생길 수 있습니다.<br> 4. 미세한
							먼지(작은점 포함)와 스크래치는 공정상 발생할 수 있으며, 필름지 찍힘은 불량에 해당되지 않습니다.<br>
							5. 전사 특성상 색상이 늘어지는 현상 및 연해지는 현상이 일어날 수 있으며, 모서리 부분 색이 입혀지지 않은 것은
							불량이 아닙니다.)<br> <br> 교환 및 반품이 불가능한 경우<br> - 모든 주문건은
							주문제작으로 진행이 되기에 제작에 들어간 이후 교환 및 환불이 어렵습니다.<br> - 고객님의 사용 또는
							일부 소비에 의하여 상품의 가치가 현저히 감소한 경우 교환 및 환불이 어렵습니다.<br> - 시간의 경과에
							의하여 재판매가 곤란할 정도로 상품등의 가치가 현저히 감소한 경우 교환 및 환불이 어렵습니다.<br> -
							불량사유에 해당되지 않는 경우<br> (불량 사유가 아닌 경우 : 1. 각 기종별 사출(공케이스)을 달리
							사용함으로서 동일한 프린팅에도 미세한 색감차이가 발생할 수 있습니다.<br> 2. 곡선(카메라, 옆면)은
							열처리로 인하여 발생하는 폰케이스 안쪽의 잉크스밈이 발생할 수 있습니다.<br> 3. 주문확인 후 1:1
							수작업으로 제작이 되기에 중앙에서 1-3mm의 이미지 오차가 생길 수 있습니다.<br> 4. 미세한
							먼지(작은점 포함)와 스크래치는 공정상 발생할 수 있으며, 필름지 찍힘은 불량에 해당되지 않습니다.<br>
							5. 전사 특성상 색상이 늘어지는 현상 및 연해지는 현상이 일어날 수 있으며, 모서리 부분 색이 입혀지지 않은 것은
							불량이 아닙니다.)<br> - 고객의 단순변심 혹은 주문실수(옵션선택)에 의한 교환 및 환불은 어렵습니다.<br>
							<br>
							<!-- 기타 안내 -->
							[기타 안내]<br> 언제나 성심성의껏 답해드리겠습니다!<br> 저희 그린케이스를 찾아주셔서
							감사합니다~ :D
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="nav-contact1" role="tabpanel"
					aria-labelledby="nav-contact-tab1">
					<iframe src="http://localhost:8080/green/review.do" width="90%"
						name="review" height="90%" frameborder="0" marginheight="0"
						marginwidth="0" scrolling="auto"></iframe>
				</div>
				<div class="tab-pane fade" id="nav-contact2" role="tabpanel"
					aria-labelledby="nav-contact-tab2">
					<iframe src="http://localhost:8080/green/product.do" width="90%"
						name="review" height="90%" frameborder="0" marginheight="0"
						marginwidth="0" scrolling="auto"></iframe>
				</div>
			</div>
		</div>
		</div>
</main>

<!-- 장바구니 -->
<script type="text/javascript">
	function cart_checkform() {
		alert("해당 상품을 장바구니에 담았습니다!");
	}
</script>

=======
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
				<h4>상품 상세창</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath}/main.do">홈</a></li>
						<!-- <li class="breadcrumb-item"><a href="${contextPath}/prodList.do">상품 목록</a></li> -->
						<li class="breadcrumb-item active" aria-current="page">상품 상세창</li>
					</ol>
				</nav>
			</div>
		</div>
		<div>
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="${contextPath}/resources/img/${ProductVO.p_group}/${product_M}" 
							alt="${prodList.productName}" />
					</div>
					<div class="col-md-6">
						<!-- 상품명 -->
						<div class="row">
							<div class="col-md-3">상품명 :</div>
							<div class="col-md-9">
								<input type="text" value="${ProductVO.productName}" readonly>
							</div>
						</div>
						<br>
						<!-- 상품가격-->
						<div class="row">
							<div class="col-md-3">상품가격 :</div>
							<div class="col-md-9">
								<input type="text" value="${ProductVO.price}" readonly>
							</div>
						</div>
						<br>
						<!-- 배송비 -->
						<div class="row">
							<div class="col-md-3">배송비 :</div>
							<div class="col-md-9">2500원</div>
						</div>
						<hr>
						<!-- 색상/기종 -->
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
								<a href="${contextPath}/orderList.do"
									class="btn btn-lg btn-outline-success">
								바로구매</a>
							</div>
							<div class="p-2 bd-highlight">
								<a href="${contextPath}/cart.do" class="btn btn-lg btn-outline-success"
								onclick="cart_checkform()">장바구니</a>
							</div>
							<div class="p-2 bd-highlight">
								<a href="${contextPath}/wist_list.do" class="btn btn-lg btn-outline-success">
								관심상품</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
								<a class="btn btn-outline-success mt-auto" href="#">자세히보기</a>
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
					src="${contextPath}/resources/img/${ProductVO.p_group}/${product_S}" alt="${prodList.productName}">
			</div>
			<div class="tab-pane fade" id="nav-profile" role="tabpanel"
				aria-labelledby="nav-profile-tab">
				<div class="d-flex justify-content-center mt-5">
				<div class="bd-highlight border d-flex flex-column text-center rounded py-3 px-5" style="width: 94%; 
				max-width: 1060px; border: 1px solid #e7e7e7; border-radius: 7px; margin: 50px auto 85px; box-sizing: border-box;">
				<!-- 결제 정보 -->
				[상품 결제정보]<br>
				고액결제의 경우 안전을 위해 카드사에서 확인전화를 드릴 수도 있습니다.<br>
				확인과정에서 도난 카드의 사용이나 타인 명의의 주문등 정상적인 주문이<br> 
				아니라고 판단될 경우 임의로 주문을 보류 또는 취소할 수 있습니다.<br>
				<br>
				무통장 입금은 상품 구매 대금은 PC뱅킹, 인터넷뱅킹, 텔레뱅킹 혹은 가까운 은행에서 직접 입금하시면 됩니다.<br>
				주문시 입력한 입금자명과 실제입금자의 성명이 반드시 일치하여야 하며,<br>
				7일 이내로 입금을 하셔야 하며 입금되지 않은 주문은 자동취소 됩니다.<br>
				<br>
				<!-- 배송 안내 -->
				[배송 안내]<br>
				- 그린케이스는 우체국택배를 이용하며, 출고 이후 1-3일의 배송일이 소요됩니다. (주말제외)<br>
				<br>
				- 산간지역이나 도서지방은 별도의 추가금액을 지불하셔야 하는 경우가 있습니다.<br>
				고객님께서 주문하신 상품은 입금 확인후 배송해 드립니다.<br>
				다만, 상품종류에 따라서 상품의 배송이 다소 지연될 수 있습니다.<br>
				<br>
				<!-- 교환 및 반품 안내 -->
				[교환 및 반품 안내]<br>
				교환 및 반품이 가능한 경우<br>
				- 업체측의 오배송 / 불량상품 수령시 교환 및 반품이 가능합니다.<br>
				(불량 사유가 아닌 경우 : 1. 각 기종별 사출(공케이스)을 달리 사용함으로서 동일한 프린팅에도 미세한 색감차이가 발생할 수 있습니다.<br>
									2. 곡선(카메라, 옆면)은 열처리로 인하여 발생하는 폰케이스 안쪽의 잉크스밈이 발생할 수 있습니다.<br>
                                    3. 주문확인 후 1:1 수작업으로 제작이 되기에 중앙에서 1-3mm의 이미지 오차가 생길 수 있습니다.<br>
                                    4. 미세한 먼지(작은점 포함)와 스크래치는 공정상 발생할 수 있으며, 필름지 찍힘은 불량에 해당되지 않습니다.<br>
                                    5. 전사 특성상 색상이 늘어지는 현상 및 연해지는 현상이 일어날 수 있으며, 모서리 부분 색이 입혀지지 않은 것은 불량이 아닙니다.)<br>
                <br>
                교환 및 반품이 불가능한 경우<br>
				- 모든 주문건은 주문제작으로 진행이 되기에 제작에 들어간 이후 교환 및 환불이 어렵습니다.<br>
				- 고객님의 사용 또는 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우 교환 및 환불이 어렵습니다.<br>
				- 시간의 경과에 의하여 재판매가 곤란할 정도로 상품등의 가치가 현저히 감소한 경우 교환 및 환불이 어렵습니다.<br>
				- 불량사유에 해당되지 않는 경우<br>
				(불량 사유가 아닌 경우 : 1. 각 기종별 사출(공케이스)을 달리 사용함으로서 동일한 프린팅에도 미세한 색감차이가 발생할 수 있습니다.<br>
                                           2. 곡선(카메라, 옆면)은 열처리로 인하여 발생하는 폰케이스 안쪽의 잉크스밈이 발생할 수 있습니다.<br>
                                           3. 주문확인 후 1:1 수작업으로 제작이 되기에 중앙에서 1-3mm의 이미지 오차가 생길 수 있습니다.<br>
                                           4. 미세한 먼지(작은점 포함)와 스크래치는 공정상 발생할 수 있으며, 필름지 찍힘은 불량에 해당되지 않습니다.<br>
                                           5. 전사 특성상 색상이 늘어지는 현상 및 연해지는 현상이 일어날 수 있으며, 모서리 부분 색이 입혀지지 않은 것은 불량이 아닙니다.)<br>
				- 고객의 단순변심 혹은 주문실수(옵션선택)에 의한 교환 및 환불은 어렵습니다.<br>
				<br>
				<!-- 기타 안내 -->
				[기타 안내]<br>
				언제나 성심성의껏 답해드리겠습니다!<br>
				저희 그린케이스를 찾아주셔서 감사합니다~ :D
				</div>
				</div>
			</div>
			<div class="tab-pane fade" id="nav-contact1" role="tabpanel"
				aria-labelledby="nav-contact-tab1">
				<iframe src="http://localhost:8080/green/review.do" width="90%" name="review" 
				height="90%" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe>
			</div>
			<div class="tab-pane fade" id="nav-contact2" role="tabpanel"
				aria-labelledby="nav-contact-tab2">
				<iframe src="http://localhost:8080/green/product.do" width="90%" name="review" 
				height="90%" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe>
			</div>
	</div>
	</div>
</main>

<!-- 장바구니 -->
<script type="text/javascript">
function cart_checkform() {
alert("해당 상품을 장바구니에 담았습니다!");
}
</script>
>>>>>>> branch 'hw' of https://github.com/ahyeon-lee07/GreenTest.git
