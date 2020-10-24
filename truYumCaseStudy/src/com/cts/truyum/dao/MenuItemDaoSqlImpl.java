package com.cts.truyum.dao;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.cts.truyum.util.ConnectionHandler;
import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.MenuItem;
public class MenuItemDaoSqlImpl implements MenuItemDao{
    public List<MenuItem> getMenuItemListAdmin(){
    	List<MenuItem> list=new ArrayList<MenuItem>();
     		  Connection con;
			try {
				con = ConnectionHandler.getConnection();
				String sql="select * from menu_item";
				  PreparedStatement ps=con.prepareStatement(sql);
				  ResultSet rs=ps.executeQuery();
				  while (rs.next()) {
					long id=rs.getLong(1);
					String name=rs.getString(2);
					float price=rs.getFloat(3);
					boolean active=rs.getBoolean(4);
					Date dateOfLaunch=DateUtil.convertToDate(rs.getString(1));
					String category=rs.getString(6);
					boolean freeDelivery=rs.getBoolean(7);
					MenuItem menu=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
					list.add(menu);
				  }
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	      
			 catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	return list;
    }
    public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> lst=new ArrayList<MenuItem>();
		Connection con = null;
		try {
			con = ConnectionHandler.getConnection();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql="select * from menu_item where active=1 and date_of_launch>?";
		//PreparedStatement ps=con.prepareStatement(sql);
		//ps.setDate(1, ));
		
		try {
			PreparedStatement prep=con.prepareStatement(sql);
			Date today=new Date();
			//String dt=today.toString();
			prep.setDate(1, (java.sql.Date) today);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=DateUtil.convertToDate(rs.getString(5));
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menu=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				lst.add(menu);
				
				
			}
		}
			
		 catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
    public MenuItem getMenuItem(long menuItemId) {
    	MenuItem menu=null;
		Connection con = null;
		try {
			con = ConnectionHandler.getConnection();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		};
		String sql="select * from menu_item where item_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			ResultSet rs=ps.executeQuery();
			long id=rs.getLong(1);
			String name=rs.getString(2);
			float price=rs.getFloat(3);
			boolean active=rs.getBoolean(4);
			try {
				Date date= DateUtil.convertToDate(rs.getString(5));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public void editMenuItem(MenuItem menuItem) throws FileNotFoundException, SQLException {
		Connection con=ConnectionHandler.getConnection();
		String sql="update menu_item set item_name=?,item_price=?,active=?,date_of_launch=?,category=?,free_delivery=? where item_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setDate(4,(java.sql.Date) menuItem.getDateOfLaunch());
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
