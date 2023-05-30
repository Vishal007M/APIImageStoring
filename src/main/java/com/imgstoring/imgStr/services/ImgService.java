package com.imgstoring.imgStr.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface ImgService {

	String uploadImage(String path, MultipartFile file) throws IOException;
	
}
