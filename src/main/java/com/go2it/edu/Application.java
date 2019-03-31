package com.go2it.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.go2it.edu.entity.Customer;
import com.go2it.edu.service.ICustomerService;

/**
 * @author Alex Ryzhkov
 */
public class Application {
	private static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		log.info("Application was stared");

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			log.info("Bean context is up");

			ICustomerService customerService = context.getBean(ICustomerService.class);
			boolean result = customerService.updateCcNo(3, "66666666666666");
			System.out.println("Update finished. Result is - " + result);

			Customer foundById = customerService.findById(3);
			System.out.println(foundById);

			log.info("Application was ended successfully");
		} catch (Exception e) {
			log.error("Exception happened during the execution of the application. " + e);
		}
	}
}
