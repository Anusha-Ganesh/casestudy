package com.cts.truyum.dao;

import java.util.List;

import com.cts.tryyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		// TODO Auto-generated method stub
		CartDaoSqlImpl cart=new CartDaoSqlImpl();
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
