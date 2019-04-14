package com.go2it.edu.controller;

import com.github.openjson.JSONObject;
import com.go2it.edu.entity.Customer;
import com.go2it.edu.service.CustomerService;
import com.go2it.edu.service.ICustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController

public class HelloWorldController {
    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping("/new/")
    public String index() {
        return "<div style=\"text-align:center;\">"
                + "<h1>Hello world</h1>" +
                "<p> This is my first web-page </p>" +
                "<img src=https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg></img>"
                + "</div>";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String getHelloWorldMessageForUser(@RequestParam String name) {
    public String getHelloWorldMessageForUser(@RequestParam(required = false) String name) {
        return "<div style=\"text-align:center;\">" + "<h1>Welcome, " + name + "</h1>"
                + "<p> This is my first web-page </p>" + "</div>";
    }

    @RequestMapping(value = "/customizedWelcome", method = RequestMethod.POST)
    public String getHelloWorldWithFromJSON(@RequestBody String message) {
        JSONObject json = new JSONObject(message);
        String firstName = "Albert";
        String defaultPictureAddress = "https://cdn-images-1.medium.com/fit/t/1600/672/0*n-2bW82Z6m6U2bij.jpeg";
        String firstNameFromRequest = json.getString("firstName");
        if (StringUtils.isNotBlank(firstNameFromRequest)) {
            firstName = firstNameFromRequest;
        }
        String pictureURLFromRequest = json.getString("pictureURL");
        if (StringUtils.isNotBlank(pictureURLFromRequest)) {
            defaultPictureAddress = pictureURLFromRequest;
        }
        return "<div style=\"text-align:center;\">" + "<h1>Hello world from " + firstName + "</h1>"
                + "<p> This is my first web-page </p>" + "<img src=" + defaultPictureAddress + "></img>"
                + "</div>";
    }

    @RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
    public String getNewCustomerWithFromJSON(@RequestBody String message) {
        JSONObject jsonNewCostomer = new JSONObject(message);
        String surName = "Ivanov";
        String typeofhuman = "Null";
        String givenName = "Ivanov";

        String surNameFromRequest = jsonNewCostomer.getString("surname");
        if (StringUtils.isNotBlank(surNameFromRequest)) {
            surName = surNameFromRequest;
        }
        String givenNameFromRequest = jsonNewCostomer.getString("givenname");
        if (StringUtils.isNotBlank(givenNameFromRequest)) {
            givenName = givenNameFromRequest;
        }
        String typeofhumanFromRequest = jsonNewCostomer.getString("typeofhuman");
        if (StringUtils.isNotBlank(typeofhumanFromRequest)) {
            typeofhuman = typeofhumanFromRequest;
        }

        Customer savenewCustomer = new Customer();
//        savenewCustomer.setName(surName);
        savenewCustomer.setName(surName+" "+givenName);
        savenewCustomer.setCcType(typeofhuman);
        iCustomerService.save(savenewCustomer);


        return "<div style=\"text-align:center;\">" + "<h1> Get the Name" + surName + "</h1>"
                + "<p> This is my first web-page </p>" + "<img src=" + givenName + "></img>"
                + "</div>";
    }

    @RequestMapping(value = "/{resource}", method = RequestMethod.GET)
    public String getHelloWorldMessageFromResource(@PathVariable String resource) {
        return "<div style=\"text-align:center;\">" + "<h1>This request was done to the resource: " + resource
                + "</h1>" + "</div>";
    }

}