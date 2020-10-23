package com.cts.truyum.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cts.truyum.util.ConnectionHandler;
import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.MenuItem;
import com.mysql.jdbc.Statement;
public class MenuItemDaoSqlImpl implements MenuItemDao{
    public List<MenuItem> getMenuItemListAdmin(){
    	List<MenuItem> list=new ArrayList<MenuItem>();
     	   try {
     		  Connection con=ConnectionHandler.getConn();
      	      String sql="select * from menu_item";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while (rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				LocalDateTime dateOfLaunch=DateUtil.convertToDate(rs.getString(1));
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menu=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				list.add(menu);
				
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	return list;
    }
    public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> lst=new ArrayList<MenuItem>();
		Connection con=ConnectionHandler.getConn();
		String sql="select * from menu_item where active='Yes' and date_of_launch>?";
		//PreparedStatement ps=con.prepareStatement(sql);
		//ps.setDate(1, ));
		
		try {
			PreparedStatement prep=con.prepareStatement(sql);
			LocalDateTime dt=LocalDateTime.now();
			DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
			prep.setString(1, dt.format(formatter));
			ResultSet rs=prep.executeQuery();
			while (rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				LocalDateTime dateOfLaunch=DateUtil.convertToDate(rs.getString(5));
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menu=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				lst.add(menu);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
    public MenuItem getMenuItem(long menuItemId) {
    	MenuItem menu=null;
		Connection con=ConnectionHandler.getConn();
		String sql="select * from menu_item where item_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			ResultSet rs=ps.executeQuery();
			long id=rs.getLong(1);
			String name=rs.getString(2);
			float price=rs.getFloat(3);
			boolean active=rs.getBoolean(4);
			LocalDateTime date= DateUtil.convertToDate(rs.getString(5));
			String category=rs.getString(6);
			boolean freeDelivery=rs.getBoolean(7);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}
	public void editMenuItem(MenuItem menuItem) {
		Connection con=ConnectionHandler.getConn();
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
		String sql="update menu_item set item_name=?,item_price=?,active=?,date_of_launch=?,category=?,free_delivery=? where item_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setString(4,menuItem.getDateOfLaunch().format(formatter));
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			int r=ps.executeUpdate();
			ps.clearParameters();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
