package com.jgalano.stratpoint.config;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.jgalano.stratpoint.model.Order;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.service.OrderService;
import com.jgalano.stratpoint.service.ShopService;
import com.jgalano.stratpoint.service.UserService;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired 
	private OrderService orderService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		User userDetails = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		session.setAttribute("userDetails", userDetails);
		
		// Check if vendor
		if(userDetails.getRole().getId() == 2) {
			Shop shop = shopService.getShop(userDetails.getShop().getId()).get();
			session.setAttribute("shopDetails", shop);
		}else if(userDetails.getRole().getId() == 3) {
			List<Order> shoppingCart = orderService.getShoppingCartContent(userDetails, "CART");
			session.setAttribute("shoppingCart", shoppingCart.size());
			
			String transactionId = "";
			
			System.out.println(">>>>>>>CART SIZE: " + shoppingCart.size());
			if(shoppingCart.size()>0) {
				transactionId = shoppingCart.get(0).getTransactionId();
			}else {
				Instant instant = Instant.now();
				transactionId = instant.toEpochMilli() + "" + userDetails.getId();
			}
			
			session.setAttribute("transactionId", transactionId);
		}
		
		redirectStrategy.sendRedirect(request, response, "/welcome");
	}

}
