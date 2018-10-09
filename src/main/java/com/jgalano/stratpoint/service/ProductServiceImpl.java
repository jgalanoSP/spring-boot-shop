package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgalano.stratpoint.model.Product;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getProductList() {
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getProductListByShop(Shop shop) {
		return productRepository.findByShop(shop);
	}

	@Override
	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
