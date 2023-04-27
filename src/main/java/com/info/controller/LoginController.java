package com.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.binding.LoginRequest;
import com.info.service.LoginServiceImpl;

@RestController
public class LoginController {
	@Autowired
	private LoginServiceImpl service;
	
    @PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return service.login(request);

	}
}
