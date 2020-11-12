package com.cognizant.truyum.dao;

import java.util.List;

import com.cts.truyum.dao.CartDao;
import com.cts.truyum.dao.CartDaoCollectionImpl;
import com.cts.truyum.dao.CartEmptyException;
import com.cts.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub
		CartDaoCollectionImpl cart=new CartDaoCollectionImpl();
		cart.addCartItem(1, 1);
		cart.addCartItem(1, 2);
		cart.addCartItem(1, 5);
		List<MenuItem> cartItem=cart.getAllCartItems(1);
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
     
	}
	public static void testAddCartItem() throws CartEmptyException {
		CartDaoCollectionImpl cartDaoCollectionImpl=new CartDaoCollectionImpl();
		CartDao cartDao=cartDaoCollectionImpl;
		cartDao.addCartItem(1, 2);
		List<MenuItem> cartItems= cartDao.getAllCartItems(1);
		for (MenuItem m:cartItems) {
			System.out.println(m.toString());
		}
	}
	public static void testGetAllCartItems() throws CartEmptyException {
		CartDaoCollectionImpl cartDaoCollectionImpl=new CartDaoCollectionImpl();
		CartDao cartDao=cartDaoCollectionImpl;
		List<MenuItem> items=cartDao.getAllCartItems(1);
		for(MenuItem m:items) {
			System.out.println(m.toString());
		}
	}
	public static void testRemoveCartItem()  {
		CartDaoCollectionImpl cartDaoCollectionImpl=new CartDaoCollectionImpl();
		CartDao cartDao=cartDaoCollectionImpl;
		cartDao.removeCartItem(1, 2);
		try {
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
