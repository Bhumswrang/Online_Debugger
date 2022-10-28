package com.orders.Orders.controller;

import com.orders.Orders.entity.Coupon;
import com.orders.Orders.entity.Order;
import com.orders.Orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("")
    public String home(){
        return "This is Order API newOne";
    }

    @RequestMapping("/order/orders")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }


    @RequestMapping("/order/orders/{oid}")
    public Order getOrderById(@PathVariable Long oid){
        return this.orderService.getOrderById(oid);
    }

    @RequestMapping(value = "/order/orders" , method = RequestMethod.POST)
    public String addOrder(@RequestBody Order order){
        return this.orderService.addOrder(order);
    }
    @RequestMapping(value = "/order/orders/{oid}",method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable Long oid){
        return this.orderService.deleteOrder(oid);
    }
}
