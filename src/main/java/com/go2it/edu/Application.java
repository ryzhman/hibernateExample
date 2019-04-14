package com.go2it.edu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration(exclude= HibernateJpaAutoConfiguration.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
//	private static Logger log = LoggerFactory.getLogger(Application.class);
//
//	public static void main(String[] args) {
//		log.info("Application was stared");
//		try {
//			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//			log.info("Bean context is up");
//			IPaymentService paymentService = context.getBean(IPaymentService.class);
//
//			Merchant merchant = new Merchant();
//			merchant.setAccount("7777");
//			merchant.setBankName("Bank of Ametica");
//			merchant.setName("BikeProShop");
//			merchant.setCharge(1.55);
//			merchant.setMinSum(3000.92);
//			merchant.setSwift("ASDKWK@324");
//			merchant.setPeriod((short) 4);
//
//			Payment payment = new Payment();
//			payment.setGoods("XC Bicycle");
//			payment.setSumPaid(1500.00);
//			payment.setChargePaid(12.55);
//			payment.setPaymentDate(Date.valueOf(LocalDate.now()));
//
//			Customer newCustomer = new Customer();
//			newCustomer.setEmail("testUser@gmail.com");
//			newCustomer.setName("John Doe");
//			newCustomer.setAddress("12345 Yonge st, Toronto");
//			newCustomer.setCcNo("4444444444444448");
//			newCustomer.setCcType("MC");
//
//			//			newCustomer.setPayment(Collections.singletonList(payment));
//			payment.setCustomer(newCustomer);
//			payment.setMerchant(merchant);
//			paymentService.addNewPayment(payment);
//
//			log.info("Application was ended successfully");
//		} catch (Exception e) {
//			log.error("Exception happened during the execution of the application. " + e.getMessage());
//		}


//	}
//}
