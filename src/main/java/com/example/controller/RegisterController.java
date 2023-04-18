package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Account;
import com.example.service.AccountService;

@Controller
@RequestMapping("registration")
public class RegisterController {
	@Autowired
	private AccountService accountService;
		
	@GetMapping("form")
	public String registerForm(Model model){
		Account account = new Account();
		model.addAttribute("account",account);

		return "security/registration";
	}
	
	@PostMapping("register")
	public String newAccount(Account account) {
		accountService.save(account);
	
		return "security/registration";
	}
}
