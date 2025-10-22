package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ExService;

@RestController
public class SimpleRestController {
	ExService exService;

	public SimpleRestController(ExService exService) {
		this.exService = exService;
	}

	@RequestMapping("/ex521")
	public String getEx521() {
		return exService.ex521();
	}

	@RequestMapping("/ex522")
	public String getEx522() {
		return exService.ex522();
	}
		
	@RequestMapping("/ex523")
	public String getEx523() {
		return exService.ex523();
	}
}
