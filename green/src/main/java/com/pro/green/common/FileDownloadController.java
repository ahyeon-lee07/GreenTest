package com.pro.green.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {
	//���� ���� ��ġ
	private static String CURR_IMAGE_REPO_PATH = "C:\\upload\\green";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFilename, //�ٿ�ε��� �̹��� ���� �̸� ����
							HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFilename;
		
		//���� ��ü�� �����մϴ�.
		File image = new File(downFile);
		
		//Ȯ���ڸ� ������ ���� �̹��� ������ �̸��� �����´�.
		int lastIndex = imageFilename.lastIndexOf(".");
		String fileName = imageFilename.substring(0, lastIndex);
		
		//���� �̹��� ���� �̸��� ���� �̸��� ����� ���Ͽ� ���� File ��ü ����
		File thumbnail = new File(CURR_IMAGE_REPO_PATH + "\\" + "thumbnail" + "\\" + fileName + ".png");
		
		//���� �̹��� ������ ���ΰԷΰ� 50�ȼ��� png ������ ����� �̹��� ���� ����
		if(image.exists()) {
			thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(50, 50).outputFormat("png").toFile(thumbnail);
		}
		
		
		//������ ����� ������ �������� ����
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		
		while(true) {
			int count = in.read(buffer);
			if(count == -1)
			break;
			out.write(buffer, 0, count);
		}
		
		in.close();
		out.close();
		
	}
	
	
	
	/*
	 * @RequestMapping("/download") protected void
	 * download(@RequestParam("imageFileName") String imageFilename, //�ٿ�ε��� �̹��� ����
	 * �̸� ���� HttpServletResponse response) throws Exception { OutputStream out =
	 * response.getOutputStream(); String downFile = CURR_IMAGE_REPO_PATH + "\\" +
	 * imageFilename;
	 * 
	 * //���� ��ü�� �����մϴ�. File file = new File(downFile);
	 * response.setHeader("Cache-Control", "no-cache"); //����� ���� �̸��� ����
	 * response.addHeader("Content-disponsition", "attachment; fileName=" +
	 * imageFilename); FileInputStream in = new FileInputStream(file); byte[] buffer
	 * = new byte[1024 * 8]; //���۸� �̿��� �ѹ��� 8Kbyte �� �������� ���� while (true) { int
	 * count = in.read(buffer); //���ۿ� �о���� ���ڰ��� if(count == -1) break; //������ ��������
	 * �����ߴ��� üũ out.write(buffer, 0, count); } in.close(); out.close();
	 * 
	 * }
	 */
}
