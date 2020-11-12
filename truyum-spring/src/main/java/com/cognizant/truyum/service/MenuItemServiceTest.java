package com.cognizant.truyum.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.truyum.model.MenuItem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MenuItemServiceTest {
	private MenuItemService menuItemService;
	@Before
	public void initalizeService() {
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();*/
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService = (MenuItemService) context.getBean("menuItemService");
		
			
	}
	@Test
	public void testGetMenuItemListAdminSize() {
		
		assertTrue(menuItemService.getMenuItemListAdmin().size() == 5);
	}
	@Test
	public void testGetMenuItemListAdminContainsSandwich() {
		
		List<MenuItem> items = menuItemService.getMenuItemListAdmin();
		for (MenuItem item : items) {
		  if(item.getName().equals("Sandwitch")) {
			  assertEquals(1, item.getId());
			  //assertEquals(99.0, item.getPrice());
			  assertEquals(true, item.isActive());
			  assertEquals(true, item.isFreeDelivery());
		  }
			  
		 
		}
		
	}
	@Test
	public void testGetMenuItemListCustomerSize() {
		 assertTrue(menuItemService.getMenuItemListCustomer().size() == 3);
	}
	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {
		 List<MenuItem> customer = menuItemService.getMenuItemListCustomer();
		 for (MenuItem item : customer) {
			assertFalse(item.getName().equals("French Fries"));
		}
	}
	@Test
	public void testGetMenuItem() {
		MenuItem item = menuItemService.getMenuItem(1);
		assertTrue(item.getName().equals("Sandwitch") );
	}
	
		
	
}
