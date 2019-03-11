package com.zeeshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.exception.OrderServiceException;
import com.zeeshan.service.OrderService;

@RestController

public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping("/getPrice/{productName}")
	public String getOrderPrice(@PathVariable("productName") String productName) throws OrderServiceException {

		/*
		 * double amount = service.getPrice(productName); return "Amount for Product: "
		 * + productName + " is " + amount;
		 */
		try {
			double amount = service.getPrice(productName);
			return "Amount for Product: " + productName + " is " + amount;
		} catch (Exception e) {
			throw new OrderServiceException("order not found with productName: " + productName);
		}
	}
}
