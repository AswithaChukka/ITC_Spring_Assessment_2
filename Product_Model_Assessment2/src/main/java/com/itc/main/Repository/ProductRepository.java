package com.itc.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itc.main.model.Product;
@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
//	custom method
	Product getProductByName(String name);

	@Transactional
	@Modifying
	@Query("DELETE FROM Product WHERE name=:name")
	     Integer deleteProductByName(String name);
}
