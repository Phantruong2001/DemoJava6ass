package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Product;
import com.example.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid
			) {

// nếu có category id thì hiển thị product theo categoryid
		if (cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid);
			model.addAttribute("products", list);
		} else {
// ngược lại thì hiển thị tất cả products
		
			
			List<Product> list = productService.findAll();
			
			model.addAttribute("products", list);
		}
		return "product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		return "product/detail";	
	}
	
	@GetMapping("/product/search")
	public String search(ModelMap model, @RequestParam(name ="name", required = false) String name) {
		
		List<Product> list = null;
		
		if(StringUtils.hasText(name)) {
			list = productService.findByNameContaining(name);
			System.out.println("haha");
		
		}else {
			list = productService.findAll();
			
			
		}
		
		model.addAttribute("products", list);
		
		return "product/list";
	}
}
