package com.cts.truyum.dao;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.truyum.util.DateUtil;
import com.cts.tryyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem> menuItems;
     public MenuItemDaoCollectionImpl() {
		super();
		if(menuItems==null) {
			menuItems=new ArrayList<MenuItem>();
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
		List<MenuItem> mlst=new ArrayList<MenuItem>();
		Date thisDay=new Date();
		for (MenuItem m:menuItems)
		{
		    if(m.getDateOfLaunch().getTime()<=thisDay.getTime() && m.isActive())
		    		 		mlst.add(m);
		}
		    	 return mlst;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		
		// TODO Auto-generated method stub
		System.out.println("\n");
		for (MenuItem m: menuItems) {
		    if(m.getId()==menuItem.getId()) {
		    	m.setName(menuItem.getName());
		    	m.setPrice(menuItem.getPrice());
		    	m.setActive(menuItem.isActive());
		    	m.setDateOfLaunch(menuItem.getDateOfLaunch());
		    	m.setCategory(menuItem.getCategory());
		    	m.setFreeDelivery(menuItem.isFreeDelivery());
		    	System.out.println(m.toString());
		    }
		    	
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		MenuItem item=null;
		//System.out.println("\n");
		for (MenuItem m:menuItems) {
			if(m.getId()==menuItemId)
				item=m;
		}
		return item;
	}
}
