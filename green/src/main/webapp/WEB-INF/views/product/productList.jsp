<!--상진8 규찬2-->
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
<main class="mainH">
	<div class="container">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4 class="page_title">상품등록</h4>
			</div>
			<div class="bd-highlight page_subtitle">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">상품등록</li>
					</ol>
				</nav>
			</div>
		</div>

		<!-- 필터영역 -->
		<div class="d-flex justify-content-start border-bottom mt-2">
			<div class="bd-highlight btn-group btn-group-toggle mb-2"
				data-toggle="buttons">
				<label class="btn btn-outline-secondary active"> <input
					type="radio" name="options" id="option1" checked> All
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option2"> hard
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option3"> gel
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option3"> card
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option3"> airPods
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option3"> buds
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option3"> keyring
				</label> <label class="btn btn-outline-secondary"> <input
					type="radio" name="options" id="option3"> smart
				</label>
			</div>
		</div>

		<table class="table table-hover m-0">
			<thead class=" border-bottom-0 bg-light">
				<tr>
					<th
						class="text-center border-bottom-0 align-middle border-top-0 px-1"
						style="width: 36px">
						<div>
							<input type='checkbox' name='selectall' value='selectall'
								onclick='selectAll(this)' />
						</div>
					</th>
					<th class="text-center border-bottom-0 border-top-0 px-2"
						style="width: 120px">이미지</th>
					<th class="text-center border-bottom-0 border-top-0 px-2"
						style="width: 86px">상품구분</th>
					<th class="text-center border-bottom-0 border-top-0 px-2"
						style="width: auto">상품 정보</th>
					<th class="text-center border-bottom-0 border-top-0 px-2"
						style="width: 76px">판매가</th>
					<th class="text-center border-bottom-0 border-top-0 px-2"
						style="width: 66px">적립금</th>
					<th class="text-center border-bottom-0 border-top-0 px-2"
						style="width: 90px">상세정보</th>
				</tr>
			</thead>
			<tbody class="border-bottom">
				<!-- <tr class="">
					<th class="text-center align-middle align-middle px-1">
						<div>
							<input type='checkbox' name='Choice' />
						</div>
					</th>
					<td class="text-center align-middle px-2"><img
						src="${contextPath}/resources/img/케이스이미지.PNG"
						class="img-thumbnail" alt="#"></td>
					<td class="text-center align-middle px-2">hard</td>
					<td class="align-middle pl-3">
						<div class="row font-weight-bold pb-1">
							<a href="${contextPath }/HardCaseDetail.do" style="color: black">
								컬러칩 케이스</a>
						</div>
					</td>
					<td class="text-center align-middle px-2">12,000</td>
					<td class="text-center align-middle px-2" style="font-size: .8rem;">150</td>
					<td class="text-center align-middle px-2">
						<div class="bd-highlight">
							<a href="${contextPath }/orderList.do">
								<button type="button" class="btn btn-outline-secondary btn-sm"
									style="font-size: 0.7rem; width: 100%; display: block;">상세정보</button>
							</a>
						</div>
					</td>
				</tr> -->
				<c:forEach items="${list }" var="list">
					<tr id="${list.productId }" class="">
						<th class="text-center align-middle align-middle px-1">
							<div>
								<input type='checkbox' name='Choice' />
							</div>
						</th>
						<td class="text-center align-middle px-2"><img
							src="${contextPath}/resources/img/${list.p_group }/${list.imgURL }"
							class="img-thumbnail" alt="#"></td>
						<td class="text-center align-middle px-2">${list.p_group }</td>
						<td class="align-middle pl-3">
							<div class="row font-weight-bold pb-1">
								<a href="${contextPath }/HardCaseDetail.do" style="color: black">
									${list.productName }</a>
							</div>
						</td>
						<td class="text-center align-middle px-2"><fmt:formatNumber value="${list.price }" pattern="#,###" /></td>
						<td class="text-center align-middle px-2" style="font-size: .8rem;">${list.productMileage }</td>
						<td class="text-center align-middle px-2">
							<div class="bd-highlight">
								<a href="${contextPath }/orderList.do">
									<button type="button" class="btn btn-outline-secondary btn-sm"
										style="font-size: 0.7rem; width: 100%; display: block;">상세정보</button>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 검색 및 등록 버튼 영역 -->
		<div class="row justify-content-between px-3 mt-3">
			<div class="">
				<div class="btn-group">
					<form action="#">
						<div class="form-row">
							<div class="form-group d-flex justify-content-start ">
								<select id="inputState" class="form-control form-control-sm"
									style="width: 90px;">
									<option selected>상품명</option>
								</select> <input class="form-control form-control-sm mx-2" type="text"
									placeholder="">
								<button type="submit" class="btn btn-secondary btn-sm col-2">검색</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="">
				<a class="" href="${contextPath }/addProduct.do">
					<button type="button" class="btn btn-primary btn-sm">상품
						등록하기</button>
				</a>
			</div>
		</div>
		<nav aria-label="Page navigation example row">
			<!-- <ul class="pagination d-flex justify-content-center">
				<li class="page-item">
					<a class="page-link" href="#" aria-label="Previous"> 
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item">
					<a class="page-link" href="#" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul> -->
			
			<ul class="pagination d-flex justify-content-center">
				<c:if test="${pageMaker.prev }">
					<li class="page-item">
						<a class="page-link" href='<c:url value="/board/boardList?page=${pageMaker.startPage-1 }"/>' aria-label="Previous"> 
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				<!-- ${contextPath }/productListTest.do?page=${pageNum }"/> <c:url value="/productListTest.do?page=${pageNum }"/>-->
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
					<li class="page-item">
						<a class="page-link" href='${contextPath }/productListTest.do?page=${pageNum }'>${pageNum }</a>
					</li>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
					<li class="page-item">
						<a class="page-link" href='<c:url value="/board/boardList?page=${pageMaker.endPage+1 }"/>' aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>

		</nav>
	</div>
</main>