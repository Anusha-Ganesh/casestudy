package com.cognizant.truyum;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.truyum.dao.MenuItemDao;
import com.cts.truyum.dao.MenuItemDaoCollectionImpl;
import com.cts.truyum.model.MenuItem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        List<MenuItem> menuItems = (List<MenuItem>) ctx.getBean("menuItems");
        //List<MenuItem> items = menuItems.getMenuItems();
        for (MenuItem menuItem : menuItems) {
        	System.out.println(menuItem.toString());
			
		}
    }
}
