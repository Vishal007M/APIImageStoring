package com.imgstoring.imgStr.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imgstoring.imgStr.entity.ImgEntity;
import com.imgstoring.imgStr.services.ImgService;

@RestController
@RequestMapping("/file")
public class ImController {
	
	@Autowired
	private ImgService imgService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<ImgEntity> fileupload(@RequestParam("image") MultipartFile image){
		
	    String filename = null;
		try {
			filename = this.imgService.uploadImage(path, image);
			
			
			//repository call
			//file name save
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    return new ResponseEntity<>(new ImgEntity(null, "Image is not uploaded due to server error !!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    return new ResponseEntity<>(new ImgEntity(filename, "Image is susscessfully uploaded !!"),HttpStatus.OK);
	}
	

}
