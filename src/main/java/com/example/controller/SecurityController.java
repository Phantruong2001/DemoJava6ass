package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("security")
public class SecurityController {

	@GetMapping("login/form")
	public String loginForm(Model model){
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/login";
	}
	
	@GetMapping("login/success")
	public String loginSuccess(Model model){
		model.addAttribute("message", "Đăng nhập thành công");
		return "redirect:/product/list";
	}
	
	@GetMapping("login/error")
	public String loginError(Model model){
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
	}
	
	@GetMapping("unauthoried")
	public String unauthoried(Model model){
		model.addAttribute("message", "Bạn không có quyền truy xuất");
		return "security/login";
	}
	
	@GetMapping("logoff/success")
	public String logoffSuccess(Model model){
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
	
	@GetMapping("form")
	public String registerForm(Model model){
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/registration";
	}
}
