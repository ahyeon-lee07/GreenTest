<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- 그린 스타일 -->
<link rel="stylesheet" href="resources/css/greenStyle.css">

<title>G2.1_하드 케이스</title>
</head>
<body>
	<!-- 메인 -->
	<main class="mainH">
		<div class="container">
			<!-- 페이지 타이틀 부분 -->
			<div class="d-flex justify-content-between mt-5">
				<div class="bd-highlight">
					<h4>하드 케이스</h4>
				</div>
				<div class="bd-highlight">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb p-0 bg bg-transparent">
							<li class="breadcrumb-item"><a
								href="${contextPath }/main.do">홈</a></li>
							<li class="breadcrumb-item active" aria-current="page">하드 케이스</li>
						</ol>
					</nav>
				</div>
			</div>

			<div>
				<div class="d-flex flex-row-reverse bd-highlight">
					<div class="p-2 bd-highlight">
						<a href="#">높은가격</a>
					</div>
					<div class="p-2 bd-highlight">
						<a href="#">낮은가격</a>
					</div>
					<div class="p-2 bd-highlight">
						<a href="#">신상품</a>
					</div>
					<div class="p-2 bd-highlight">
						<a href="#">인기순</a>
					</div>
				</div>
				<div class="container px-4 px-lg-5 mt-3">
					<div
						class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Product image-->
								<!-- <img class="card-img-top" src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." />  -->
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 1</h6>
										<!-- Product price-->
										12,000원
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-sm btn-outline-success"
											href="${contextPath}/orderList.do" role="button">바로구매</a> 
										<a href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">관심상품</a>
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
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 2</h6>
										<!-- Product price-->
<<<<<<< HEAD
										$18.00
=======
										10,000원
>>>>>>> refs/heads/jin
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-sm btn-outline-success"
											href="${contextPath}/orderList.do" role="button">바로구매</a> 
										<a
<<<<<<< HEAD
											href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">
										관심상품</a>
=======
											href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">관심상품</a>
>>>>>>> refs/heads/jin
									</div>
								</div>
							</div>
						</div>
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Sale badge-->
								<div class="badge bg-dark text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">New</div>
								<!-- Product image-->
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 3</h6>
										<!-- Product price-->
<<<<<<< HEAD
										$20.00
=======
										12,000원
>>>>>>> refs/heads/jin
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-sm btn-outline-success"
											href="${contextPath}/orderList.do" role="button">바로구매</a> 
										<a
<<<<<<< HEAD
											href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">
										관심상품</a>
=======
											href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">관심상품</a>
>>>>>>> refs/heads/jin
									</div>
								</div>
							</div>
						</div>
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Sale badge-->
								<div class="badge bg-dark text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">Hot</div>
								<!-- Product image-->
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 4</h6>
										<!-- Product price-->
<<<<<<< HEAD
										$18.00
=======
										10,000원
>>>>>>> refs/heads/jin
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a class="btn btn-sm btn-outline-success"
<<<<<<< HEAD
											href="${contextPath}/orderList.do" role="button">바로구매</a>
										<a
											href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">
										관심상품</a>
=======
											href="${contextPath}/orderList.do" role="button">바로구매</a> 
										<a
											href="${contextPath}/wist_list.do" class="btn btn-sm btn-outline-success">관심상품</a>
>>>>>>> refs/heads/jin
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
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 5</h6>
										<!-- Product reviews-->
										<div
											class="d-flex justify-content-center small text-warning mb-2">
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
										</div>
										<!-- Product price-->
<<<<<<< HEAD
										$20.00
=======
										12,000원
>>>>>>> refs/heads/jin
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a href="${contextPath}/orderList.do"
											class="btn btn-sm btn-outline-success">바로구매</a> 
										<a href="${contextPath}/wist_list.do"
											class="btn btn-sm btn-outline-success">관심상품</a>
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
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 6</h6>
										<!-- Product reviews-->
										<div
											class="d-flex justify-content-center small text-warning mb-2">
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
										</div>
										<!-- Product price-->
										10,000원
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a href="${contextPath}/orderList.do"
											class="btn btn-sm btn-outline-success">바로구매</a> 
										<a href="${contextPath}/wist_list.do"
											class="btn btn-sm btn-outline-success">관심상품</a>
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
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 7</h6>
										<!-- Product reviews-->
										<div
											class="d-flex justify-content-center small text-warning mb-2">
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
										</div>
										<!-- Product price-->
<<<<<<< HEAD
										$20.00
=======
										12,000원
>>>>>>> refs/heads/jin
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a href="${contextPath}/orderList.do"
											class="btn btn-sm btn-outline-success">바로구매</a> 
										<a href="${contextPath}/wist_list.do"
											class="btn btn-sm btn-outline-success">관심상품</a>
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
								<a href="${contextPath}/HardCaseDetail.do"><img
									class="card-img-top"
									src="${contextPath }/resources/img/케이스이미지.PNG" alt="..." /></a>
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h6 class="fw-bolder">[하드] 하드 케이스 8</h6>
										<!-- Product reviews-->
										<div
											class="d-flex justify-content-center small text-warning mb-2">
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
											<div class="bi-star-fill"></div>
										</div>
										<!-- Product price-->
										10,000원
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
										<a href="${contextPath}/orderList.do"
											class="btn btn-sm btn-outline-success">바로구매</a> 
										<a href="${contextPath}/wist_list.do"
											class="btn btn-sm btn-outline-success">관심상품</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>