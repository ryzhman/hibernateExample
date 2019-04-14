package com.go2it.edu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.openjson.JSONObject;
import com.go2it.edu.entity.Customer;
import com.go2it.edu.service.ICustomerService;

/**
 * @author Alex Ryzhkov
 */
@RestController("/api")
public class CustomerController {
	@Autowired private ICustomerService iCustomerService;

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public String createNewCustomer(@RequestBody String jsonWithCustomer) throws ParseException {
		JSONObject jsonNewCustomer = new JSONObject(jsonWithCustomer);

		String name = jsonNewCustomer.getString("name");
		String ccNumber = jsonNewCustomer.getString("ccNumber");
		String email = jsonNewCustomer.getString("expDate");
		String ccExpDate = jsonNewCustomer.getString("ccExpDate");
		String ccType = jsonNewCustomer.getString("ccType");
		String address = jsonNewCustomer.getString("address");
		if (StringUtils.isBlank(name) || StringUtils.isBlank(ccNumber) || StringUtils.length(ccNumber) != 16
				|| StringUtils.isBlank(email) || StringUtils.isBlank(ccExpDate)
				|| StringUtils.length(ccExpDate) != 4 || StringUtils.isNotEmpty(ccType)
				|| StringUtils.isNotEmpty(address) || StringUtils.isNotEmpty(address)) {
			throw new IllegalArgumentException(
					"Couldn't parse a JSON from the request. JSON: " + jsonWithCustomer);
		}
		Customer customerToStore = new Customer();
		customerToStore.setName(name);
		customerToStore.setCcNo(ccNumber);
		customerToStore.setEmail(email);
		customerToStore.setAddress(address);
		customerToStore.setCcType(ccType);

		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date date = sdf1.parse(ccExpDate);
		customerToStore.setExpDate(new java.sql.Date(date.getTime()));
		Customer savedCustomer = iCustomerService.save(customerToStore);

		String resultMessage = savedCustomer != null ? "success" : "failure";

		return "<div style=\"text-align:center;\">" + "<h1> New customer was stored: " + resultMessage
				+ " </h1></div>";
	}
}
