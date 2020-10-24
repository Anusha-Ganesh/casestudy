package com.cts.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cts.tryyum.model.Cart;
import com.cts.tryyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
		private Map<Long, Cart> userCarts;
		MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
		List<MenuItem> menu=menuItemDao.getMenuItems();
		public CartDaoCollectionImpl() {
			if(userCarts==null) {
				userCarts=new HashMap<Long, Cart>();
				
			}
			// TODO Auto-generated constructor stub
			
			
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
			double total=0.0;
			for (MenuItem m:cartitems) {
				total+=m.getPrice();
			}
			cart.setTotal(total);
				
			return cartitems;
		}
		@Override
		public void removeCartItem(long userId, long menuItemId) {
			// TODO Auto-generated method stub
			Cart cart = userCarts.get(userId);
			List<MenuItem> deleteItem=cart.getMenuItemList();
			for(MenuItem m:deleteItem) {
				if(m.getId()==menuItemId)
					deleteItem.remove(m);
			}
			
			
			
		}
}
