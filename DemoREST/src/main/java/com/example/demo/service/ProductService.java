package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
public class ProductService implements IProductService {

	@Override
	public List<Product> findAll() {
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		products.add(new Product(501,"Smart Watch","SB001",900.05, 10));
		
		products.add(new Product(502,"Laptop","L001",50000.05, 11));
		products.add(new Product(503,"STV","STV001",10000.05, 9));
		products.add(new Product(504,"AC","AC001",9000.05, 15));
		return products;
	
	}

}
