package com.jgalano.stratpoint.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jgalano.stratpoint.model.Order;
import com.jgalano.stratpoint.model.Role;
import com.jgalano.stratpoint.model.Shop;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.service.OrderService;
import com.jgalano.stratpoint.service.RoleService;
import com.jgalano.stratpoint.service.SecurityService;
import com.jgalano.stratpoint.service.ShopService;
import com.jgalano.stratpoint.service.UserService;
import com.jgalano.stratpoint.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserValidator userValidator;
	
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		
		userService.saveUser(userForm);
		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
		return "redirect:/welcome";
	}
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");		
		
		return "login";
	}
	
	@GetMapping("/users")
	public String getUserList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		model.addAttribute("shopList", shopService.getShopList());
		model.addAttribute("pageTitle", "Users");
		return "user/userList";
	}
	
	@GetMapping("/users/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) {
		return userService.getUser(id).get();
	}
	
	@PutMapping("/users")
	public String updateUser(User user, @RequestParam("userRole") Long roleId, @RequestParam("userShop") Long shopId) {
		Role role = roleService.getRole(roleId).get();
		user.setRole(role);
		
		if(shopId == null) {
			user.setShop(null);
		}else {
			if(user.getRole().getName().equals("VENDOR")) {
				Shop shop = shopService.getShop(shopId).get();
				user.setShop(shop);
			}
		}
		
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	


}
