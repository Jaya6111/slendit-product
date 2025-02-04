package com.fq.slendit.product.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fq.slendit.product.request.GetProductRequest;
import com.fq.slendit.product.request.GetProductsByProductNameRequest;
import com.fq.slendit.product.request.GetUserProductsRequest;
import com.fq.slendit.product.request.SaveProductRequest;
import com.fq.slendit.product.response.GetProductResponse;
import com.fq.slendit.product.response.SaveProductResponse;
import com.fq.slendit.product.service.ProductService;

@RestController
@RequestMapping("/slendit/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public SaveProductResponse saveProduct(@RequestBody @Valid SaveProductRequest request) {
		return service.saveProduct(request);
	}

	@GetMapping("/getProduct")
	public GetProductResponse getProduct(@RequestBody @Valid GetProductRequest request) {
		return service.getProduct(request);
	}
	
	@GetMapping("/getUserProducts")
	public GetProductResponse getUserProducts(@RequestBody @Valid GetUserProductsRequest request) {
		return service.getUserProducts(request);
	}
	
	@GetMapping("getProducts-byName")
	public GetProductResponse getProductsByName(@RequestBody @Valid GetProductsByProductNameRequest request) {
		return service.getProductsByProductName(request);
	}
	
}