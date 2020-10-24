package com.cts.truyum.dao;

import java.util.List;

import com.cts.tryyum.model.MenuItem;

public class CartDaoSqlImplTest {
     public static void main(String[] args) throws CartEmptyException {
    	 System.out.println("Add to Cart");
    	 testAddCartItem();
    	 System.out.println("Your Cart !!!!");
    	 testGetAllCartItem();
    	 System.out.println("Removing Item");
    	 testRemoveCartItem();
		
	}
     public static void testAddCartItem() {
    	 CartDaoSqlImpl cart=new CartDaoSqlImpl();
    	 cart.addCartItem(1, 1);
    	 cart.addCartItem(1, 5);
    	 cart.addCartItem(2, 2);
    	 cart.addCartItem(2, 3);
     }
     
     public static void testGetAllCartItem() throws CartEmptyException {
    	 int userId=2;
    	 CartDaoSqlImpl allItems=new CartDaoSqlImpl();
    	 List<MenuItem> list=allItems.getAllCartItems(userId);
     }
     public static void testRemoveCartItem() {
    	 CartDaoSqlImpl removeItems=new CartDaoSqlImpl();
    	 long userId=1;
    	 long itemId=5;
    	 removeItems.removeCartItem(userId, itemId);
    	 System.out.println("Cart After Deletion");
    	 try {
			List<MenuItem> delCart=removeItems.getAllCartItems(userId);
			for(MenuItem m:delCart) {
				System.out.println(m.toString());
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cart Is empty");
		}
    	 
     }
}
