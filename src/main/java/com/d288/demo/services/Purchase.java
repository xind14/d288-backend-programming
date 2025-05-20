package com.d288.demo.services;

import com.d288.demo.entities.Cart;
import com.d288.demo.entities.Customer;
import com.d288.demo.entities.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
