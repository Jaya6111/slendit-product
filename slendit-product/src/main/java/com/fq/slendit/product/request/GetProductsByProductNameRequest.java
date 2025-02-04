package com.fq.slendit.product.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductsByProductNameRequest {
	
	@NotBlank(message = "Product name is required")
	private String productName;
}
