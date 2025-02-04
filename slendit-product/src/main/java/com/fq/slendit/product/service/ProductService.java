package com.fq.slendit.product.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fq.slendit.product.entity.Product;
import com.fq.slendit.product.repository.ProductRepository;
import com.fq.slendit.product.request.GetProductRequest;
import com.fq.slendit.product.request.GetProductsByProductNameRequest;
import com.fq.slendit.product.request.GetUserProductsRequest;
import com.fq.slendit.product.request.SaveProductRequest;
import com.fq.slendit.product.response.GetProductResponse;
import com.fq.slendit.product.response.SaveProductResponse;
import com.fq.slendit.product.util.ProductUtil;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductUtil productUtil;

	public SaveProductResponse saveProduct(@Valid SaveProductRequest request) {

		Product product = productUtil.setProduct(request);
		if (product == null) {
			return new SaveProductResponse(HttpStatus.PRECONDITION_FAILED, "412",
					"Data missing. Please provide complete details about product", null);
		}

		Product savedProduct = repository.save(product);
		if (savedProduct.getId() > 0 && savedProduct != null) {
			SaveProductResponse response = new SaveProductResponse(HttpStatus.CREATED, "201",
					"Product saved successfully", null);
			response.setProductId(savedProduct.getId());
			return response;
		}

		return new SaveProductResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Failed to save the product", null);

	}

	public GetProductResponse getProduct(@Valid GetProductRequest request) {
		
		Optional<Product> opnlProduct = repository.findById(request.getProductId());
		if(!opnlProduct.isPresent()) {
			return new GetProductResponse(HttpStatus.NOT_FOUND, "404", "No product found with the given product id", null);
		}
		
		Product product = opnlProduct.get();
		GetProductResponse response = new GetProductResponse(HttpStatus.FOUND, "302", "success", null);
		response.setProducts(Arrays.asList(product));
		
		return response;
	}

	public GetProductResponse getUserProducts(@Valid GetUserProductsRequest request) {
		
		List<Product> products = repository.findByUserId(request.getUserId());
		return sendProductsResponse(products);
	}

	public GetProductResponse getProductsByProductName(@Valid GetProductsByProductNameRequest request) {
		
		List<Product> products = repository.findByProductNameContaining(request.getProductName());
		return sendProductsResponse(products);
	}
	
	private GetProductResponse sendProductsResponse(List<Product> products) {
		
		if(products.isEmpty()) {
			return new GetProductResponse(HttpStatus.NOT_FOUND, "404", "No products found", null);
		}
		
		GetProductResponse response = new GetProductResponse(HttpStatus.FOUND, "302", "success", null);
		response.setProducts(products);
		return response;
	}
}
