package com.go2it.edu;

import java.time.LocalDate;
import java.time.Month;

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
			Customer customer = new Customer();
			customer.setAddress("Independence st. 21, Malaga, Spain");
			customer.setCcNo("11122233344488");
			customer.setCcType("Master Card");
			customer.setEmail("vera@s.com");
			LocalDate dt = LocalDate.of(2018, Month.FEBRUARY, 28);
			customer.setMaturity(java.sql.Date.valueOf(dt));
			customer.setName("Vera Po");
			customerService.save(customer);
			int idForNewCustomer = customer.getId();
			System.out.println("id = " + idForNewCustomer);

			Customer foundById = customerService.findById(idForNewCustomer);
			System.out.println(foundById);

			log.info("Application was ended successfully");
		} catch (Exception e) {
			log.error("Exception happened during the execution of the application. " + e);
		}
	}
}
