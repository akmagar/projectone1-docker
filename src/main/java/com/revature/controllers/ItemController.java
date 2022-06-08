package com.revature.controllers;

import java.util.List;
import com.revature.models.Item;
import com.revature.services.ItemService;
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
import com.revature.models.Role;
import com.revature.services.AuthorizationService;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE})
    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item i) {
        return ResponseEntity.accepted().body(itemService.addItem(i));
    }

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE})
    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item i) {
        return ResponseEntity.accepted().body(itemService.update(i));
    }

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if(itemService.delete(id)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.noContent().build();
    }
}
