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
				<h4>주문서 작성</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">주문서 작성</li>
					</ol>
				</nav>
			</div>
		</div>

		<!-- 국내 배송상품 주문내역 -->
        <div class="row my-4" style="padding: 0 15px">
            <div class="col">
                <div class="row">
                    <div class="col-2 border bg-light text-center">
                        <div class="col" style="top: 40%;">혜택정보</div>
                    </div>
                    <div class="col-10 border border-left-0">
                        <div class="row text-center p-2 border-bottom">
                            <div class="col">000님은, [00회원]이십니다</div>
                        </div>
                        <div class="row text-center font-weight-bold p-2">
                            <div class="col">
                                가용 적립금 : (숫자)원 &nbsp; &nbsp; 쿠폰 : (숫자)개
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 국내 배송상품 주문내역 -->
        <table class="table table-hover border-top m-0">
            <div class="bd-highlight my-3">
                <h6 class="font-weight-bold">국내 배송상품 주문내역</h6>
            </div>
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
                </tr>
            </thead>
            <tbody>
                <tr class="">
                    <th class="text-center align-middle align-middle px-1">
                        <div style="height: 14px;">
                            <input type='checkbox' name='Choice' value='Choice1' onclick='checkSelectAll()'/>
                        </div>
                    </th>
                    <td class="text-center align-middle px-2"><img src="${contextPath }/resources/img/img.webp"
                            class="img-thumbnail" alt="#"></td>
                    <td class="align-middle pl-3">
                        <div class="row font-weight-bold pb-1">
                        <a href="${contextPath }/HardCaseDetail.do" style="color: black">
                            컬러칩 케이스</a>
                        </div>
                        <div class="row" style="font-size: .8rem;">
                            [옵션: 2. 옐로우/아이폰6(s)]
                        </div>
                    </td>
                    <td class="text-center align-middle px-2">12,000</td>
                    <td class="text-center align-middle px-2">
                        <div class="d-flex flex-column bd-highlight px-2">
                            <div class="bd-highlight d-flex">
                                <div class="flex-grow bd-highlight pr-3">
                                <input type="number" class="form-control" id="inputnumber" step="1" value="1" min="1" max="99">
                                </div>
                                </div>
                            </div>
                            <div class="bd-highlight mt-1"><button type="button"
                                    class="btn btn-outline-secondary btn-sm" style="font-size: .6rem">변경</button>
                            </div>
                        </div>
                    </td>
                    <td class="text-center align-middle px-2" style="font-size: .8rem;">150</td>
                    <td class="text-center align-middle px-2">기본 배송</td>
                    <td class="text-center align-middle px-2">2,000원</td>
                    <td class="text-center align-middle px-2">11,000원</td>
                </tr>
            </tbody>
        </table>

        <div class="row" style="padding: 0 15px">
            <div class="col bg-light border rounded p-2">
                <div class="d-flex justify-content-between">
                    <div class="bd-highlight">[기본 배송]</div>
                    <div class="bd-highlight">
                        상품 구매금액(<span>12,000</span>)+배송비(<span>2,000</span>)-상품 할인금액(<span>3,000</span>)=합계:(<span>11,000</span>)원
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-4 mb-5">
            <div class="col">
                <div class="d-flex bd-highlight align-items-center">
                    <div class="bd-highlight font-weight-bold mr-1 align-items-center">선택 상품을</div>
                    <div class="bd-highlight flex-grow-1">
                        <div class="d-flex justify-content-between bd-highlight">
                            <div class="bd-highlight d-flex flex-row">
                                <div class="p-1 bd-highlight">
                                	<a href="${contextPath }/orderList.do">
                                    <button type="button" class="btn btn-outline-danger">삭제하기</button></a>
                                </div>
                            </div>
                            <div class="bd-highlight d-flex flex-row">
                                <div class="p-1 bd-highright">
                                    <button type="button" class="btn btn-outline-secondary">이전 페이지</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 배송주문 -->
        <div class="d-flex justify-content-between mb-2">
            <div class="bd-highlight">
                <h6 class="font-weight-bold">배송 정보</h6>
            </div>
            <div class="bd-highlight">
            	<img src="${contextPath }/resources/img/require.png">
                <span class="">필수입력사항 </span>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-12">
                <form action="#">
                    <div class="row border-bottom border-top d-flex bd-highlight py-2">
                        <label for="inputTitle" class="bd-highlight col-form-label pl-2" style="width: 100px;">배송지
                            선택</label>
                        <div class="flex-grow-1 bd-highlight p-2 ml-1">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                    id="inlineRadio1" value="option1">
                                <label class="form-check-label" for="inlineRadio1">회원정보와 동일</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                    id="inlineRadio2" value="option2">
                                <label class="form-check-label" for="inlineRadio2">새로운 배송지</label>
                            </div>
                            <button type="button" class="btn btn-secondary btn-sm" style="font-size: .6rem">주소록
                                보기</button>
                        </div>
                    </div>

                    <div class="row border-bottom py-2">
                        <div class="col p-0">
                            <div class="d-flex bd-highlight">
                                <label for="inputUser" class="bd-highlight col-form-label pl-2"
                                    style="width: 120px;"><img src="${contextPath }/resources/img/require.png">받으시는 분</label>
                                <div class="flex-grow bd-highlight pr-2">
                                    <input type="email" class="form-control" id="inputUser">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputUser" class="bd-highlight col-form-label pl-2"
									style="width: 120px;"><img src="${contextPath }/resources/img/require.png">주소</label>
								<div class="flex-grow-1 bd-highlight flex-column pr-2">
									<div class="bd-highlight mb-2">
										<div class="d-flex flex-row bd-highlight">
											<div class="bd-highlight">
												<input type="text" class="form-control"
													id="sample6_postcode" placeholder="우편번호" readonly>
											</div>
											<div class="bd-highlight ml-2">

												<button type="button" onclick="sample6_execDaumPostcode()"
													class="btn btn-secondary btn-sm" style="font-size: .8rem">
													우편번호 찾기</button>
											</div>
										</div>
									</div>
									<div class="bd-highlight mb-2">
										<div class="d-flex flex-row bd-highlight">
											<div class="bd-highlight">
												<input type="text" class="form-control" id="sample6_address"
													placeholder="주소" style="width: 300px;" readonly>
											</div>
										</div>
									</div>

									<div class="bd-highlight mb-2">
										<div class="d-flex bd-highlight">
											<div class="d-flex flex-row">
												<input type="text" class="form-control"
													id="sample6_detailAddress" placeholder="상세주소">
												<div class="p-2"></div>
												<input type="text" class="form-control"
													id="sample6_extraAddress" placeholder="참고항목" readonly>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

                    <div class="row border-bottom py-2">
                        <div class="col p-0">
                            <div class="d-flex bd-highlight">
                                <label for="inputUser" class="bd-highlight col-form-label pl-2"
                                    style="width: 120px;"><img src="${contextPath }/resources/img/require.png">휴대전화</label>
                                <div class="flex-grow bd-highlight pr-2">
                                    <input type="email" class="form-control" id="inputUser" placeholder="'-' 없이 입력해주세요.">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row border-bottom py-2">
                        <div class="col p-0">
                            <div class="d-flex bd-highlight">
                                <label for="inputUser" class="bd-highlight col-form-label pl-2"
                                    style="width: 120px;">이메일</label>
                                <div class="flex-grow-1 bd-highlight flex-column pr-2">
                                    <div class="flex-grow-1 bd-highlight pr-2">
                                        <div class="d-flex flex-row">
                                            <input type="email" class="form-control" id="inputEmail"
                                                style="width: 150px;">
                                            <div class="p-2">
                                                @
                                            </div>
                                            <select id="inputState" class="form-control" style="width: 140px;">
                                                <option value="none" selected>선택</option>
												<option value="네이버">naver.com</option>
												<option value="다음">hanmail.net</option>
												<option value="네이트">nate.com</option>
												<option value="구글">gmail.com</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="bd-highlight mb-1">
                                        이메일을 통해 주문처리과정을 보내드립니다.
                                    </div>
                                    <div class="bd-highlight">
                                        이메일 주소란에는 반드시 수신가능한 이메일주소를 입력해주세요.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row border-bottom py-2">
                        <div class="col p-0">
                            <div class="d-flex bd-highlight">
                                <label for="inputUser" class="bd-highlight col-form-label pl-2"
                                    style="width: 120px;">배송 메시지</label>
                                <div class="flex-grow bd-highlight pr-2" style="width: 86%;">
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                                        placeholder="20자 이내로 입력해주세요."></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 약관 동의 리스트 -->
                    <div class="row">
                        <div class="d-flex flex-fill flex-column mt-3 mb-2 border rounded">
                            <div class="bd-highlight p-2 pl-3 bg-light border-bottom">
                                <div class="form-check">
                                    <input type='checkbox'
       										name='selectall' 
       										value='selectall'
       										onclick='selectAll(this)'/> 
       										<b>모두 동의</b>
                                    <label class="form-check-label pl-2" for="defaultCheck1">
                                        쇼핑몰 이용약관, 비회원 구매시 개인정보수집이용 동의에 모두 동의합니다.
                                    </label>
                                </div>
                            </div>
                            <div class="p-2 bd-highlight d-flex flex-row py-3" style="font-size: .8rem;">
                                <div class="bd-highlight font-weight-bold mr-2" style="width: 106px;">쇼핑몰 이용약관</div>
                                <div class="bd-highlight flex-grow-1 flex-column">
                                    <div class="bd-highlight">
                                        <div class="flex-grow bd-highlight" style="width: 100%;">
                                            <textarea class="form-control text-black-50"
                                                id="exampleFormControlTextarea1" rows="3" style="font-size: .8rem;" disabled>제1조(목적)이 약관은 OO 회사(전자상거래 사업자)가 운영하는 OO 사이버 몰(이하 “몰”이라 한다)에서 제공하는 인터넷 관련 서비스(이하 “서비스”라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리?의무 및 책임사항을 규정함을 목적으로 합니다.※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는 한 이 약관을 준용합니다.」제2조(정의)① “몰”이란 OO 회사가 재화 또는 용역(이하 “재화 등”이라 함)을 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는 사업자의 의미로도 사용합니다.② “이용자”란 “몰”에 접속하여 이 약관에 따라 “몰”이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.③ ‘회원’이라 함은 “몰”에 회원등록을 한 자로서, 계속적으로 “몰”이 제공하는 서비스를 이용할 수 있는 자를 말합니다.④ ‘비회원’이라 함은 회원에 가입하지 않고 “몰”이 제공하는 서비스를 이용하는 자를 말합니다.제3조 (약관 등의 명시와 설명 및 개정) ① “몰”은 이 약관의 내용과 상호 및 대표자 성명, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함), 전화번호?모사전송번호?전자우편주소, 사업자등록번호, 통신판매업 신고번호, 개인정보보호책임자등을 이용자가 쉽게 알 수 있도록 00 사이버몰의 초기 서비스화면(전면)에 게시합니다. 다만, 약관의 내용은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다.② “몰은 이용자가 약관에 동의하기에 앞서 약관에 정하여져 있는 내용 중 청약철회?배송책임?환불조건 등과 같은 중요한 내용을 이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을 제공하여 이용자의 확인을 구하여야 합니다.③ “몰”은 「전자상거래 등에서의 소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」, 「전자문서 및 전자거래기본법」, 「전자금융거래법」, 「전자서명법」, 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」, 「방문판매 등에 관한 법률」, 「소비자기본법」 등 관련 법을 위배하지 않는 범위에서 이 약관을 개정할 수 있습니다.④ “몰”이 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 몰의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자에게 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 “몰“은 개정 전 내용과 개정 후 내용을 명확하게 비교하여 이용자가 알기 쉽도록 표시합니다. ⑤ “몰”이 약관을 개정할 경우에는 그 개정약관은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에 이미 체결된 계약에 대해서는 개정 전의 약관조항이 그대로 적용됩니다. 다만 이미 계약을 체결한 이용자가 개정약관 조항의 적용을 받기를 원하는 뜻을 제3항에 의한 개정약관의 공지기간 내에 “몰”에 송신하여 “몰”의 동의를 받은 경우에는 개정약관 조항이 적용됩니다.⑥ 이 약관에서 정하지 아니한 사항과 이 약관의 해석에 관하여는 전자상거래 등에서의 소비자보호에 관한 법률, 약관의 규제 등에 관한 법률, 공정거래위원회가 정하는 전자상거래 등에서의 소비자 보호지침 및 관계법령 또는 상관례에 따릅니다.제4조(서비스의 제공 및 변경) ① “몰”은 다음과 같은 업무를 수행합니다.  1. 재화 또는 용역에 대한 정보 제공 및 구매계약의 체결  2. 구매계약이 체결된 재화 또는 용역의 배송  3. 기타 “몰”이 정하는 업무② “몰”은 재화 또는 용역의 품절 또는 기술적 사양의 변경 등의 경우에는 장차 체결되는 계약에 의해 제공할 재화 또는 용역의 내용을 변경할 수 있습니다. 이 경우에는 변경된 재화 또는 용역의 내용 및 제공일자를 명시하여 현재의 재화 또는 용역의 내용을 게시한 곳에 즉시 공지합니다.③ “몰”이 제공하기로 이용자와 계약을 체결한 서비스의 내용을 재화등의 품절 또는 기술적 사양의 변경 등의 사유로 변경할 경우에는 그 사유를 이용자에게 통지 가능한 주소로 즉시 통지합니다.④ 전항의 경우 “몰”은 이로 인하여 이용자가 입은 손해를 배상합니다. 다만, “몰”이 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다.제5조(서비스의 중단) ① “몰”은 컴퓨터 등 정보통신설비의 보수점검?교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로 중단할 수 있습니다.② “몰”은 제1항의 사유로 서비스의 제공이 일시적으로 중단됨으로 인하여 이용자 또는 제3자가 입은 손해에 대하여 배상합니다. 단, “몰”이 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다.③ 사업종목의 전환, 사업의 포기, 업체 간의 통합 등의 이유로 서비스를 제공할 수 없게 되는 경우에는 “몰”은 제8조에 정한 방법으로 이용자에게 통지하고 당초 “몰”에서 제시한 조건에 따라 소비자에게 보상합니다. 다만, “몰”이 보상기준 등을 고지하지 아니한 경우에는 이용자들의 마일리지 또는 적립금 등을 “몰”에서 통용되는 통화가치에 상응하는 현물 또는 현금으로 이용자에게 지급합니다.제6조(회원가입) ① 이용자는 “몰”이 정한 가입 양식에 따라 회원정보를 기입한 후 이 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다.② “몰”은 제1항과 같이 회원으로 가입할 것을 신청한 이용자 중 다음 각 호에 해당하지 않는 한 회원으로 등록합니다.  1. 가입신청자가 이 약관 제7조제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우, 다만 제7조제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 “몰”의 회원재가입 승낙을 얻은 경우에는 예외로 한다.  2. 등록 내용에 허위, 기재누락, 오기가 있는 경우  3. 기타 회원으로 등록하는 것이 “몰”의 기술상 현저히 지장이 있다고 판단되는 경우③ 회원가입계약의 성립 시기는 “몰”의 승낙이 회원에게 도달한 시점으로 합니다.④ 회원은 회원가입 시 등록한 사항에 변경이 있는 경우, 상당한 기간 이내에 “몰”에 대하여 회원정보 수정 등의 방법으로 그 변경사항을 알려야 합니다.제7조(회원 탈퇴 및 자격 상실 등) ① 회원은 “몰”에 언제든지 탈퇴를 요청할 수 있으며 “몰”은 즉시 회원탈퇴를 처리합니다.② 회원이 다음 각 호의 사유에 해당하는 경우, “몰”은 회원자격을 제한 및 정지시킬 수 있습니다.  1. 가입 신청 시에 허위 내용을 등록한 경우  2. “몰”을 이용하여 구입한 재화 등의 대금, 기타 “몰”이용에 관련하여 회원이 부담하는 채무를 기일에 지급하지 않는 경우  3. 다른 사람의 “몰” 이용을 방해하거나 그 정보를 도용하는 등 전자상거래 질서를 위협하는 경우  4. “몰”을 이용하여 법령 또는 이 약관이 금지하거나 공서양속에 반하는 행위를 하는 경우③ “몰”이 회원 자격을 제한?정지 시킨 후, 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는 경우 “몰”은 회원자격을 상실시킬 수 있습니다.④ “몰”이 회원자격을 상실시키는 경우에는 회원등록을 말소합니다. 이 경우 회원에게 이를 통지하고, 회원등록 말소 전에 최소한 30일 이상의 기간을 정하여 소명할 기회를 부여합니다.제8조(회원에 대한 통지)① “몰”이 회원에 대한 통지를 하는 경우, 회원이 “몰”과 미리 약정하여 지정한 전자우편 주소로 할 수 있습니다.② “몰”은 불특정다수 회원에 대한 통지의 경우 1주일이상 “몰” 게시판에 게시함으로서 개별 통지에 갈음할 수 있습니다. 다만, 회원 본인의 거래와 관련하여 중대한 영향을 미치는 사항에 대하여는 개별통지를 합니다.제9조(구매신청) ① “몰”이용자는 “몰”상에서 다음 또는 이와 유사한 방법에 의하여 구매를 신청하며, “몰”은 이용자가 구매신청을 함에 있어서 다음의 각 내용을 알기 쉽게 제공하여야 합니다.  1. 재화 등의 검색 및 선택  2. 받는 사람의 성명, 주소, 전화번호, 전자우편주소(또는 이동전화번호) 등의 입력  3. 약관내용, 청약철회권이 제한되는 서비스, 배송료?설치비 등의 비용부담과 관련한 내용에 대한 확인  4. 이 약관에 동의하고 위 3.호의 사항을 확인하거나 거부하는 표시(예, 마우스 클릭)  5. 재화등의 구매신청 및 이에 관한 확인 또는 “몰”의 확인에 대한 동의  6. 결제방법의 선택② “몰”이 제3자에게 구매자 개인정보를 제공?위탁할 필요가 있는 경우 실제 구매신청 시 구매자의 동의를 받아야 하며, 회원가입 시 미리 포괄적으로 동의를 받지 않습니다. 이 때 “몰”은 제공되는 개인정보 항목, 제공받는 자, 제공받는 자의 개인정보 이용 목적 및 보유?이용 기간 등을 구매자에게 명시하여야 합니다. 다만 「정보통신망이용촉진 및 정보보호 등에 관한 법률」 제25조 제1항에 의한 개인정보 처리위탁의 경우 등 관련 법령에 달리 정함이 있는 경우에는 그에 따릅니다.제10조 (계약의 성립)① “몰”은 제9조와 같은 구매신청에 대하여 다음 각 호에 해당하면 승낙하지 않을 수 있습니다. 다만, 미성년자와 계약을 체결하는 경우에는 법정대리인의 동의를 얻지 못하면 미성년자 본인 또는 법정대리인이 계약을 취소할 수 있다는 내용을 고지하여야 합니다.  1. 신청 내용에 허위, 기재누락, 오기가 있는 경우  2. 미성년자가 담배, 주류 등 청소년보호법에서 금지하는 재화 및 용역을 구매하는 경우  3. 기타 구매신청에 승낙하는 것이 “몰” 기술상 현저히 지장이 있다고 판단하는 경우② “몰”의 승낙이 제12조제1항의 수신확인통지형태로 이용자에게 도달한 시점에 계약이 성립한 것으로 봅니다.③ “몰”의 승낙의 의사표시에는 이용자의 구매 신청에 대한 확인 및 판매가능 여부, 구매신청의 정정 취소 등에 관한 정보 등을 포함하여야 합니다.제11조(지급방법)“몰”에서 구매한 재화 또는 용역에 대한 대금지급방법은 다음 각 호의 방법중 가용한 방법으로 할 수 있습니다. 단, “몰”은 이용자의 지급방법에 대하여 재화 등의 대금에 어떠한 명목의 수수료도 추가하여 징수할 수 없습니다.1. 폰뱅킹, 인터넷뱅킹, 메일 뱅킹 등의 각종 계좌이체 2. 선불카드, 직불카드, 신용카드 등의 각종 카드 결제3. 온라인무통장입금4. 전자화폐에 의한 결제5. 수령 시 대금지급6. 마일리지 등 “몰”이 지급한 포인트에 의한 결제7. “몰”과 계약을 맺었거나 “몰”이 인정한 상품권에 의한 결제 8. 기타 전자적 지급 방법에 의한 대금 지급 등제12조(수신확인통지?구매신청 변경 및 취소)① “몰”은 이용자의 구매신청이 있는 경우 이용자에게 수신확인통지를 합니다.② 수신확인통지를 받은 이용자는 의사표시의 불일치 등이 있는 경우에는 수신확인통지를 받은 후 즉시 구매신청 변경 및 취소를 요청할 수 있고 “몰”은 배송 전에 이용자의 요청이 있는 경우에는 지체 없이 그 요청에 따라 처리하여야 합니다. 다만 이미 대금을 지불한 경우에는 제15조의 청약철회 등에 관한 규정에 따릅니다.제13조(재화 등의 공급)① “몰”은 이용자와 재화 등의 공급시기에 관하여 별도의 약정이 없는 이상, 이용자가 청약을 한 날부터 7일 이내에 재화 등을 배송할 수 있도록 주문제작, 포장 등 기타의 필요한 조치를 취합니다. 다만, “몰”이 이미 재화 등의 대금의 전부 또는 일부를 받은 경우에는 대금의 전부 또는 일부를 받은 날부터 3영업일 이내에 조치를 취합니다. 이때 “몰”은 이용자가 재화 등의 공급 절차 및 진행 사항을 확인할 수 있도록 적절한 조치를 합니다.② “몰”은 이용자가 구매한 재화에 대해 배송수단, 수단별 배송비용 부담자, 수단별 배송기간 등을 명시합니다. 만약 “몰”이 약정 배송기간을 초과한 경우에는 그로 인한 이용자의 손해를 배상하여야 합니다. 다만 “몰”이 고의?과실이 없음을 입증한 경우에는 그러하지 아니합니다.제14조(환급)“몰”은 이용자가 구매신청한 재화 등이 품절 등의 사유로 인도 또는 제공을 할 수 없을 때에는 지체 없이 그 사유를 이용자에게 통지하고 사전에 재화 등의 대금을 받은 경우에는 대금을 받은 날부터 3영업일 이내에 환급하거나 환급에 필요한 조치를 취합니다.제15조(청약철회 등)① “몰”과 재화등의 구매에 관한 계약을 체결한 이용자는 「전자상거래 등에서의 소비자보호에 관한 법률」 제13조 제2항에 따른 계약내용에 관한 서면을 받은 날(그 서면을 받은 때보다 재화 등의 공급이 늦게 이루어진 경우에는 재화 등을 공급받거나 재화 등의 공급이 시작된 날을 말합니다)부터 7일 이내에는 청약의 철회를 할 수 있습니다. 다만, 청약철회에 관하여 「전자상거래 등에서의 소비자보호에 관한 법률」에 달리 정함이 있는 경우에는 동 법 규정에 따릅니다. ② 이용자는 재화 등을 배송 받은 경우 다음 각 호의 1에 해당하는 경우에는 반품 및 교환을 할 수 없습니다.  1. 이용자에게 책임 있는 사유로 재화 등이 멸실 또는 훼손된 경우(다만, 재화 등의 내용을 확인하기 위하여 포장 등을 훼손한 경우에는 청약철회를 할 수 있습니다)  2. 이용자의 사용 또는 일부 소비에 의하여 재화 등의 가치가 현저히 감소한 경우  3. 시간의 경과에 의하여 재판매가 곤란할 정도로 재화등의 가치가 현저히 감소한 경우  4. 같은 성능을 지닌 재화 등으로 복제가 가능한 경우 그 원본인 재화 등의 포장을 훼손한 경우③ 제2항제2호 내지 제4호의 경우에 “몰”이 사전에 청약철회 등이 제한되는 사실을 소비자가 쉽게 알 수 있는 곳에 명기하거나 시용상품을 제공하는 등의 조치를 하지 않았다면 이용자의 청약철회 등이 제한되지 않습니다.④ 이용자는 제1항 및 제2항의 규정에 불구하고 재화 등의 내용이 표시?광고 내용과 다르거나 계약내용과 다르게 이행된 때에는 당해 재화 등을 공급받은 날부터 3월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약철회 등을 할 수 있습니다.제16조(청약철회 등의 효과)① “몰”은 이용자로부터 재화 등을 반환받은 경우 3영업일 이내에 이미 지급받은 재화 등의 대금을 환급합니다. 이 경우 “몰”이 이용자에게 재화등의 환급을 지연한때에는 그 지연기간에 대하여 「전자상거래 등에서의 소비자보호에 관한 법률 시행령」제21조의2에서 정하는 지연이자율(괄호 부분 삭제)을 곱하여 산정한 지연이자를 지급합니다.② “몰”은 위 대금을 환급함에 있어서 이용자가 신용카드 또는 전자화폐 등의 결제수단으로 재화 등의 대금을 지급한 때에는 지체 없이 당해 결제수단을 제공한 사업자로 하여금 재화 등의 대금의 청구를 정지 또는 취소하도록 요청합니다.③ 청약철회 등의 경우 공급받은 재화 등의 반환에 필요한 비용은 이용자가 부담합니다. “몰”은 이용자에게 청약철회 등을 이유로 위약금 또는 손해배상을 청구하지 않습니다. 다만 재화 등의 내용이 표시?광고 내용과 다르거나 계약내용과 다르게 이행되어 청약철회 등을 하는 경우 재화 등의 반환에 필요한 비용은 “몰”이 부담합니다.④ 이용자가 재화 등을 제공받을 때 발송비를 부담한 경우에 “몰”은 청약철회 시 그 비용을 누가 부담하는지를 이용자가 알기 쉽도록 명확하게 표시합니다.제17조(개인정보보호)① “몰”은 이용자의 개인정보 수집시 서비스제공을 위하여 필요한 범위에서 최소한의 개인정보를 수집합니다. ② “몰”은 회원가입시 구매계약이행에 필요한 정보를 미리 수집하지 않습니다. 다만, 관련 법령상 의무이행을 위하여 구매계약 이전에 본인확인이 필요한 경우로서 최소한의 특정 개인정보를 수집하는 경우에는 그러하지 아니합니다.③ “몰”은 이용자의 개인정보를 수집?이용하는 때에는 당해 이용자에게 그 목적을 고지하고 동의를 받습니다. ④ “몰”은 수집된 개인정보를 목적외의 용도로 이용할 수 없으며, 새로운 이용목적이 발생한 경우 또는 제3자에게 제공하는 경우에는 이용?제공단계에서 당해 이용자에게 그 목적을 고지하고 동의를 받습니다. 다만, 관련 법령에 달리 정함이 있는 경우에는 예외로 합니다.⑤ “몰”이 제2항과 제3항에 의해 이용자의 동의를 받아야 하는 경우에는 개인정보보호 책임자의 신원(소속, 성명 및 전화번호, 기타 연락처), 정보의 수집목적 및 이용목적, 제3자에 대한 정보제공 관련사항(제공받은자, 제공목적 및 제공할 정보의 내용) 등 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」 제22조제2항이 규정한 사항을 미리 명시하거나 고지해야 하며 이용자는 언제든지 이 동의를 철회할 수 있습니다.⑥ 이용자는 언제든지 “몰”이 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 요구할 수 있으며 “몰”은 이에 대해 지체 없이 필요한 조치를 취할 의무를 집니다. 이용자가 오류의 정정을 요구한 경우에는 “몰”은 그 오류를 정정할 때까지 당해 개인정보를 이용하지 않습니다.⑦ “몰”은 개인정보 보호를 위하여 이용자의 개인정보를 처리하는 자를 최소한으로 제한하여야 하며 신용카드, 은행계좌 등을 포함한 이용자의 개인정보의 분실, 도난, 유출, 동의 없는 제3자 제공, 변조 등으로 인한 이용자의 손해에 대하여 모든 책임을 집니다.⑧ “몰” 또는 그로부터 개인정보를 제공받은 제3자는 개인정보의 수집목적 또는 제공받은 목적을 달성한 때에는 당해 개인정보를 지체 없이 파기합니다.⑨ “몰”은 개인정보의 수집?이용?제공에 관한 동의란을 미리 선택한 것으로 설정해두지 않습니다. 또한 개인정보의 수집?이용?제공에 관한 이용자의 동의거절시 제한되는 서비스를 구체적으로 명시하고, 필수수집항목이 아닌 개인정보의 수집?이용?제공에 관한 이용자의 동의 거절을 이유로 회원가입 등 서비스 제공을 제한하거나 거절하지 않습니다.제18조(“몰“의 의무)① “몰”은 법령과 이 약관이 금지하거나 공서양속에 반하는 행위를 하지 않으며 이 약관이 정하는 바에 따라 지속적이고, 안정적으로 재화?용역을 제공하는데 최선을 다하여야 합니다.② “몰”은 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을 갖추어야 합니다.③ “몰”이 상품이나 용역에 대하여 「표시?광고의 공정화에 관한 법률」 제3조 소정의 부당한 표시?광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 집니다.④ “몰”은 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다.제19조(회원의 ID 및 비밀번호에 대한 의무)① 제17조의 경우를 제외한 ID와 비밀번호에 관한 관리책임은 회원에게 있습니다.② 회원은 자신의 ID 및 비밀번호를 제3자에게 이용하게 해서는 안됩니다.③ 회원이 자신의 ID 및 비밀번호를 도난당하거나 제3자가 사용하고 있음을 인지한 경우에는 바로 “몰”에 통보하고 “몰”의 안내가 있는 경우에는 그에 따라야 합니다.제20조(이용자의 의무)이용자는 다음 행위를 하여서는 안 됩니다.1. 신청 또는 변경시 허위 내용의 등록2. 타인의 정보 도용3. “몰”에 게시된 정보의 변경4. “몰”이 정한 정보 이외의 정보(컴퓨터 프로그램 등) 등의 송신 또는 게시5. “몰” 기타 제3자의 저작권 등 지적재산권에 대한 침해6. “몰” 기타 제3자의 명예를 손상시키거나 업무를 방해하는 행위7. 외설 또는 폭력적인 메시지, 화상, 음성, 기타 공서양속에 반하는 정보를 몰에 공개 또는 게시하는 행위제21조(연결“몰”과 피연결“몰” 간의 관계)① 상위 “몰”과 하위 “몰”이 하이퍼링크(예: 하이퍼링크의 대상에는 문자, 그림 및 동화상 등이 포함됨)방식 등으로 연결된 경우, 전자를 연결 “몰”(웹 사이트)이라고 하고 후자를 피연결 “몰”(웹사이트)이라고 합니다.② 연결“몰”은 피연결“몰”이 독자적으로 제공하는 재화 등에 의하여 이용자와 행하는 거래에 대해서 보증 책임을 지지 않는다는 뜻을 연결“몰”의 초기화면 또는 연결되는 시점의 팝업화면으로 명시한 경우에는 그 거래에 대한 보증 책임을 지지 않습니다.제22조(저작권의 귀속 및 이용제한)① “몰“이 작성한 저작물에 대한 저작권 기타 지적재산권은 ”몰“에 귀속합니다.② 이용자는 “몰”을 이용함으로써 얻은 정보 중 “몰”에게 지적재산권이 귀속된 정보를 “몰”의 사전 승낙 없이 복제, 송신, 출판, 배포, 방송 기타 방법에 의하여 영리목적으로 이용하거나 제3자에게 이용하게 하여서는 안됩니다.③ “몰”은 약정에 따라 이용자에게 귀속된 저작권을 사용하는 경우 당해 이용자에게 통보하여야 합니다.제23조(분쟁해결)① “몰”은 이용자가 제기하는 정당한 의견이나 불만을 반영하고 그 피해를 보상처리하기 위하여 피해보상처리기구를 설치?운영합니다.② “몰”은 이용자로부터 제출되는 불만사항 및 의견은 우선적으로 그 사항을 처리합니다. 다만, 신속한 처리가 곤란한 경우에는 이용자에게 그 사유와 처리일정을 즉시 통보해 드립니다.③ “몰”과 이용자 간에 발생한 전자상거래 분쟁과 관련하여 이용자의 피해구제신청이 있는 경우에는 공정거래위원회 또는 시?도지사가 의뢰하는 분쟁조정기관의 조정에 따를 수 있습니다.제24조(재판권 및 준거법)① “몰”과 이용자 간에 발생한 전자상거래 분쟁에 관한 소송은 제소 당시의 이용자의 주소에 의하고, 주소가 없는 경우에는 거소를 관할하는 지방법원의 전속관할로 합니다. 다만, 제소 당시 이용자의 주소 또는 거소가 분명하지 않거나 외국 거주자의 경우에는 민사소송법상의 관할법원에 제기합니다.② “몰”과 이용자 간에 제기된 전자상거래 소송에는 한국법을 적용합니다.부 칙(시행일) 이 약관은 년 월 일부터 시행합니다.
