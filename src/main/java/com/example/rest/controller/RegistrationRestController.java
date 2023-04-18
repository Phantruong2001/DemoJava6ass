package com.example.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.service.AccountService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/registration")
public class RegistrationRestController {
	@Autowired
	AccountService accountService;
	
	@PostMapping
	public Account create(@RequestBody Account account) {
		return accountService.save(account);
	}
}
