package com.d288.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.HashSet;
import java.util.Date;
import java.util.Set;

/**
 Customer entity with individual customer details and cart history. Manages relationships with division and cart entities
 **/
@Entity
@Table(name="customers")
@Getter
@Setter
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name",nullable = false)
    private String lastName;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "postal_code",nullable = false)
    private String postal_code;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="division_id", nullable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;

    public void add(Cart cart) {

        if (cart != null) {

            if (carts == null) {
                carts = new HashSet<>();
            }

            carts.add(cart);
            cart.setCustomer(this);
        }
    }

}
