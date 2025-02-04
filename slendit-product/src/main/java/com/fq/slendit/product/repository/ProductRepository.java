package com.fq.slendit.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fq.slendit.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByUserId(int userId);
	
	List<Product> findByProductNameContaining(String productName);
}
