package com.example.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.product.domain.Product;
import com.example.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("product", productService.getAllProducts());
		return "product/list";
	}

	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("product", new Product());
		return "product/form";
	}
	
	@PostMapping
	public String create(@ModelAttribute Product product) {
		productService.createProduct(product);
		return "redirect:/product";
	}
	
	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("product", productService.getProduct(id));
	    return "product/form";
	}

	@PostMapping("/{id}")
	public String update(@PathVariable("id") Long id, @ModelAttribute Product product) {
	    product.setId(id);
	    productService.updateProduct(product);
	    return "redirect:/product";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
	    productService.deleteProduct(id);
	    return "redirect:/product";
	}


}
