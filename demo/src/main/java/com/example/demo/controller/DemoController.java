package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateDeveloper;
import com.example.demo.dto.DeveloperDetailDto;
import com.example.demo.dto.DeveloperDto;
import com.example.demo.dto.EditDeveloper;
import com.example.demo.service.DemoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

	final DemoService demoService;

	@GetMapping("/developers")
	public List<DeveloperDto> getAllDevelopers() {
		log.info("GET /developers HTTP/1.1");
		return demoService.getAllDevelopers();
	}
	
	//@PathVariable으로 {memberId}에 값을 매핑함.
	@GetMapping("/developerDetail/{memberId}")
	public DeveloperDetailDto getDeveloperDetail(@PathVariable String memberId) {
		log.info("GET /developers HTTP/1.1");
		return demoService.getDeveloperDetail(memberId);
	}

	@PostMapping("/createdevelopers")
	public CreateDeveloper.Responese createDevelopers (
			@Valid @RequestBody CreateDeveloper.Request request ) {
		
		log.info("request : {}",request);					
		return demoService.createDeveloper(request);		
		
	}
	
	//@PathVariable으로 {memberId}에 값을 매핑함.
	@GetMapping("/developerDetail/{memberId}")
	public DeveloperDetailDto editDeveloper(@PathVariable String memberId ,
			@Valid @RequestBody EditDeveloper.Request request) {
		log.info("GET /developers HTTP/1.1");
		return demoService.editDeveloper(memberId,request);
	}
}
