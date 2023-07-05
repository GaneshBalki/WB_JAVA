package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	@Override
	public List<Product> getAllProducts() {
		
		return productDao.getAllProducts();
	}
	@Override
	public int addNewProduct(Product p) {
		
		return productDao.save(p);
	}

}
