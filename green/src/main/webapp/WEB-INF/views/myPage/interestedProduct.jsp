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
<main class="mainH">

	<div class="container py-1">
		<!-- 페이지 타이틀 부분 -->
    <div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4 class="page_title">관심상품 내역조회</h4>
			</div>
			<div class="bd-highlight page_subtitle">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">관심상품 내역조회</li>
					</ol>
				</nav>
			</div>
		</div>

    <div class="row" style="padding: 0 15px">
        <div class="col bg-light border rounded p-2">
        	<c:choose>
        		<c:when test="${wishCount != '' }">
        			일반 상품 (<span>${wishCount }</span>)
        		</c:when>
        		<c:otherwise>
        			일반 상품 (<span>0</span>)
        		</c:otherwise>
        	</c:choose>
        </div>
    </div>
    <table class="table table-hover m-0 mt-2">
			<thead class=" border-bottom border-top bg-light">
				<tr>
          			<th class="text-center border-bottom-0 align-middle border-top-0 px-1" style="width: 40px">
						<div>
							<input type='checkbox' name='selectall' value='selectall' onclick='selectAll(this)' />
						</div>
					</th>
					<th class="text-center border-bottom-0 border-top-0 px-2" style="width: 140px">이미지</th>
					<th class="text-center border-bottom-0 border-top-0 px-2" style="width: auto">상태정보</th>
					<th class="text-center border-bottom-0 border-top-0 px-2" style="width: 85px">판매가</th>
					<th class="text-center border-bottom-0 border-top-0 px-2" style="width: 90px">상세정보</th>
				</tr>
			</thead>
			<tbody class="border-bottom">
				<c:forEach items="${wishList }" var="wishList">
					<tr id="${wishList.productId }" class="wishList">
			          <th class="text-center align-middle align-middle px-1">
			            <div style="height: 14px;">
			                <input type='checkbox' name='Choice' value='Choice1' onclick='checkSelectAll()'/>
			            </div>
			          </th>
			          <td class="text-center align-middle px-2">
			            <img src="${contextPath}/resources/img/${wishList.p_group }/${wishList.imgURL }" class="img-thumbnail" alt="#">
			          </td>
			          <td class="align-middle align-middle px-2 ">
							<div class="font-weight-bold pb-1 bd-highlight"> ${wishList.productName }</div> 
							<!-- 상품 옵션 --> 
							<c:forEach items="${optionList }" var="optionList1">
								<c:forEach items="${optionList1 }" var="optionList" varStatus="Num">
									<c:if test="${wishList.productId eq optionList.productId}">
										<div class="bd-highlight">
											${Num.count}. ${optionList.p_option }
										</div>
									</c:if>
								</c:forEach>
							</c:forEach>
						</td>
						
						<!-- 판매가 discountYN 여부에 따라 할인 가격 표시  -->
						<td class="text-center align-middle px-2">
							<c:choose>
								<c:when test="${wishList.discountYN =='Y'}">
									<div class="discountBox">
										<fmt:formatNumber value="${wishList.price }" pattern="#,###" />
										<span class="discountBox text-danger"> <fmt:formatNumber
												value="${wishList.discount }" pattern="#,###" />
										</span>
									</div>
								</c:when>
								<c:otherwise>
									<fmt:formatNumber value="${wishList.price }" pattern="#,###" />
								</c:otherwise>
							</c:choose>
						</td>
						<td class="text-center align-middle px-2">
							<div class="bd-highlight">
								<a
									href="${contextPath }/prodList/prodDetail.do?productId=${wishList.productId }">
									<button type="button" class="btn btn-outline-secondary btn-sm"
										style="font-size: 0.7rem; width: 100%; display: block;">상세정보</button>
								</a>
							</div>
						</td>
			        </tr>
				
				</c:forEach>
				
			</tbody>
		</table>
    
    <div class="row mt-4 mb-5">
      <div class="col-12">
        <div class="d-flex justify-content-start">
          <div class="bd-highlight mr-2">
            <button type="button" class="btn btn-sm btn-outline-danger" onclick="chan()">삭제하기</button></a>
          </div>
          <div class="bd-highlight">
            <button type="button" class="btn btn-sm btn-outline-danger">관심상품 비우기</button>
          </div>
        </div>
      </div>
    </div>
	</div>
</main>

<!-- 전체 선택  -->
<script>
function checkSelectAll()  {
	  // 전체 체크박스
	  const checkboxes 
	    = document.querySelectorAll('input[name="Choice"]');
	  // 선택된 체크박스
	  const checked 
	    = document.querySelectorAll('input[name="Choice"]:checked');
	  // select all 체크박스
	  const selectAll 
	    = document.querySelector('input[name="selectall"]');
	  
	  if(checkboxes.length === checked.length)  {
	    selectAll.checked = true;
	  }else {
	    selectAll.checked = false;
	  }

	}

	function selectAll(selectAll)  {
	  const checkboxes 
	     = document.getElementsByName('Choice');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
	}

	function chan(){
		var wishList = document.getElementsByClassName('wishList');
		var id = document.getElementsByClassName('wishList')[0].id;
		var checkYN = document.getElementsByClassName('wishList')[0].childNodes[1].childNodes[1].childNodes[1].checked;
		console.log(wishList);
	}
</script>