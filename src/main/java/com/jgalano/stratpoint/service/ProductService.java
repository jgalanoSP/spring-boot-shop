package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import com.jgalano.stratpoint.model.Product;
import com.jgalano.stratpoint.model.Shop;

public interface ProductService {
	List<Product> getProductList();
	List<Product> getProductListByShop(Shop shop);
	Optional<Product> getProduct(Long id);
	void saveProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Long id);
}
