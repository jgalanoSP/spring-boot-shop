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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jgalano.stratpoint.model.Product;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.service.ProductService;
import com.jgalano.stratpoint.service.ShopService;
import com.jgalano.stratpoint.service.UserService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/products")
	public String getProductList(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("pageTitle", "Products");
		
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("VENDOR"))) {
			User user = userService.findUserByUsername(auth.getName());
			
			Shop shop = shopService.getShop(user.getShop().getId()).get();	
			model.addAttribute("productList", productService.getProductListByShop(shop));
			return "/product/productList";
			
		}else {
			model.addAttribute("productList", productService.getProductList());
			return "/product/productListUser";
		}
		
	}
	
	@GetMapping("/shops/{shopId}/products")
	public String getProductListByShop(@PathVariable("shopId") Long shopId, Model model) {
		Shop shop = shopService.getShop(shopId).get();	
		model.addAttribute("productList", productService.getProductListByShop(shop));
		model.addAttribute("pageTitle", "Products");
		return "/product/productListUser";
	}
	
	@GetMapping("/products/{id}")
	@ResponseBody
	public Product getProduct(@PathVariable("id") Long id) {
		return productService.getProduct(id).get();
	}
	
	@PostMapping("/products")
	public String saveProduct(Product product, @RequestParam("shopId") Long shopId) {
		product.setShop(shopService.getShop(shopId).get());
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@PutMapping("/products")
	public String updateProduct(Product product) {
		productService.updateProduct(product);
		return "redirect:/products";
	}
	
	@DeleteMapping("/products/{shopId}/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
	
}
