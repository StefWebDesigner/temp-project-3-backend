package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ShopProduct;
import com.revature.models.User;
import com.revature.models.WishList;
import com.revature.services.UserServiceImpl;
import com.revature.services.WishListService;
import com.revature.web.dto.WishListRequest;

@CrossOrigin
@RestController
public class WishListServlet {
	
	
	WishListService wishListService;
	UserServiceImpl userService;
	
	@Autowired
	public WishListServlet(WishListService wishListService, UserServiceImpl userService) {
		this.wishListService = wishListService;
		this.userService = userService;
	}

	@PostMapping("/myWishList")
	public List<WishList> returnMyWishList(Authentication auth) {
		int id = userService.getUserByUsername(auth.getName()).getId();
	    User user = userService.getUserById(id).get();
	    return wishListService.getMyWishList(user);
	}
	
	@PostMapping("/addToWishList")
	public List<WishList> addToWishList(Authentication auth, @RequestBody WishListRequest wishListRequest) {
		return null;
	}
	
	@PostMapping("/removeFromWishList")
	public List<WishList> removeFromWishList(Authentication auth, @RequestBody WishListRequest wishListRequest) {
		return null;
	}
}
