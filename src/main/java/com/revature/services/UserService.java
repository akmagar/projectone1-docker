package com.revature.services;

import org.springframework.stereotype.Service;
import com.revature.models.User;
import java.util.List;

@Service
public interface UserService {

    public List<User> findAll();

    public User findById(int id);

    public User registerUser(User u);

    public User update(User u);

    public boolean delete(int id);

    public User login(String username, String password);

    public void logout();
}
