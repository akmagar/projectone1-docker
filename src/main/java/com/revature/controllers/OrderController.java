package com.revature.controllers;

import java.util.List;
import com.revature.models.*;
import com.revature.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.annotations.Authorized;
import com.revature.services.AuthorizationService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthorizationService authorizationService;

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE})
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE})
    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @Authorized(allowedRoles = {Role.CUSTOMER})
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order o) {
        return ResponseEntity.accepted().body(orderService.addOrder(o));
    }

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE, Role.CUSTOMER})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if(orderService.delete(id)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.noContent().build();
    }

}
