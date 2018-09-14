package com.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileService {
	String[] saveFiles(CommonsMultipartFile[] files, String path);
}
