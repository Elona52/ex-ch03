package com.example.product.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Product {
	private Long id;
	private String name;
	private Integer price;
	private Integer stock;
	private LocalDateTime createdAt;

}
