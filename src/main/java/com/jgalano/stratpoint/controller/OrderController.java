package com.jgalano.stratpoint.controller;

import java.time.Instant;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jgalano.stratpoint.model.Order;
import com.jgalano.stratpoint.model.Product;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.service.OrderService;
import com.jgalano.stratpoint.service.ProductService;
import com.jgalano.stratpoint.service.ShopService;
import com.jgalano.stratpoint.service.UserService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-to-cart")
	public ResponseEntity<?> addToCart(HttpSession session, @RequestParam("productId") Long productId, @RequestParam("transactionId") String transactionId) {
		try {
			User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			Product product = productService.getProduct(productId).get();
			Shop shop = shopService.getShop(product.getShop().getId()).get();
			
			Order order = new Order();
			order.setTransactionId(transactionId);
			order.setOrderedBy(user);
			order.setShop(shop);
			order.setProduct(product);
			order.setStatus("CART");
			orderService.addToCart(order);
			
			//UPDATE SHOPPING CART SESSIONS
			setTransactionId(session);	
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@GetMapping("/shopping-cart")
	public String getShopingCartContent(Model model, HttpSession session) {
		User user = (User) session.getAttribute("userDetails");
		model.addAttribute("shoppingCartList", orderService.getShoppingCartContent(user, "CART"));
		model.addAttribute("pageTitle", "Shopping Cart");
		return "/order/shoppingCart";
	}
	
	@GetMapping("/orders")
	public String getOrderList(Model model) {
		User userDetails = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		model.addAttribute("pageTitle", "Orders");
		
		// Check if vendor
		if(userDetails.getRole().getId() == 2) {
			Shop shop = shopService.getShop(userDetails.getShop().getId()).get();
			model.addAttribute("orderList", orderService.getOrderListByShopAndStatusNot(shop, "CART"));
			return "/order/orderList";
		}else {
			model.addAttribute("orderList", orderService.getOrderListByOrderedByAndStatusNot(userDetails, "CART"));
			return "/order/orderListUser";
		}
		
	}
	
	@DeleteMapping("/shopping-cart/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id, HttpSession session) {
		
		orderService.deleteOrder(id);
		
		// UPDATE SHOPPING CART SESSIONS
		setTransactionId(session);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<?> editOrder(@PathVariable("id") Long id) {
		Order order = orderService.getOrder(id).get();
		String status = order.getStatus();
		
		if(status.equals("ACTIVE")) {
			order.setStatus("SHIPPED");
		} else if(status.equals("SHIPPED")) {
			order.setStatus("DELIVERED");
		}
		
		orderService.updateOrder(order);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/shopping-cart/checkout/{transactionId}")
	public ResponseEntity<?> checkout(@PathVariable("transactionId") String transactionId, HttpSession session){
		// TODO BATCH UPDATE
		
		List<Order> orders = orderService.getOrderListByTransactionIdAndStatus(transactionId, "CART");
		for(Order order : orders) {
			order.setStatus("ACTIVE");
			orderService.updateOrder(order);
		}
		
		//UPDATE SHOPPING CART SESSIONS
		setTransactionId(session);
		
		return ResponseEntity.ok().build();
	}
	
	public void setTransactionId(HttpSession session) {
		
		User userDetails = (User) session.getAttribute("userDetails");
		List<Order> shoppingCart = orderService.getShoppingCartContent(userDetails, "CART");
		session.setAttribute("shoppingCart", shoppingCart.size());
		
		String transactionId = "";
		if(shoppingCart.size()>0) {
			transactionId = shoppingCart.get(0).getTransactionId();
		}else {
			Instant instant = Instant.now();
			transactionId = instant.toEpochMilli() + "" + userDetails.getId();
		}
		
		session.setAttribute("transactionId", transactionId);
		
	}
}

