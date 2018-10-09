package com.jgalano.stratpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgalano.stratpoint.model.Product;
import com.jgalano.stratpoint.model.Shop;

public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByShop(Shop shop);
}
