package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.itc.main.model.Product;
import com.itc.main.service.ProductService;


@RestController
@RequestMapping("/api/")
public class ProductController {
	
	@Autowired
	 ProductService productService;
	
	
	@PostMapping("save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product ){
	 Product add_product=this.productService.saveProduct(product);
	 return new ResponseEntity<Product>(add_product,HttpStatus.CREATED);
}

	@GetMapping("products")
public ResponseEntity<List<Product>> getAllProducts(){
	List<Product> list=this.productService.getAllProducts();
	
	return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
}
	@DeleteMapping("product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id) {
		boolean b = this.productService.deleteProductById(id);
				if(b)
					return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
				else
					return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("product/{id}")
	public ResponseEntity getProductById(@PathVariable int id){
		Product product=this.productService.getProductById(id);
		if(product!=null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
			return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("productname/{name}")
	public ResponseEntity getProductByName(@PathVariable String name) {
	Product product=this.productService.getProductByName(name);
	if(product!=null) {
		return new ResponseEntity<Product>(product,HttpStatus.OK);
}else
	return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("product")
	  public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product list=this.productService.updateProduct(product);
		if(list!=null) {
			return new ResponseEntity<Product>(list,HttpStatus.OK);
	}else
		return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
	
	}
	@DeleteMapping("productname/{name}")
	public ResponseEntity deleteProductByName(@PathVariable String name) {
	boolean product=this.productService.deleteProductByName(name);
	if(product==true)
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	else
		return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
	
}

