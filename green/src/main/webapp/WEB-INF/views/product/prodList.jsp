<!--희원5 상진5-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
	<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<% request.setCharacterEncoding("UTF-8"); %>
					<c:set var="contextPath" value="${pageContext.request.contextPath}" />
					<!-- 메인 -->
					<main class="mainH">
						<div class="container py-1">
							<!-- 페이지 타이틀 부분 -->
							<div class="d-flex justify-content-between mt-5">
								<div class="bd-highlight">
									<h4 class="page_title">${pageTitle }</h4>
								</div>
								<div class="bd-highlight page_subtitle">
									<nav aria-label="breadcrumb">
										<ol class="breadcrumb p-0 bg bg-transparent">
											<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
											<li class="breadcrumb-item active" aria-current="page">${pageTitle }</li>
										</ol>
									</nav>
								</div>
							</div>

							<div class="d-flex flex-row-reverse bd-highlight border-bottom">
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

							<div class="d-flex flex-wrap mb-2">
								<c:forEach var="product" items="${productsList}">
									<div class="bd-highlight prodList">
										<a class="d-flex flex-column mx-3 my-2 p-3 text-center prodbox"
											href="${contextPath}/prodList/prodDetail.do${pageMaker.makeQueryPage(bList.IDX, pageMaker.cri.page) }productId=${product.productId}">
											<div class="bd-highlight productImgBox">
												<!-- Product image-->
												<img class="card-img-top" src="${contextPath }/resources/img/${product.p_group}/${product.imgURL}" alt="${product.productName}"
													style="object-fit: cover; height:180px;">
											</div>
											<div class="bd-highlight font-weight-bold text-secondary text-left productListTitle mt-2">
												<p class="ell">${product.productName}</p>
											</div>
											<div class="d-flex bd-highlight flex-column text-left my-3" style="height: 46px;">
												<c:choose>
													<c:when test="${product.discountYN == 'Y'}">
														<div class="bd-highlight text-black-50 discountBox" style="font-size:.9rem; width: 50%;">
															<fmt:formatNumber value="${product.price}" pattern="##,###" /><span>원</span>		
														</div>
														<div class="bd-highlight text-danger font-weight-bold">
															<fmt:formatNumber value="${product.discount}" pattern="##,###" /><span>원</span>		
														</div>
													</c:when>
													<c:otherwise>
														<div class="bd-highlight text-danger font-weight-bold">
															<fmt:formatNumber value="${product.price}" pattern="##,###" /><span>원</span>		
														</div>
													</c:otherwise>
												</c:choose>
											</div>
											<div class="d-flex justify-content-center mt-2">
												<div class="bd-highlight btn btn-sm btn-outline-secondary mr-1 btn_product"
													href="${contextPath}/wist_list.do">바로구매</div>
												<div class="bd-highlight btn btn-sm btn-outline-success ml-1 btn_product"
													href="${contextPath}/orderList.do">관심상품</div>
											</div>
										</a>
									</div>
								</c:forEach>
							</div>
							
							<!-- 페이징 영역 -->
							<nav aria-label="Page navigation example row">
								<ul class="pagination d-flex justify-content-center">
									<c:if test="${pageMaker.prev }">
										<li class="page-item"><a class="page-link"
												href='<c:url value="/prodList.do?page=${pageMaker.startPage-1 }"/>'
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
									</c:if>
									<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
										var="pageNum">
										<li class="page-item">
											<a class="page-link" href='${contextPath }/prodList.do?page=${pageNum }&options=${options }'>${pageNum}</a>
										</li>
									</c:forEach>
									<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
										<li class="page-item"><a class="page-link"
												href='<c:url value="/prodList.do?page=${pageMaker.endPage+1 }"/>'
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
									</c:if>
								</ul>
							</nav>

						</div>
					</main>