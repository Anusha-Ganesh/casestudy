package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartServiceTest {
		private CartService cartService;
		@Before
		public void initalizeService() {
			/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.cognizant.truyum");
			context.refresh();*/
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
			//menuItemService = (MenuItemService) context.getBean("menuItemService");
			cartService = (CartService) context.getBean(CartService.class);
			
		}
		@Test
		public void testException() {
			assertTrue(true);
		}
}
