package com.fq.slendit.product.response;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import com.fq.slendit.product.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponse extends AbstractResponse{

	public GetProductResponse(HttpStatus status, String statusCode, String message, Set<String> errorMessages) {
		super(status, statusCode, message, errorMessages);
	}

	private List<Product> products;
}
