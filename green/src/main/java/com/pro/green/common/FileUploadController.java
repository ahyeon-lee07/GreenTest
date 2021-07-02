package com.pro.green.common;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FileUploadController {
	//���� ���� ��ġ
	private static final String CURR_IMAGE_REPO_PATH = "C:\\upload\\green";
	
	@RequestMapping(value = "/form")
	public String form() {
		return "uploadForm";		//���ε� â�� uploadForm.jsp�� ��ȯ
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest,
								HttpServletRequest response) throws Exception {
		multipartRequest.setCharacterEncoding("UTF-8");
		Map map = new HashMap();	//�Ű����� ������ ���� ������ ������ Map�� ����
		Enumeration enu = multipartRequest.getParameterNames();
		
		//���۵� �Ű����� ���� key/value�� map�� ����
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			map.put(name, value);
		}
		
		//������ ���ε��� �� ��ȯ�� ���� �̸��� ����� FileList�� �ٽ� map�� ����
		List fileList = fileProcess(multipartRequest);
		map.put("fileList", fileList);
		ModelAndView mav = new ModelAndView();
		//mao�� ���â���� ������
		mav.addObject("map", map);
		mav.setViewName("result");
		return mav;
	}


	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
		List<String> fileList = new ArrayList<String>();
		//÷�ε� ���� �̸��� �����ɴϴ�.
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String FileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(FileName);	//���� �̸��� ���� MultipartFile ��ü�� ������
			String originalFileName = mFile.getOriginalFilename();		//���� ���� �̸��� ������
			fileList.add(originalFileName);		//���� �̸��� �ϳ��� fileList�� ����
			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + FileName);
			if(mFile.getSize() != 0) {	//÷�ε� ������ �ִ��� üũ
				//��ο� ������ ������ �� ��ο� �ش��ϴ� ���丮�� ���� �� ���� ����
				if(! file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName));	//�ӽ÷� ����� mutipartFile�� ���� ���Ϸ� ����
			}
			
		}
		return fileList;
	}
	
}
