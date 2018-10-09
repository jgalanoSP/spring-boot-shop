package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import com.jgalano.stratpoint.model.Order;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;

public interface OrderService {
	List<Order> getOrderListByShopAndStatusNot(Shop shop, String status);
	List<Order> getShoppingCartContent(User orderedBy, String status);
	List<Order> getOrderListByOrderedByAndStatusNot(User user, String status);
	List<Order> getOrderListByTransactionIdAndStatus(String transactionId, String status);
	Optional<Order> getOrder(Long id);
	void addToCart(Order order);
	void updateOrder(Order order);
	void deleteOrder(Long id);
}
