package com.itc.main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itc.main.model.Product;
import com.itc.main.Repository.ProductRepository;

@Service
public  class ProductServiceImplement implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		Product add_product= this.productRepository.save(product);
		return  add_product;
		
	}
	
	
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
		
	}
	
	
	public boolean deleteProductById(int id) {
		this.productRepository.deleteById(id);
		return true;
	}
	
	
	public Product getProductById(int id) {
		java.util.Optional<Product> op=this.productRepository.findById(id);
		if(op!=null) {
			return op.get();
		}else 
		return null;
	}
	
	
		public Product getProductByName(String name) {
			Product product=this.productRepository.getProductByName(name);
			if(product!=null) {
				return product;
			}
			else
				return null;
			}


		
		public Product updateProduct(Product product) {
				if(this.productRepository.existsById(product.getId())) {
					return this.productRepository.save(product);
					
				}else
					return null;
			}

		public boolean deleteProductByName(String name) {
			this.productRepository.deleteProductByName(name);
			return true;
			
			
		}


		
		
}
