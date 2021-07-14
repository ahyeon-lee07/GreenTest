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

<!-- 메인 -->
<main class="mainH">
	<div class="container">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4>공지사항 상세</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item"><a
							href="${contextPath }/listNotice.do">공지사항 목록</a></li>
						<li class="breadcrumb-item active" aria-current="page">공지사항
							상세</li>
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
							<input type="text" value="${viewNotice.noticeTitle}"
								class="
								form-control" readonly>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputUser" class="bd-highlight col-form-label pl-2"
									style="width: 100px;">작성자</label>
								<div class="flex-grow-1 bd-highlight pr-2">
									<input type="text" value="${viewNotice.id}"
										class="
										form-control" readonly>

								</div>
							</div>
						</div>
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputDay" class="bd-highlight col-form-label pl-2"
									style="width: 100px;">작성일</label>
								<div class="flex-grow-1 bd-highlight pr-2">
									<input type="text" value="${viewNotice.noticeDate}"
										class="
										form-control" readonly>
								</div>
							</div>
						</div>

					</div>
					<div class="row border-bottom p-2">
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="14" readonly>${viewNotice.noticeContent}</textarea>
					</div>

				</form>
			</div>
		</div>

		<div class="row justify-content-between mb-5">
			<div class="">
				<a class="" href="${contextPath }/listNotice.do">
					<button type="button" class="btn btn-secondary btn-sm">목록</button>
				</a>
				<button type="button" class="btn btn-secondary btn-sm"
					onClick="fn_modify_article(frmArticle)">수정</button>
				<button type="button" class="btn btn-secondary btn-sm"
					onClick="fn_remove_article('${contextPath}/removeNotice.do', ${viewNotice.noticeNum})">삭제</button>
			</div>
		</div>

		<div class="row justify-content-between mb-5">
			<div class="">
				<c:if test="${member.id == notice.id }">
					<button type="button" class="btn btn-secondary btn-sm"
						onClick="fn_enable(this.form)">수정</button>
					<button type="button" class="btn btn-secondary btn-sm"
						onClick="fn_remove_article('${contextPath}/removeNotice.do', ${viewNotice.noticeNum})">삭제</button>
				</c:if>
				<button type="button" class="btn btn-secondary btn-sm"
					onClick="backToList(this.form)">목록</button>
				<button type="button" class="btn btn-secondary btn-sm"
					onClick="fn_reply_form('${contextPath}/replyForm.do', ${viewNotice.noticeNum})">답글쓰기</button>
			</div>
		</div>
	</div>
</main>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
     function backToList(obj){
	    obj.action="${contextPath}/listNotice.do";
	    obj.submit();
     }
 
	 function fn_enable(obj){
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 document.getElementById("i_imageFileName").disabled=false;
		 document.getElementById("tr_btn_modify").style.display="block";
		 document.getElementById("tr_file_upload").style.display="block";
		 document.getElementById("tr_btn").style.display="none";
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}	/modArticle.do";
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,noticeNum){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","text");
	     articleNOInput.setAttribute("name","noticeNum");
	     articleNOInput.setAttribute("value", noticeNum);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 
	 }
	 
	 function fn_reply_form(url, parentNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNOInput = document.createElement("input");
	     parentNOInput.setAttribute("type","hidden");
	     parentNOInput.setAttribute("name","parentNO");
	     parentNOInput.setAttribute("value", parentNO);
		 
	     form.appendChild(parentNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
 </script>