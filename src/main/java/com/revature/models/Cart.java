package com.revature.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "carts", schema = "public")
@Data @AllArgsConstructor @NoArgsConstructor
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int item_id;
    private int user_id;
    private int total;
    private int item_quantity;

}
