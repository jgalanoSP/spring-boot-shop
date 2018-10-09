package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	public List<Shop> getShopList() {
		return shopRepository.findAll();
	}

	@Override
	public Optional<Shop> getShop(Long id) {
		return shopRepository.findById(id);
	}

	@Override
	public void saveShop(Shop shop) {
		shopRepository.save(shop);
	}

	@Override
	public void updateShop(Shop shop) {
		shopRepository.save(shop);
	}

	@Override
	public void deleteShop(Long id) {
		shopRepository.deleteById(id);
	}

}
