package com.orders.Orders.repository;

import com.orders.Orders.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
