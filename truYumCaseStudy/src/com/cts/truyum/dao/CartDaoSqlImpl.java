package com.cts.truyum.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.truyum.util.ConnectionHandler;
import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.Cart;
import com.cts.tryyum.model.MenuItem;

public class CartDaoSqlImpl {
	public  void addCartItem(long userId ,long menuItemId ) {
		Connection con=null;
		try {
			con=ConnectionHandler.getConnection();
			String sql="INSERT INTO CART(USER_ID, ITEM_ID) VALUES (?, ?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			if(ps.executeUpdate()>0)
				System.out.println("Query Successful");
			else
				System.out.println("Query not completed");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		Connection con=null;
		List<MenuItem> allCart=new ArrayList<MenuItem>();
		try {
			con=ConnectionHandler.getConnection();
			Cart cart=new Cart(allCart, 0);
			String sql="select menu_item.item_id,item_name,item_price,active,date_of_launch,category,free_delivery from cart,menu_item where cart.item_id=menu_item.item_id and user_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				long id=rs.getLong(1);
				String itemName=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=rs.getDate(5);
				String category=rs.getString(6);
				boolean free=rs.getBoolean(7);
				MenuItem item=new MenuItem(id, itemName, price, active, dateOfLaunch, category, free);
	            allCart.add(item);	
			}
			cart.setMenuItemList(allCart);
			double total=0;
			for(MenuItem m:allCart) {
				total+=m.getPrice();
				System.out.println(m.toString());
			}
			cart.setTotal(total);
			System.out.println("Total="+cart.getTotal());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCart;
	}
	public  void removeCartItem(long userId, long menuItemId) {
		Connection con=null;
		try {
			con=ConnectionHandler.getConnection();
			String sql="delete from cart where user_id=? and item_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			if(ps.executeUpdate()>0)
			System.out.println("Updated");
			else
				System.out.println("Not Updated");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
