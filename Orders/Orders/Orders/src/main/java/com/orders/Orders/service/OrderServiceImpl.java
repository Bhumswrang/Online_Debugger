package com.orders.Orders.service;

import com.orders.Orders.entity.Coupon;
import com.orders.Orders.entity.Order;
import com.orders.Orders.entity.Pizza;
import com.orders.Orders.entity.User;
import com.orders.Orders.exception.NullValueException;
import com.orders.Orders.exception.OrderNotFoundException;
import com.orders.Orders.exception.OrderWithIdAlreadyExistException;
import com.orders.Orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public Order getOrderById(Long oid) {
        if(orderRepository.existsById(oid))
        {

        Optional<Order> order = orderRepository.findById(oid);
        return order.get();
        }
        else{
            return null;
        }
        //return orderRepository.findById(oid).orElseThrow(()->new OrderNotFoundException());
    }

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String addOrder(Order order) {

        Optional<Order> o = orderRepository.findById(order.getOid());
        if (o.isPresent()){
            throw new OrderWithIdAlreadyExistException();
        }
        Pizza pizza = null;
        User user =null;

            pizza = this.restTemplate.getForObject("http://localhost:8086/pizza/pizzas/" + order.getPid(), Pizza.class);
            user = this.restTemplate.getForObject("http://localhost:8083/user/users/" + order.getUid(), User.class);


        if(pizza==null || user==null)
            throw new NullValueException();

        if(pizza!=null && user!=null){
            order.setDate(LocalDate.now());
            order.setTime(LocalTime.now());
            order.setPid(pizza.getPid());
            order.setP_name(pizza.getP_name());
            order.setPrice(pizza.getPrice());
            order.setUid(user.getUid());
            order.setU_name(user.getU_name());
            order.setPhone(user.getPhone());
//            if(coupon!=null){
//                order.setOffer(coupon.getOffer());
//            }
//            else{
//                order.setOffer(0);
//            }
            orderRepository.save(order);
            return "Added the Order Details Successfully";
        }
        else {
            return "Invalid";
        }




    }

    @Override
    public String deleteOrder(Long oid) {
        Optional<Order> order = orderRepository.findById(oid);
        if(order.isPresent()){
            orderRepository.delete(order.get());
            return "Order Item Deleted";
        }
        else throw new OrderNotFoundException();
    }

}
