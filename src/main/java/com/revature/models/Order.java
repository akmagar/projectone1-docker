package com.revature.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders", schema = "public")
@Data @AllArgsConstructor @NoArgsConstructor
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private int user_id;
    private String shippingAddress;
    private int total;
    private int item_quantity;


}
