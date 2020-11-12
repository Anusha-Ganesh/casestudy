package com.cts.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.truyum.model.Cart;
import com.cts.truyum.model.MenuItem;
//@Component
public class CartDaoCollectionImpl implements CartDao {
		private Map<Long, Cart> userCarts;
		MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem> menu = menuItemDao.getMenuItems();
		
		public Map<Long, Cart> getUserCarts() {
			return userCarts;
		}
		//@Autowired
		public void setUserCarts(Map<Long, Cart> userCarts) {
			this.userCarts = userCarts;
		}
		public MenuItemDaoCollectionImpl getMenuItemDao() {
			return menuItemDao;
		}
		public void setMenuItemDao(MenuItemDaoCollectionImpl menuItemDao) {
			this.menuItemDao = menuItemDao;
		}
		public List<MenuItem> getMenu() {
			return menu;
		}
		public void setMenu(List<MenuItem> menu) {
			this.menu = menu;
		}
		@Override
		public void addCartItem(long userId, long menuItemId) {
			// TODO Auto-generated method stub
			List<MenuItem> menuItems;
			MenuItemDaoCollectionImpl menuItemDaoCollectionImpl=new MenuItemDaoCollectionImpl();
			MenuItemDao menuItemDao=menuItemDaoCollectionImpl;
			MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
			if(userCarts.containsKey(userId)) {
				Cart cart=userCarts.get(userId);
				menuItems=cart.getMenuItemList();
				menuItems.add(menuItem);
				cart.setMenuItemList(menuItems);
				cart.setTotal(menuItem.getPrice());
				userCarts.put(userId, cart);
			}
			else {
				menuItems=new ArrayList<MenuItem>();
				Cart cart=new Cart(menuItems, menuItem.getPrice());
				userCarts.put(userId, cart);
			}
			
		}
		@Override
		public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException  {
			// TODO Auto-generated method stub
			Cart cart=userCarts.get(userId);
			List<MenuItem> cartitems=cart.getMenuItemList();
			if(cartitems.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			}
			double total = 0.0;
			for (MenuItem m:cartitems) {
				total += m.getPrice();
			}
			cart.setTotal(total);
				
			return cartitems;
		}
		@Override
		public void removeCartItem(long userId, long menuItemId) {
			// TODO Auto-generated method stub
			Cart cart = userCarts.get(userId);
			List<MenuItem> deleteItem=cart.getMenuItemList();
			for(MenuItem m : deleteItem) {
				if(m.getId()==menuItemId)
					deleteItem.remove(m);
			}
			
			
			
		}
}
