package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.cts.truyum.dao.MenuItemDao;
import com.cts.truyum.dao.MenuItemDaoCollectionImpl;
import com.cts.truyum.model.MenuItem;
import com.cts.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
     public static void main(String[] args) {
         System.out.println("Admin");
    	 testGetMenuItemListAdmin();
    	 System.out.println("Customer");
    	 testGetMenuItemListCustomer();
    	 System.out.println("Modified Item");
		 testModifyMenuItem();
	}
     public static void testGetMenuItemListAdmin() {
    	 MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
    	 List<MenuItem> admin= menuItemDao.getMenuItemListAdmin();
    	 for (MenuItem m:admin) {
			   System.out.println(m.toString());
		}
     }
     public static void testGetMenuItemListCustomer() {
    	MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
    	List<MenuItem> menulistforcus=menuItemDao.getMenuItemListCustomer();
    	for (MenuItem m:menulistforcus) {
			 System.out.println(m.toString());
		}
     }
     public static void testModifyMenuItem() {	 
    	 MenuItem menu;
		menu = new MenuItem(2, "Burger", 100.00f, true, DateUtil.convertToDate("13/05/2018"), "Main Course", true);
		MenuItemDaoCollectionImpl menuitem=new MenuItemDaoCollectionImpl();
		 MenuItemDao menuItemDao=menuitem;
		 menuItemDao.modifyMenuItem(menu);
		 menuitem.getMenuItem(menu.getId());
		 List<MenuItem> modified=menuitem.getMenuItemListAdmin();
		 for(MenuItem m: modified) {
			 System.out.println(m.toString());
		 }
    	 
    	 
     }
     
}
