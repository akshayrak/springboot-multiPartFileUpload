package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Customer;
import com.example.demo.model.Doc;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DocRepository;

@Service
public class DocStorageService {
  @Autowired
  private DocRepository docRepository;
  
  @Autowired
  private CustomerRepository customerRepository;
  
  public Doc saveFile(MultipartFile file, Integer requestId, String channel,String name,Integer age) {
	  String docname = file.getOriginalFilename();
	  try {
		  Doc doc = new Doc(channel,requestId,docname,file.getContentType(),file.getBytes());
		  Customer customer = new Customer(requestId,name,age);
		  customerRepository.save(customer);
		  return docRepository.save(doc);
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return null;
  }
}
