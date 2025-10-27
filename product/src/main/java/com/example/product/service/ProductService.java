package com.example.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.product.domain.Product;
import com.example.product.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

	private final ProductMapper productMapper;

	public List<Product> getAllProducts() {
		return productMapper.findAll();
	}

	public Product getProduct(Long id) {
		return productMapper.findById(id);
	}

	@Transactional
	public void createProduct(Product product) {
		productMapper.insert(product);
	}

	@Transactional
	public void updateProduct(Product product) {
		productMapper.update(product);
	}

	@Transactional
	public void deleteProduct(Long id) {
		productMapper.delete(id);
	}

}
