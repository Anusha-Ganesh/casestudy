package com.cts.truyum.dao;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {
     public static void main(String[] args) {
    	 testGetMenuItemListAdmin();
    	 testGetMenuItemListCustomer();
		 testModifyMenuItem();
	}
     public static void testGetMenuItemListAdmin() {
    	 MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
    	 List<MenuItem> admin= menuItemDao.getMenuItemListAdmin();
    	 for (MenuItem m:admin) {
			   m.toString();
		}
     }
     public static void testGetMenuItemListCustomer() {
    	MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
    	List<MenuItem> menulistforcus=menuItemDao.getMenuItemListCustomer();
    	for (MenuItem m:menulistforcus) {
			 m.toString();
		}
     }
     public static void testModifyMenuItem() {	 
    	 MenuItem menu=new MenuItem(2, "Burger", 100.00f, true, DateUtil.convertToDate("13/05/2018"), "Main Course", true);
    	 MenuItemDaoCollectionImpl menuitem=new MenuItemDaoCollectionImpl();
    	 menuitem.modifyMenuItem(menu);
    	 menuitem.getMenuItem(menu.getId());
    	 
     }
     
}
