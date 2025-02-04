package com.fq.slendit.product.request;

import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserProductsRequest {
	
	@Min(value = 1, message = "productId must be a positive number")
	private int userId;
}
