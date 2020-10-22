package com.cts.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.truyum.util.ConnectionHandler;
import com.cts.tryyum.model.MenuItem;
import com.mysql.jdbc.Statement;

public class MenuItemDaoSqlImpl {
    public List<MenuItem> getMenuItemListAdmin(){
    	List<MenuItem> list=new ArrayList<MenuItem>();
     	   try {
     		  Connection con=ConnectionHandler.getConn();
      	      String sql="select * from menu_item";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while (rs.next())) {
				type type = (type) rs.nextElement();
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	return list;
    }
}
