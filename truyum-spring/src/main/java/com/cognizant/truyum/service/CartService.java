package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.truyum.dao.CartDao;
import com.cts.truyum.dao.CartEmptyException;
import com.cts.truyum.model.MenuItem;
//@Service("cartService")
public class CartService {
	
   private CartDao cartDao;
   
   //@Autowired
   public void setCartDao(CartDao cartDao) {
	   this.cartDao = cartDao;
   }
   public List<MenuItem> getAllCartItems( long userId) throws CartEmptyException
   {
	   List<MenuItem> cartItems = cartDao.getAllCartItems(userId);
	   if(cartItems == null)
		   throw new CartEmptyException("Cart is Empty");
	   else
		   return cartItems;
   }
   public  void addCartItem( long userId, long menuItemId) {
	   cartDao.addCartItem(userId, menuItemId);
	   
   }
   public  void removeCartItem(long userId, long menuItemId) {
	   
	   cartDao.removeCartItem(userId, menuItemId);
   }
}
