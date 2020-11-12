package com.cts.truyum.dao;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cts.truyum.model.MenuItem;
import com.cts.truyum.util.DateUtil;
@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	
	private List<MenuItem> menuItems;
     public MenuItemDaoCollectionImpl() {
		super();
		
	}
   
	public  List<MenuItem> getMenuItems() {
		return menuItems;
	}
	  @Autowired
	public  void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
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