package com.fq.slendit.product.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductRequest {

	@NotNull(message = "productId is required")
	@Min(value = 1, message = "productId must be a positive number")
	private int productId;
}
