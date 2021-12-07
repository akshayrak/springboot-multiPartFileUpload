package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.example.demo.model.Doc;
import com.example.demo.service.DocStorageService;
import com.example.demo.service.EmployeeService;

@RestController
public class DocController {

	@Autowired 
	private DocStorageService docStorageService;

	@Autowired
    EmployeeService emplService;

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test()
	{
		return "Hello";
	}
	
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


	

	@RequestMapping(path = "/uploadEmployeeDetailsNew", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String uploadEmployeeDetailsNew(@ModelAttribute Employee employee, @RequestParam MultipartFile document)
	{
		System.out.println(employee.getName());
		employee.setFiles(document);
		emplService.createEmployee(employee);


		return "Success";
	}
	
}
