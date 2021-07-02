package com.pro.green;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

/*@Controller*/
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\green\\image_repo";
	//파일 위치를 저장
	
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, /* 다운로드할 이미지 파일 이름을 전달*/
			                 HttpServletResponse response)throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File file = new File(downFile); /*다운로드할 파일 객체를 생성*/

		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName); /*헤더에 파일 이름을 설정*/
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		/*버퍼를 이용해 한번에 8kbyte씩 브라우저로 전송*/
		while (true) {
			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
	

	@RequestMapping("/download")
	protected void thumnailDownload(@RequestParam("imageFileName") String imageFileName,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
		if (image.exists()) { 
			thumbnail.getParentFile().mkdirs();
		    Thumbnails.of(image).size(50,50).outputFormat("png").toFile(thumbnail);
		}

		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

	/*
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
		if (image.exists()) { 
			Thumbnails.of(image).size(50,50).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
	*/
}