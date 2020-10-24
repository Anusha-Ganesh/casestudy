package com.cts.truyum.dao;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
					Date dateOfLaunch=rs.getDate(5);
					String category=rs.getString(6);
					boolean freeDelivery=rs.getBoolean(7);
					MenuItem menu=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
					list.add(menu);
				  }
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      	      
			 catch (SQLException e) {
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
			String sql="select * from menu_item where active=true and date_of_launch<now()";
			PreparedStatement prep=con.prepareStatement(sql);
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch=rs.getDate(5);
				String category=rs.getString(6);
				boolean freeDelivery=rs.getBoolean(7);
				MenuItem menu=new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				lst.add(menu);
			}
				
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			Date date= rs.getDate(5);
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
		Connection con=null;
		String sql="update menu_item set item_name=?,item_price=?,active=?,date_of_launch=?,category=?,free_delivery=? where item_id=?";
		try {
			con=ConnectionHandler.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setString(4,formatter.format(menuItem.getDateOfLaunch()));
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			int r=ps.executeUpdate();
			ps.clearParameters();
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void editMenuItem(MenuItem menuItem) throws FileNotFoundException, SQLException {
		
	}
}
