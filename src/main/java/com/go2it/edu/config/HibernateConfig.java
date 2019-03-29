package com.go2it.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Alex Ryzhkov
 */
@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:persistence.xml" })
public class HibernateConfig {
}
