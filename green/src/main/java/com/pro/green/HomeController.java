package com.pro.green;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}

	// 메인화면
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}

	// 회사소개
	@RequestMapping(value = "/company.do", method = RequestMethod.GET)
	public String COMPANY(Locale locale, Model model) {
		return "company";
	}

	// 이용약관
	@RequestMapping(value = "/agreement.do", method = RequestMethod.GET)
	public String agreement(Locale locale, Model model) {
		return "agreement";
	}

	// 개인정보처리방침
	@RequestMapping(value = "/privacyPolicy.do", method = RequestMethod.GET)
	public String privacyPolicy(Locale locale, Model model) {
		return "privacyPolicy";
	}

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	// 기존로그인
	@RequestMapping(value = "/member.do", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		return "member";
	}

	// 비회원로그인
	@RequestMapping(value = "/noMember.do", method = RequestMethod.GET)
	public String unMember(Locale locale, Model model) {
		return "noMember";
	}

	// 아이디 찾기
	@RequestMapping(value = "/find_id.do", method = RequestMethod.GET)
	public String find_id(Locale locale, Model model) {
		return "find_id";
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/find_pw.do", method = RequestMethod.GET)
	public String find_pw(Locale locale, Model model) {
		return "find_pw";
	}



	// SNS계정으로 회원가입
	@RequestMapping(value = "/snsJoin.do", method = RequestMethod.GET)
	public String snsJoin(Locale locale, Model model) {
		return "snsJoin";
	}

	// 장바구니
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(Locale locale, Model model) {
		return "cart";
	}

	// 주문서 작성
	@RequestMapping(value = "/orderList.do", method = RequestMethod.GET)
	public String orderList(Locale locale, Model model) {
		return "orderList";
	}

	// 하드 케이스
	@RequestMapping(value = "/HardCase.do", method = RequestMethod.GET)
	public String HardCase(Locale locale, Model model) {
		return "HardCase";
	}

	// 하드 케이스 상세페이지
	@RequestMapping(value = "/HardCaseDetail.do", method = RequestMethod.GET)
	public String HardCaseDetail(Locale locale, Model model) {
		return "HardCaseDetail";
	}
	
	// 젤 케이스
	@RequestMapping(value = "/GelCase.do", method = RequestMethod.GET)
	public String GelCase(Locale locale, Model model) {
		return "GelCase";
	}

	// 젤 케이스 상세페이지
	@RequestMapping(value = "/GelCaseDetail.do", method = RequestMethod.GET)
	public String GelCaseDetail(Locale locale, Model model) {
		return "GelCaseDetail";
	}
	
	// 카드 케이스
	@RequestMapping(value = "/CardCase.do", method = RequestMethod.GET)
	public String CardCase(Locale locale, Model model) {
		return "CardCase";
	}

	// 카드 케이스 상세페이지
	@RequestMapping(value = "/CardCaseDetail.do", method = RequestMethod.GET)
	public String CardCaseDetail(Locale locale, Model model) {
		return "CardCaseDetail";
	}
	
	// 에어팟 케이스
	@RequestMapping(value = "/AirpodCase.do", method = RequestMethod.GET)
	public String AirpodCase(Locale locale, Model model) {
		return "AirpodCase";
	}

	// 에어팟 케이스 상세페이지
	@RequestMapping(value = "/AirpodCaseDetail.do", method = RequestMethod.GET)
	public String AirpodCaseDetail(Locale locale, Model model) {
		return "AirpodCaseDetail";
	}
	
	// 버즈 케이스
	@RequestMapping(value = "/BudsCase.do", method = RequestMethod.GET)
	public String BudsCase(Locale locale, Model model) {
		return "BudsCase";
	}

	// 버즈 케이스 상세페이지
	@RequestMapping(value = "/BudsCaseDetail.do", method = RequestMethod.GET)
	public String BudsCaseDetail(Locale locale, Model model) {
		return "BudsCaseDetail";
	}
	
	// 액세서리
	@RequestMapping(value = "/Accessory.do", method = RequestMethod.GET)
	public String Accessory(Locale locale, Model model) {
		return "Accessory";
	}

	// 키링
	@RequestMapping(value = "/KeyRing.do", method = RequestMethod.GET)
	public String KeyRing(Locale locale, Model model) {
		return "KeyRing";
	}

	// 키링 상세페이지
	@RequestMapping(value = "/KeyRingDetail.do", method = RequestMethod.GET)
	public String KeyRingDetail(Locale locale, Model model) {
		return "KeyRingDetail";
	}
	
	// 스마트톡
	@RequestMapping(value = "/SmartTok.do", method = RequestMethod.GET)
	public String SmartTok(Locale locale, Model model) {
		return "SmartTok";
	}

	// 스마트톡 상세페이지
	@RequestMapping(value = "/SmartTokDetail.do", method = RequestMethod.GET)
	public String SmartTokDetail(Locale locale, Model model) {
		return "SmartTokDetail";
	}
	
	// 마이페이지
	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET)
	public String myPage(Locale locale, Model model) {
		return "myPage";
	}
	
	//회원정보 수정/탈퇴
	@RequestMapping(value = "/memberEdit.do", method = RequestMethod.GET)
	public String memberEdit(Locale locale, Model model) {
		return "memberEdit";
	}
	
	//구매내역 조회
	@RequestMapping(value = "/purchaseList.do", method = RequestMethod.GET)
	public String purchaseList(Locale locale, Model model) {
		return "purchaseList";
	}
	
	//관심상품 내역조회
	@RequestMapping(value = "/wist_list.do", method = RequestMethod.GET)
	public String wist_list(Locale locale, Model model) {
		return "wist_list";
	}
	
	//게시판 쪽 주소 다시 고민 해 봐야 할 것 같음
	//Q&A
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String product(Locale locale, Model model) {
		return "product";
	}
	
	//Q&A 상세
	@RequestMapping(value = "/product_in.do", method = RequestMethod.GET)
	public String product_in(Locale locale, Model model) {
		return "product_in";
	}
	
	//Q&A 글쓰기
	@RequestMapping(value = "/product_write.do", method = RequestMethod.GET)
	public String product_write(Locale locale, Model model) {
		return "product_write";
	}
	
	//Q&A 수정/삭제
	@RequestMapping(value = "/product_M_D.do", method = RequestMethod.GET)
	public String product_M_D(Locale locale, Model model) {
		return "product_M_D";
	}
	
	//댓글
	@RequestMapping(value = "/product_reWrite.do", method = RequestMethod.GET)
	public String product_reWrite(Locale locale, Model model) {
		return "product_reWrite";
	}
	
	//공지사항
	@RequestMapping(value = "/notice.do", method = RequestMethod.GET)
	public String notice(Locale locale, Model model) {
		return "notice";
	}
	
	//공지사항상세
	@RequestMapping(value = "/notice_in.do", method = RequestMethod.GET)
	public String notice_in(Locale locale, Model model) {
		return "notice_in";
	}
	
	//이벤트
	@RequestMapping(value = "/event.do", method = RequestMethod.GET)
	public String event(Locale locale, Model model) {
		return "event";
	}
	//이벤트상세
	@RequestMapping(value = "/event_in.do", method = RequestMethod.GET)
	public String event_in(Locale locale, Model model) {
		return "event_in";
	}
	
	//리뷰
	@RequestMapping(value = "/review.do", method = RequestMethod.GET)
	public String review(Locale locale, Model model) {
		return "review";
	}
	//리뷰상세
	@RequestMapping(value = "/review_in.do", method = RequestMethod.GET)
	public String review_in(Locale locale, Model model) {
		return "review_in";
	}

}
