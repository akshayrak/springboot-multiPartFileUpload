package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Doc;
import com.example.demo.service.DocStorageService;

@Controller
public class DocController {

	@Autowired 
	private DocStorageService docStorageService;
	
	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("requestId") Integer requestId, @RequestParam("channel") String channel,@RequestParam("name") String name,@RequestParam Integer age ,@RequestParam("files") MultipartFile[] files) {
		
		try {
		for (MultipartFile file: files) {
			docStorageService.saveFile(file,requestId,channel,name,age);
		}
		return "success";
		}catch(Exception e) {
			return e.toString();
		}
	}
	
}
