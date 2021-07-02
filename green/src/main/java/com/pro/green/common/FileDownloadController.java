package com.pro.green.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	//파일 저장 위치
	private static String CURR_IMAGE_REPO_PATH = "C:\\upload\\green";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFilename, //다운로드할 이미지 파일 이름 전달
							HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFilename;
		
		//파일 객체를 생성합니다.
		File file = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		//헤더에 파일 이름을 설정
		response.addHeader("Content-disponsition", "attachment; fileName=" + imageFilename);
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		//버퍼를 이용해 한번에 8Kbyte 씩 브라우저로 전송
		while (true) {
			int count = in.read(buffer); //버퍼에 읽어들인 문자개수
			if(count == -1) break;       //버퍼의 마지막에 도달했는지 체크
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
	}
}
