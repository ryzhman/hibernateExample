package com.go2it.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.service.MerchantService;

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
			log.debug("Hello");
			MerchantService merchantService = context.getBean(MerchantService.class);
			Merchant m1 = merchantService.findById(1);
			System.out.println("name = " + m1.getName());

			log.info("Application was ended successfully");
			throw new RuntimeException("Test exception for logging purposes");
		} catch (Exception e) {
			log.error("Exception happened during the execution of the application. " + e);
		}
	}
}