부 칙(시행일) 이 약관은 년 월 일부터 시행합니다.
                                            </textarea>
                                        </div>
                                    </div>
                                    <div class="p-2 bd-highlight">
                                        <div class="form-check">
                                            <input type='checkbox' 
       												name='terms' 
       												value='terms1' 
       												onclick='checkSelectAll()'/>
                                            <label class="form-check-label pl-2" for="defaultCheck1">
                                                동의
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="p-2 bd-highlight d-flex flex-row pm-3" style="font-size: .8rem;">
                                <div class="bd-highlight font-weight-bold mr-2" style="width: 106px;">비회원 구매 시 <br>
                                    개인정보 수집 <br>이용 동의</div>
                                <div class="bd-highlight flex-grow-1 flex-column">
                                    <div class="bd-highlight">
                                        <div class="flex-grow bd-highlight" style="width: 100%;">
                                            <textarea class="form-control text-black-50"
                                                id="exampleFormControlTextarea1" rows="3" style="font-size: .8rem;" disabled>** 본 양식은 쇼핑몰 운영에 도움을 드리고자 샘플로 제공되는 서식으로 쇼핑몰 운영형태에 따른 수정이 필요합니다. 쇼핑몰에 적용하시기 전, 쇼핑몰 운영 사항 등을 확인하시고 적절한 내용을 반영하여 사용하시기 바랍니다. **1. 개인정보 수집목적 및 이용목적 : 비회원 구매 서비스 제공2. 수집하는 개인정보 항목 : 성명, 주소, 전화번호, 이메일, 결제 정보, 비회원 결제 비밀번호3. 개인정보의 보유기간 및 이용기간원칙적으로, 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간 동안 보존합니다.가. 회사 내부 방침에 의한 정보 보유 사유· 부정거래 방지 및 쇼핑몰 운영방침에 따른 보관 : OO년나. 관련 법령에 의한 정보보유 사유o 계약 또는 청약철회 등에 관한 기록-보존이유 : 전자상거래등에서의소비자보호에관한법률-보존기간 : 5년o 대금 결제 및 재화 등의 공급에 관한 기록-보존이유: 전자상거래등에서의소비자보호에관한법률-보존기간 : 5년 o 소비자 불만 또는 분쟁처리에 관한 기록-보존이유 : 전자상거래등에서의소비자보호에관한법률-보존기간 : 3년 o 로그 기록 -보존이유: 통신비밀보호법-보존기간 : 3개월※ 동의를 거부할 수 있으나 거부시 비회원 구매 서비스 이용이 불가능합니다.
                                            </textarea>
                                        </div>
                                    </div>
                                    <div class="p-2 bd-highlight">
                                        <div class="form-check">
                                            <input type='checkbox' 
       												name='terms' 
       												value='terms2' 
       												onclick='checkSelectAll()'/>
                                            <label class="form-check-label pl-2" for="defaultCheck1">
                                                동의
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 배송주문 -->
                    <div class="row">
                        <div class="col mt-4 mb-1 p-0">
                            <h6 class="font-weight-bold">결제 예정 금액</h6>
                        </div>
                    </div>
                    <div class="row text-center border rounded-top">
                        <div class="col-4">
                            <div class="row py-2 bg-light border-bottom">
                                <div class="col">
                                    총 주문 금액
                                    <button type="button" class="btn btn-outline-secondary btn-sm"
                                        style="font-size: .6rem">내역 보기</button>
                                </div>
                            </div>
                            <div class="row py-3">
                                <div class="col">
                                    <span class="font-weight-bold" style="font-size: 1.5rem;">12,000 </span>원
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="row py-2 bg-light border-bottom">
                                <div class="col">
                                    총 할인 + 부가결제 금액
                                </div>
                            </div>
                            <div class="row py-3">
                                <div class="col">
                                    -<span class="font-weight-bold" style="font-size: 1.5rem;">1,000 </span>원
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="row py-2 bg-light border-bottom">
                                <div class="col">
                                    총 결제 예정 금액
                                </div>
                            </div>
                            <div class="row py-3">
                                <div class="col">
                                    =<span class="font-weight-bold" style="font-size: 1.5rem;">11,000 </span>원
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row border border-top-0" style="font-size: .9rem">
                        <div class="col-2 bg-light py-2 border-right font-weight-bold">총 할인 금액</div>
                        <div class="col-10 py-2">3,000원</div>
                    </div>
                    <div class="row border border-top-0" style="font-size: .9rem">
                        <div class="col-2 bg-light py-2 border-right font-weight-bold">추가 할인 금액</div>
                        <div class="col-10 py-2">0원
                            <button type="button" class="btn btn-outline-secondary btn-sm ml-4"
                                style="font-size: .6rem">내역 보기</button>
                        </div>
                    </div>
                    <div class="row border rounded-bottom border-top-0" style="font-size: .9rem">
                        <div class="col-2 bg-light py-2 border-right font-weight-bold">총 부가 결제 금액</div>
                        <div class="col-10 py-2">2,000원</div>
                    </div>

                    <!-- 결제 수단 -->
                    <div class="row">
                        <div class="col mt-4 mb-1 p-0">
                            <h6 class="font-weight-bold">결제 수단</h6>
                        </div>
                    </div>
                    <div class="row border rounded">
                        <div class="col-9">
                            <div class="row p-3 border-bottom">
                                <div class="col">
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline1" name="customRadioInline1"
                                            class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline1">카드 결제</label>
                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline2" name="customRadioInline1"
                                            class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline2">에스크로(실시간
                                            계좌이체)</label>
                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline3" name="customRadioInline1"
                                            class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline3">휴대폰 결제</label>
                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" id="customRadioInline4" name="customRadioInline1"
                                            class="custom-control-input">
                                        <label class="custom-control-label" for="customRadioInline4">무통장 입금</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row p-3">
                                소액 결제의 경우 PG사 정책에 따라 결제 금액 제한이 있을 수 있습니다.
                            </div>
                        </div>
                        <div class="col-3 border-left bg-light text-right">
                            <div class="row  pt-3 pb-2">
                                <div class="col" style="font-size: .8rem;">카드 결제 최종결제 금액</div>
                            </div>
                            <div class="row text-danger">
                                <div class="col">
                                    <span class="font-weight-bold" style="font-size: 1.8rem;">11,000</span> 원
                                </div>
                            </div>
                            <div class="row mt-3 mb-3">
                                <div class="col">
                                    <button type="button" class="btn btn-outline-success btn-block">결제하기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- 무이자 할부 이용안내 -->
                <div class="row border rounded-top mt-5 bg-light">
                    <div class="col py-2 border-bottm font-weight-bold" style="font-size: .9rem;">
                        무이자 할부 이용안내
                    </div>
                </div>
                <div class="row border border-top-0 rounded-bottom ">
                    <div class="bd-highlight text-black-50 p-3" style="font-size: .8rem;">
                        <p class="m-0">-무이자할부가 적용되지 않은 상품과 무이자할부가 가능한 상품을 동시에 구매할 경우 전체 주문 상품 금액에 대해 무이자할부가 적용되지
                            않습니다.</p>
                        <p class="m-0">-무이자할부를 원하시는 경우 장바구니에서 무이자할부 상품만 선택하여 주문하여 주시기 바랍니다.</p>
                    </div>
                </div>

                <!-- 이용안내 -->
                <div class="row border rounded-top mt-3 bg-light">
                    <div class="col py-2 border-bottm font-weight-bold" style="font-size: .9rem;">
                        이용안내
                    </div>
                </div>
                <div class="row border border-top-0 rounded-bottom ">
                    <div class="bd-highlight text-black-50 p-3" style="font-size: .8rem;">
                        <div class="inner">
                            <h4 style="font-size: .8rem">WindowXP 서비스팩2를 설치하신후 결제가 정상적인 단계로 처리되지 않는경우, 아래의 절차에 따라 해결하시기 바랍니다.</h4>
                            <ol style="padding-left: 20px;">
                                <li class="item1"><a href="javascript:;"
                                        onclick="window.open('https://service-api.echosting.cafe24.com/shop/notice_XP_ActiveX.html','','width=795,height=500,scrollbars=yes',resizable=1);">안심클릭
                                        결제모듈이 설치되지 않은 경우 ActiveX 수동설치</a></li>
                                <li class="item2"><a href="http://www.microsoft.com/korea/windowsxp/sp2/default.asp"
                                        target="_blank">Service Pack 2에 대한 Microsoft사의 상세안내 </a></li>
                                <li class="item3"></li>
                            </ol>
                            <!-- 크로스 브라우징 지원 -->
                            <div class="">
                                <h4 style="font-size: .8rem">아래의 쇼핑몰일 경우에는 모든 브라우저 사용이 가능합니다.</h4>
                                <ol style="padding-left: 20px;">
                                    <li class="item1"><strong>KG이니시스, KCP, LG U+를 사용하는 쇼핑몰일 경우</strong></li>
                                    <li class="item2">결제가능브라우저 : 크롬,파이어폭스,사파리,오페라 브라우저에서 결제 가능<br>(단, window os 사용자에
                                        한하며 리눅스/mac os 사용자는 사용불가)</li>
                                    <li class="item3">최초 결제 시도시에는 플러그인을 추가 설치 후 반드시 브라우저 종료 후 재시작해야만 결제가
                                        가능합니다.<br>(무통장, 휴대폰결제 포함)</li>
                                </ol>
                            </div>
                            <h4 style="font-size: .8rem">세금계산서 발행 안내</h4>
                            <ol style="padding-left: 20px;">
                                <li class="item1">부가가치세법 제 54조에 의거하여 세금계산서는 배송완료일로부터 다음달 10일까지만 요청하실 수 있습니다.</li>
                                <li class="item2">세금계산서는 사업자만 신청하실 수 있습니다.</li>
                                <li class="item3">배송이 완료된 주문에 한하여 세금계산서 발행신청이 가능합니다.</li>
                                <li class="item4">[세금계산서 신청]버튼을 눌러 세금계산서 신청양식을 작성한 후 팩스로 사업자등록증사본을 보내셔야 세금계산서 발생이
                                    가능합니다.</li>
                                <li class="item5">[세금계산서 인쇄]버튼을 누르면 발행된 세금계산서를 인쇄하실 수 있습니다.</li>
                            </ol>
                            <h4 style="font-size: .8rem">부가가치세법 변경에 따른 신용카드매출전표 및 세금계산서 변경안내</h4>
                            <ol style="padding-left: 20px;">
                                <li class="item1">변경된 부가가치세법에 의거, 2004.7.1 이후 신용카드로 결제하신 주문에 대해서는 세금계산서 발행이 불가하며
                                </li>
                                <li class="item2">신용카드매출전표로 부가가치세 신고를 하셔야 합니다.(부가가치세법 시행령 57조)</li>
                                <li class="item3">상기 부가가치세법 변경내용에 따라 신용카드 이외의 결제건에 대해서만 세금계산서 발행이 가능함을 양지하여 주시기
                                    바랍니다.</li>
                            </ol>
                            <h4 style="font-size: .8rem">현금영수증 이용안내</h4>
                            <ol style="padding-left: 20px;">
                                <li class="item1">현금영수증은 1원 이상의 현금성거래(무통장입금, 실시간계좌이체, 에스크로, 예치금)에 대해 발행이 됩니다.</li>
                                <li class="item2">현금영수증 발행 금액에는 배송비는 포함되고, 적립금사용액은 포함되지 않습니다.</li>
                                <li class="item3">발행신청 기간제한 현금영수증은 입금확인일로 부터 48시간안에 발행을 해야 합니다.</li>
                                <li class="item4">현금영수증 발행 취소의 경우는 시간 제한이 없습니다. (국세청의 정책에 따라 변경 될 수 있습니다.)</li>
                                <li class="item5">현금영수증이나 세금계산서 중 하나만 발행 가능 합니다.</li>
                            </ol>
                        </div>
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
</script>

<!-- 전체 동의  -->
<script>
function checkSelectAll()  {
	  // 전체 체크박스
	  const checkboxes 
	    = document.querySelectorAll('input[name="terms"]');
	  // 선택된 체크박스
	  const checked 
	    = document.querySelectorAll('input[name="terms"]:checked');
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
	     = document.getElementsByName('terms');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
	}
</script>

<!-- 우편번호 API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>