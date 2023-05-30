package com.imgstoring.imgStr.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImgImplService implements ImgService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		
		//File name
		String name = file.getOriginalFilename();
		
		
		//random file namew
		
		String randomID = UUID.randomUUID().toString();
		String filename1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		
		//Fullpath
		String filePath = path+File.separator+name;
		
		
		//create folder if not created
		
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		
		//file cpoy
		Files.copy(file.getInputStream(),Paths.get(filePath));
		
		
		return name;
	}

}
