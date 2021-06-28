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
				<h4>관심상품 내역조회</h4>
			</div>
			<div class="bd-highlight">
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
                    일반 상품 (
                    <span>1</span>
                    )
                </div>
            </div>
    
            <table class="table table-hover m-0">
                <thead class=" border-bottom-0">
                    <tr>
                        <th class="text-center border-bottom-0 align-middle border-top-0 px-1" style="width: 28px">
                            <div style="height: 14px;">
                                <input type='checkbox' name='selectall' value='selectall' onclick='selectAll(this)'/>
                            </div>
                        </th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 120px">이미지</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: auto">상품 정보</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 76px">판매가</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 116px">수량</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 66px">적립금</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 90px">배송 구분</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 70px">배송비</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 80px">합계</th>
                        <th class="text-center border-bottom-0 border-top-0 px-2" style="width: 114px">선택</th>
                    </tr>
                </thead>
                <tbody class="border-bottom">
                    <tr class="">
                        <th class="text-center align-middle align-middle px-1">
                            <div style="height: 14px;">
                                <input type='checkbox' name='Choice' value='Choice1' onclick='checkSelectAll()'/>
                            </div>
                        </th>
                        <td class="text-center align-middle px-2"><img src="${contextPath}/resources/img/케이스이미지.PNG"
                                class="img-thumbnail" alt="#"></td>
                        <td class="align-middle pl-3">
                            <div class="row font-weight-bold pb-1">
                                컬러칩 케이스
                            </div>
                            <div class="row" style="font-size: .8rem;">
                                [옵션: 2. 옐로우/아이폰6(s)]
                            </div>
                        </td>
                        <td class="text-center align-middle px-2">12,000</td>
                        <td class="text-center align-middle px-2">
                            <div class="d-flex flex-column bd-highlight px-2">
                                <div class="bd-highlight d-flex">
                                <div class="flex-grow bd-highlight pr-2">
                                <input type="number" class="form-control" id="inputnumber" min="0" max="99">
                                </div>
                            	</div>
                                </div>
                                <div class="bd-highlight mt-1"><button type="button" class="btn btn-outline-secondary btn-sm" style="font-size: .6rem">변경</button></div>
                              </div>
                        </td>
                        <td class="text-center align-middle px-2" style="font-size: .8rem;">150</td>
                        <td class="text-center align-middle px-2">기본 배송</td>
                        <td class="text-center align-middle px-2">2,000원</td>
                        <td class="text-center align-middle px-2">13,000원</td>
                        <td class="text-center align-middle px-2 d-flex flex-column">
                            <div class="bd-highlight">
                            	<a href="${contextPath }/orderList.do">
                                <button type="button" class="btn btn-outline-success btn-sm" style="font-size: 0.7rem; width: 100%; display: block;">주문하기</button></a>
                            </div>
                            <br>
                            <br>
                            <div class="bd-highlight">
                            	<a href="${contextPath }/wist_list.do">
                                <button type="button" class="btn btn-outline-danger btn-sm" style="font-size: 0.7rem; width: 100%; display: block;">삭제</button></a>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
    
            <div class="row mt-4 mb-5">
                <div class="col">
                    <div class="d-flex bd-highlight align-items-center">
                        <div class="bd-highlight font-weight-bold mr-1 align-items-center">선택 상품을</div>
                        <div class="bd-highlight flex-grow-1">
                            <div class="d-flex justify-content-between bd-highlight">
                                <div class="bd-highlight d-flex flex-row">
                                        <div class="p-1 bd-highlight">
                                            <a href="${contextPath }/wist_list.do">
                                            <button type="button" class="btn btn-outline-danger">삭제하기</button></a>
                                        </div>
                                        <div class="p-1 bd-highlight">
                                        	<a href="${contextPath }/cart.do">
                                            <button type="button" class="btn btn-outline-secondary">장바구니 담기</button></a>
                                        </div>
                                </div>
                                <div class="bd-highlight d-flex flex-row">
                                    <div class="p-1 bd-highright">
                                        <button type="button" class="btn btn-outline-danger">관심상품 비우기</button>
                                    </div>
                                    <div class="p-1 bd-highright">
                                    	<a href="${contextPath }/orderList.do">
                                        <button type="button" class="btn btn-outline-success">전체 상품주문</button></a>
                                    </div>
                                </div>
                              </div>
                        </div>
                      </div>
                </div>
            </div>
    
            <nav aria-label="Page navigation example row">
                <ul class="pagination d-flex justify-content-center">
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
                </ul>
              </nav>
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
</script>