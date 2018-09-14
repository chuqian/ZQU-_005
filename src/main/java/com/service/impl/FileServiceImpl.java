package com.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String[] saveFiles(CommonsMultipartFile[] files, String path) {
		String[] imgUrls = new String[files.length];
		int index = 0;
		for (CommonsMultipartFile file : files) {
			if (!file.isEmpty()) {
				try {
					File filepath = new File(path);
					if (!filepath.exists())
						filepath.mkdirs();
					// 文件保存路径
					String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
					String savePath = path + "\\" + fileName;
					imgUrls[index++] = fileName;
					// 转存文件
					file.transferTo(new File(savePath));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return imgUrls;
	}

}
