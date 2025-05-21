package com.d288.demo.services;

import com.d288.demo.dao.CartItemRepository;
import com.d288.demo.dao.CartRepository;
import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.Customer;
import com.d288.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository,CartItemRepository cartItemRepository){
        this.customerRepository=customerRepository;
        this.cartRepository=cartRepository;
        this.cartItemRepository=cartItemRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve cart info from dto
        Cart cart=purchase.getCart();

        // generate tracking number
        String orderTrackingNumber=generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> item.setCart(cart));
        cartItems.forEach(item -> cart.add(item));

        //populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.addCart(cart);;

        //save to database
        cart.setStatus(StatusType.ordered);
        cartRepository.save(cart);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
