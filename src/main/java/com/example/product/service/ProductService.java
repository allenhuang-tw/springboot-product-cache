package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	
    private final IProductRepository productRepository;
    
    public ProductService(IProductRepository productRepository) {
    	this.productRepository = productRepository;
    }
  

    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Long id) {
        System.out.println("查資料庫中...");
        return productRepository.findById(id).orElse(null);
    }
}
