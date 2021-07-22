<!--규찬9 상진1-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="article" value="${articleMap.article}" />

<head>
	<meta charset="UTF-8">
	<style>
	#tr_btn_modify {
		display:none;
	}
	</style>
</head>

<!-- 메인 -->
<main class="mainH">
	<div class="container">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4>이벤트 게시판 상세</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath}/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">이벤트 게시판 상세</li>
					</ol>
				</nav>
			</div>
		</div>
		
		<div class="row mb-4">
            <div class="col-12">
                <form action="#">
                    <div class="row border-bottom border-top d-flex bd-highlight py-2">
                        <label for="inputTitle" class="bd-highlight col-form-label pl-2"
                            style="width: 100px;">제목</label>
                        <div class="flex-grow-1 bd-highlight pr-2">
                            <input type="text" name="eventTitle" value="${article.eventTitle}"
                                id="eventTitle" class="
                                form-control" readonly>
                        </div>
                    </div>
                    <div class="row border-bottom py-2">
                        <div class="col p-0">
                            <div class="d-flex bd-highlight">
                                <label for="inputUser" class="bd-highlight col-form-label pl-2"
                                    style="width: 100px;">작성자</label>
                                <div class="flex-grow-1 bd-highlight pr-2">
                                    <input type="text" name="id" value="${article.id}"
                                        id="id" class="
                                        form-control" readonly>

                                </div>
                            </div>
                        </div>
                        <div class="col p-0">
                            <div class="d-flex bd-highlight">
                                <label for="inputDay" class="bd-highlight col-form-label pl-2"
                                    style="width: 100px;">작성일</label>
                                <div class="flex-grow-1 bd-highlight pr-2">
                                    <input type="text" name="eventDate" value="${article.eventDate}"
                                        id="eventDate" class="
                                        form-control" readonly>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row border-bottom p-2">
                        <textarea class="form-control" name="eventContent" id="eventContent"
                            rows="14" readonly>${article.eventContent}</textarea>
                    </div>
                </form>
            </div>
        </div>
        <div class="row justify-content-between mb-5">
            <div class="">
            	<a class="" href="${contextPath}/eventList.do">
            		<input type="button" class="btn btn-secondary btn-sm" value="목록" onClick="backToList(this.form)">
            	</a>
            </div>
            <div>
            <tr id="tr_btn_modify" align="center">
            <td colspan="2">
            	<input type=button class="btn btn-sm btn-outline-success" value="수정" onClick="fn_modify_event(frmEvent)">
            	<input type=button class="btn btn-sm btn-outline-danger" value="취소" onClick="backToList(frmEvent)">
            </td>
            </tr>
            <tr id="tr_btn">
			<td colspan="2" align="center">
				<c:if test="${member.id == article.id}">
					<input type=button class="btn btn-sm btn-outline-success" value="수정" onClick="fn_enable(this.form)">
					<input type=button class="btn btn-sm btn-outline-danger" value="삭제" 
					onClick="fn_remove_event('${contextPath}/removeEvent.do', ${article.eventNum})">
				</c:if>
			</td>
			</tr>
            </div>
        </div>
	</div>
</main>

<!-- 버튼 기능 -->
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script type = "text/javascript">
	function backToList(obj) {
		obj.action = "${contextPath}/eventList.do";
		obj.submit();
	}
	
	function fn_enable(obj) {
		document.getElementById("eventTitle").disabled=false;
		document.getElementById("eventContent").disabled=false;
		document.getElementById("tr_btn_modify").style.display="block";
		document.getElementById("tr_btn").style.display="none";
	}
	
	function fn_modify_event(obj) {
		obj.action="${contextPath}/modEvent.do?eventNum=${eventList.eventNum}";
		obj.submit();
	}
	
	function fn_remove_event(url, eventNum) {
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		var eventNumInput = document.createElement("input");
		eventNumInput.setAttribute("type", "hidden");
		eventNumInput.setAttribute("name", "eventNum");
		eventNumInput.setAttribute("value", eventNum);
		
		form.appendChild(eventNumInput);
		document.body.appendChild(form);
		form.submit();
	}
</script>