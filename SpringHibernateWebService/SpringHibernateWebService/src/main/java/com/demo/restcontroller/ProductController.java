package com.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.demo.beans.Product;
import com.demo.service.ProductService;



@RestController

public class ProductController {
   @Autowired
	ProductService productService;
   @GetMapping("/products")
	public List<Product> getAllProducts(){
	   
	   return productService.getAllProducts();
		
	   
   }
   @PostMapping("/products/{pid}")
   public ResponseEntity<String> addNewProduct(@RequestBody Product p){
	   int n=productService.addNewProduct(p);
	   if(n>0) {
		   return ResponseEntity.ok("Well Done..");
	   }
	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   }
   
}
