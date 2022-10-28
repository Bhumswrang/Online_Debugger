package com.orders.Orders.service;

import com.orders.Orders.entity.Coupon;
import com.orders.Orders.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order getOrderById(Long oid);
    public String addOrder(Order order);
    public String deleteOrder(Long oid);

}
