package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDetail{
    private String orderDetailId;
    private Order order;
    private Product product;
    private int quantity;
    private int totalPrice;
}
