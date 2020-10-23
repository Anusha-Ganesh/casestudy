package com.cts.truyum.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem> menuItems;
     public MenuItemDaoCollectionImpl() {
		super();
		if(menuItems.isEmpty()) {
			menuItems.add(new MenuItem(1, "Sandwitch", 90.00f,true,new DateUtil().convertToDate("15/03/2017") , "Main Course", true));
			menuItems.add(new MenuItem(2, "Burger", 129.00f,true,new DateUtil().convertToDate("23/12/2017") , "Main Course", false));
			menuItems.add(new MenuItem(3, "Pizza", 149.00f,true,new DateUtil().convertToDate("21/08/2018") , "Main Course", false));
			menuItems.add(new MenuItem(4, "French Fries", 57.00f,false,new DateUtil().convertToDate("02/07/2017") , "Starters", true));
			menuItems.add(new MenuItem(5, "Chocolate Brownie", 32.00f,true,new DateUtil().convertToDate("02/11/2022") , "Dessert", true));
		}
	}
     

	public static List<MenuItem> getMenuItems() {
		return menuItems;
	}


	public static void setMenuItems(List<MenuItem> menuItems) {
		MenuItemDaoCollectionImpl.menuItems = menuItems;
	}


	public List<MenuItem> getMenuItemListAdmin() {
	      return menuItems;	
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> mlst=null;
		for (MenuItem m:menuItems) {
		    if(m.getDateOfLaunch().until(LocalDateTime.now(), ChronoUnit.MINUTES)>0 && m.isActive())
		    		 		mlst.add(m);
				}
		    	 return mlst;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		// TODO Auto-generated method stub
		for (MenuItem m: menuItems) {
		    if(m.equals(menuItem))	
		    	menuItems.add(menuItem);
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		MenuItem item=null;
		for (MenuItem m:menuItems) {
			if(m.getId()==menuItemId)
				item=m;
		}
		return item;
	}
}
