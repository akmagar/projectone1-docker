package com.revature.repositories;

import com.revature.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    public Optional<Item> findByItemName(String itemName);
}
