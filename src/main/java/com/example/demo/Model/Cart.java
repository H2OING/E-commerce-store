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
    private long idCart;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "is_empty")
    private boolean isEmpty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "IdUser")
    private Web_User webUser;
    @OneToOne(mappedBy = "cart")
    private Customer_Order order;
    
    @ManyToMany(mappedBy = "carts")
    
    private Collection<Product> products = new ArrayList<Product>();
    
    public void addProducts(Product product) {
    	products.add(product);
    }
    
    public Cart (BigDecimal total, boolean isEmpty,Web_User webUser,Collection<Product> products) {
    	this.total = total;
    	this.isEmpty = isEmpty;
    	this.webUser = webUser;
    	this.products = products;
    	
    }

}
