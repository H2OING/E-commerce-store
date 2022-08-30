package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Cart")
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdCart")
    @Setter(value = AccessLevel.NONE)
    @NotNull
    private long idCart;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "is_empty")
    private boolean isEmpty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "idCu")
    private Customer customer;
    @OneToOne(mappedBy = "cart")
    private Customer_Order order;
    @ManyToMany(mappedBy = "carts")
    private Collection<Product> products = new ArrayList<Product>();
    
    public void addProducts(Product product) {
    	products.add(product);
    }
}
