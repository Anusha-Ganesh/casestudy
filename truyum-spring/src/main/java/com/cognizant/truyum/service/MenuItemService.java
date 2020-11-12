package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import com.cts.truyum.dao.MenuItemDao;
import com.cts.truyum.model.MenuItem;
@Service(value = "menuItemService")
public class MenuItemService {
	
   private MenuItemDao menuItemDao;
   @Autowired
   public void setMenuItemDao( MenuItemDao menuItemDao) {
	   //ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config");
	  this. menuItemDao =menuItemDao;
	   
	   
   }
   
   public MenuItemDao getMenuItemDao() {
	return menuItemDao;
}

public List<MenuItem> getMenuItemListAdmin(){
	   List<MenuItem> menuListsAdmin = menuItemDao.getMenuItemListAdmin();
	   return menuListsAdmin;
   }
   public List<MenuItem> getMenuItemListCustomer(){
	   return menuItemDao.getMenuItemListCustomer();
	   
   }
   public MenuItem getMenuItem( long menuItemId) {
	   return menuItemDao.getMenuItem(menuItemId);
	   
   }
  // public void editMenuItem( MenuItem menutItem) {
	//     
  // }
   public void modifyMenuItem(MenuItem menuItem ) {
	   menuItemDao.modifyMenuItem(menuItem);
   }

}