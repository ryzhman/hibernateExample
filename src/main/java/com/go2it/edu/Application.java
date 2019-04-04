package com.go2it.edu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.entity.Payment;
import com.go2it.edu.service.ICustomerService;
import com.go2it.edu.service.IPaymentService;
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
			MerchantService merchantService = context.getBean(MerchantService.class);
			List<Merchant> list = 	merchantService.getSortedByNeedToPay();
			for (Merchant m: list) {
				System.out.println("name = " + m.getName() + ", sumToPay = " + m.getNeedToSend());
			}

			log.info("Application was ended successfully");
		} catch (Exception e) {
			log.error("Exception happened during the execution of the application. " + e);
		}
	}
}
