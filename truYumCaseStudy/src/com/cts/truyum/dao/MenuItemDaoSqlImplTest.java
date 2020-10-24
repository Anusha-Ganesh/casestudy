package com.cts.truyum.dao;

import java.awt.Menu;
import java.util.List;

import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.MenuItem;

public class MenuItemDaoSqlImplTest {
     public static void main(String[] args) {
    	 System.out.println("The Admin List");
    	  testGetMenuItemListAdmin(); 
    	  System.out.println("The Customer's List");
    	  testGetMenuItemListCustomer();
    	  testModifyMenuItem();
    	  System.out.println("Modified List");
    	  testGetMenuItemListAdmin();
		
	}       
    public static void testGetMenuItemListAdmin() {
    	MenuItemDaoSqlImpl menuItemsSql=new MenuItemDaoSqlImpl();
    	List<MenuItem> itemAdmin=menuItemsSql.getMenuItemListAdmin();
    	for(MenuItem m:itemAdmin) {
    		System.out.println(m.toString());
    	}
    }
    public static void testModifyMenuItem() {
    	MenuItem item=new MenuItem(1, "Sandwitch",119.00f, true, DateUtil.convertToDate("15/10/2018"), "Main Course", false);
    	MenuItemDaoCollectionImpl menuItems=new MenuItemDaoCollectionImpl();
    	MenuItemDao menuItemDao=menuItems;
    	menuItemDao.modifyMenuItem(item);
    	System.out.println("Modified Item\n"+menuItemDao.getMenuItem(1).toString());
        
    }
    public static void testGetMenuItemListCustomer() {
    	MenuItemDaoSqlImpl menuCustomer=new MenuItemDaoSqlImpl();
    	List<MenuItem> customer=menuCustomer.getMenuItemListCustomer();
    	for(MenuItem m:customer) {
    		System.out.println(m.toString());
    	}
    }
}
