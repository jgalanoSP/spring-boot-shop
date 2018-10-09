package com.jgalano.stratpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgalano.stratpoint.model.Order;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByShopAndStatusNot(Shop shop, String status);
	List<Order> findByOrderedByAndStatus(User orderedBy, String status);
	List<Order> findByOrderedByAndStatusNot(User orderedBy, String status);
	List<Order> findByTransactionIdAndStatus(String transactionId, String status);
}
