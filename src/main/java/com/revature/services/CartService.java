package com.revature.services;

import java.util.List;
import java.util.Optional;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Cart;
import com.revature.models.Item;
import com.revature.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    public List<Cart> findAll();

    public Cart findById(int id);

    public Cart addCart(Cart c);

    public Cart update(Cart c);

    public boolean delete(int id);

    public String checkOut();
}
