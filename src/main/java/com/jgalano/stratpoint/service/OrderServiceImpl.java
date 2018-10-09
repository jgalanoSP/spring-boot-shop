package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgalano.stratpoint.model.Order;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getOrderListByShopAndStatusNot(Shop shop, String status) {
		return orderRepository.findByShopAndStatusNot(shop, status);
	}

	@Override
	public List<Order> getShoppingCartContent(User orderedBy, String status) {
		return orderRepository.findByOrderedByAndStatus(orderedBy, status);
	}
	
	@Override
	public List<Order> getOrderListByOrderedByAndStatusNot(User orderedBy, String status) {
		return orderRepository.findByOrderedByAndStatusNot(orderedBy, status);
	}

	@Override
	public List<Order> getOrderListByTransactionIdAndStatus(String transactionId, String status) {
		return orderRepository.findByTransactionIdAndStatus(transactionId, status);
	}
	
	@Override
	public Optional<Order> getOrder(Long id) {
		return orderRepository.findById(id);
	}
	
	@Override
	public void addToCart(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);;
	}
	
}
