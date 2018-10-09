package com.jgalano.stratpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/shops")
	public String getShopList(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("shopList", shopService.getShopList());
		model.addAttribute("pageTitle", "Shops");
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
			return "/shop/shopList";
		}else {
			return "/shop/shopListUser";
		}
	}
	
	@GetMapping("/shops/{id}")
	@ResponseBody
	public Shop getShop(@PathVariable("id") Long id) {
		return shopService.getShop(id).get();
	}
	
	@PostMapping("/shops")
	public String saveShop(Shop shop) {
		
		if(shop.getId() == null) {
			shop.setStatus("ACTIVE");
		}
		
		shopService.saveShop(shop);
		return "redirect:/shops";
	}
	
	@PutMapping("/shops")
	public String updateShop(Shop shop) {
		shopService.updateShop(shop);
		return "redirect:/shops";
	}
	
	@DeleteMapping("/shops/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		shopService.deleteShop(id);
		return ResponseEntity.ok().build();
	}
	
}
