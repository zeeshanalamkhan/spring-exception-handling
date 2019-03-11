package com.zeeshan.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeeshan.dao.OrderDAO;
import com.zeeshan.exception.OrderServiceException;
import com.zeeshan.model.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDAO dao;

	@PostConstruct
	public void addOrder2DB() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(876, "Mobile", "Electronics", 8000));
		orders.add(new Order(806, "Bike", "Vehicle", 90000));
		dao.saveAll(orders);
	}

	public double getPrice(String productName) throws OrderServiceException {

		Order order = null;
		double amount = 0;
		try {
			order = dao.findByName(productName);
			amount = order.getAmount();
		} catch (Exception e) {
			throw new OrderServiceException("order not found with productName: " + order.getName());
		}
		return amount;
	}
}
