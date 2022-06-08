package com.revature.services;

import java.util.List;
import com.revature.models.Order;
import org.springframework.stereotype.Service;
@Service
public interface OrderService {

    public List<Order> findAll();

    public Order findById(int id);

    public Order addOrder(Order o);

    public boolean delete(int id);

    public String placeOrder();
}