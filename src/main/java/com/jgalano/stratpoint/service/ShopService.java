package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import com.jgalano.stratpoint.model.Shop;

public interface ShopService {
	List<Shop> getShopList();
	Optional<Shop> getShop(Long id);
	void saveShop(Shop shop);
	void updateShop(Shop shop);
	void deleteShop(Long id);
}
