package com.go2it.edu;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.entity.Payment;
import com.go2it.edu.service.IMerchantService;

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
			IMerchantService merchantService = context.getBean(IMerchantService.class);
			List<Merchant> list = merchantService.getSortedByNeedToPay();
			for (Merchant m : list) {
				System.out.println("=======================");
				System.out.println(m.getName());

				System.out.println("  ");
				Collection<Payment> payments = m.getPayments();
				for (Payment p : payments) {
					System.out.println(p.toString());
				}
			}

			log.info("Application was ended successfully");
		} catch (Exception e)

		{
			log.error("Exception happened during the execution of the application. " + e);
		}
	}
}
