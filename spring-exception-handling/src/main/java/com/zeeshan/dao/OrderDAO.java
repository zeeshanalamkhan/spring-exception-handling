package com.zeeshan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeeshan.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

	public Order findByName(String name);

}
