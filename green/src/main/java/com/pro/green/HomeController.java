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

	// ����ȭ��
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}

	// ȸ��Ұ�
	@RequestMapping(value = "/company.do", method = RequestMethod.GET)
	public String COMPANY(Locale locale, Model model) {
		return "company";
	}

	// �̿���
	@RequestMapping(value = "/agreement.do", method = RequestMethod.GET)
	public String agreement(Locale locale, Model model) {
		return "agreement";
	}

	// ��������ó����ħ
	@RequestMapping(value = "/privacyPolicy.do", method = RequestMethod.GET)
	public String privacyPolicy(Locale locale, Model model) {
		return "privacyPolicy";
	}

	// �α���
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	// �����α���
	@RequestMapping(value = "/member.do", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
		return "member";
	}

	// ��ȸ���α���
	@RequestMapping(value = "/noMember.do", method = RequestMethod.GET)
	public String unMember(Locale locale, Model model) {
		return "noMember";
	}

	// ���̵� ã��
	@RequestMapping(value = "/find_id.do", method = RequestMethod.GET)
	public String find_id(Locale locale, Model model) {
		return "find_id";
	}

	// ��й�ȣ ã��
	@RequestMapping(value = "/find_pw.do", method = RequestMethod.GET)
	public String find_pw(Locale locale, Model model) {
		return "find_pw";
	}



	// SNS�������� ȸ������
	@RequestMapping(value = "/snsJoin.do", method = RequestMethod.GET)
	public String snsJoin(Locale locale, Model model) {
		return "snsJoin";
	}

	// ��ٱ���
	@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
	public String cart(Locale locale, Model model) {
		return "cart";
	}

	// �ֹ��� �ۼ�
	@RequestMapping(value = "/orderList.do", method = RequestMethod.GET)
	public String orderList(Locale locale, Model model) {
		return "orderList";
	}

	// �ϵ� ���̽�
	@RequestMapping(value = "/HardCase.do", method = RequestMethod.GET)
	public String HardCase(Locale locale, Model model) {
		return "HardCase";
	}

	// �ϵ� ���̽� ��������
	@RequestMapping(value = "/HardCaseDetail.do", method = RequestMethod.GET)
	public String HardCaseDetail(Locale locale, Model model) {
		return "HardCaseDetail";
	}
	
	// �� ���̽�
	@RequestMapping(value = "/GelCase.do", method = RequestMethod.GET)
	public String GelCase(Locale locale, Model model) {
		return "GelCase";
	}

	// �� ���̽� ��������
	@RequestMapping(value = "/GelCaseDetail.do", method = RequestMethod.GET)
	public String GelCaseDetail(Locale locale, Model model) {
		return "GelCaseDetail";
	}
	
	// ī�� ���̽�
	@RequestMapping(value = "/CardCase.do", method = RequestMethod.GET)
	public String CardCase(Locale locale, Model model) {
		return "CardCase";
	}

	// ī�� ���̽� ��������
	@RequestMapping(value = "/CardCaseDetail.do", method = RequestMethod.GET)
	public String CardCaseDetail(Locale locale, Model model) {
		return "CardCaseDetail";
	}
	
	// ������ ���̽�
	@RequestMapping(value = "/AirpodCase.do", method = RequestMethod.GET)
	public String AirpodCase(Locale locale, Model model) {
		return "AirpodCase";
	}

	// ������ ���̽� ��������
	@RequestMapping(value = "/AirpodCaseDetail.do", method = RequestMethod.GET)
	public String AirpodCaseDetail(Locale locale, Model model) {
		return "AirpodCaseDetail";
	}
	
	// ���� ���̽�
	@RequestMapping(value = "/BudsCase.do", method = RequestMethod.GET)
	public String BudsCase(Locale locale, Model model) {
		return "BudsCase";
	}

	// ���� ���̽� ��������
	@RequestMapping(value = "/BudsCaseDetail.do", method = RequestMethod.GET)
	public String BudsCaseDetail(Locale locale, Model model) {
		return "BudsCaseDetail";
	}
	
	// �׼�����
	@RequestMapping(value = "/Accessory.do", method = RequestMethod.GET)
	public String Accessory(Locale locale, Model model) {
		return "Accessory";
	}

	// Ű��
	@RequestMapping(value = "/KeyRing.do", method = RequestMethod.GET)
	public String KeyRing(Locale locale, Model model) {
		return "KeyRing";
	}

	// Ű�� ��������
	@RequestMapping(value = "/KeyRingDetail.do", method = RequestMethod.GET)
	public String KeyRingDetail(Locale locale, Model model) {
		return "KeyRingDetail";
	}
	
	// ����Ʈ��
	@RequestMapping(value = "/SmartTok.do", method = RequestMethod.GET)
	public String SmartTok(Locale locale, Model model) {
		return "SmartTok";
	}

	// ����Ʈ�� ��������
	@RequestMapping(value = "/SmartTokDetail.do", method = RequestMethod.GET)
	public String SmartTokDetail(Locale locale, Model model) {
		return "SmartTokDetail";
	}
	
	// ����������
	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET)
	public String myPage(Locale locale, Model model) {
		return "myPage";
	}
	
	//ȸ������ ����/Ż��
	@RequestMapping(value = "/memberEdit.do", method = RequestMethod.GET)
	public String memberEdit(Locale locale, Model model) {
		return "memberEdit";
	}
	
	//���ų��� ��ȸ
	@RequestMapping(value = "/purchaseList.do", method = RequestMethod.GET)
	public String purchaseList(Locale locale, Model model) {
		return "purchaseList";
	}
	
	//���ɻ�ǰ ������ȸ
	@RequestMapping(value = "/wist_list.do", method = RequestMethod.GET)
	public String wist_list(Locale locale, Model model) {
		return "wist_list";
	}
	
	//�Խ��� �� �ּ� �ٽ� ��� �� ���� �� �� ����
	//Q&A
	@RequestMapping(value = "/product.do", method = RequestMethod.GET)
	public String product(Locale locale, Model model) {
		return "product";
	}
	
	//Q&A ��
	@RequestMapping(value = "/product_in.do", method = RequestMethod.GET)
	public String product_in(Locale locale, Model model) {
		return "product_in";
	}
	
	//Q&A �۾���
	@RequestMapping(value = "/product_write.do", method = RequestMethod.GET)
	public String product_write(Locale locale, Model model) {
		return "product_write";
	}
	
	//Q&A ����/����
	@RequestMapping(value = "/product_M_D.do", method = RequestMethod.GET)
	public String product_M_D(Locale locale, Model model) {
		return "product_M_D";
	}
	
	//���
	@RequestMapping(value = "/product_reWrite.do", method = RequestMethod.GET)
	public String product_reWrite(Locale locale, Model model) {
		return "product_reWrite";
	}
	
	//��������
	@RequestMapping(value = "/notice.do", method = RequestMethod.GET)
	public String notice(Locale locale, Model model) {
		return "notice";
	}
	
	//�������׻�
	@RequestMapping(value = "/notice_in.do", method = RequestMethod.GET)
	public String notice_in(Locale locale, Model model) {
		return "notice_in";
	}
	
	//�̺�Ʈ
	@RequestMapping(value = "/event.do", method = RequestMethod.GET)
	public String event(Locale locale, Model model) {
		return "event";
	}
	//�̺�Ʈ��
	@RequestMapping(value = "/event_in.do", method = RequestMethod.GET)
	public String event_in(Locale locale, Model model) {
		return "event_in";
	}
	
	//����
	@RequestMapping(value = "/review.do", method = RequestMethod.GET)
	public String review(Locale locale, Model model) {
		return "review";
	}
	//�����
	@RequestMapping(value = "/review_in.do", method = RequestMethod.GET)
	public String review_in(Locale locale, Model model) {
		return "review_in";
	}

}
