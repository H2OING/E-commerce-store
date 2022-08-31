package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdP")
    @Setter(value = AccessLevel.NONE)
    private long idP;
	@Size(min = 2, max = 30, message = "Invalid input length for Product name")
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    @Size(min = 2, max = 60, message = "Invalid input length for Product description")
    private String description;
    @Column(name = "quantity")
    @Min(value = 1)
    @Max(value = 50)
    private int quantity;
    @Column(name = "price")
    @Min(value = 1)
    @Max(value = 5000)
    private BigDecimal price;
    @Column(name = "picture")
    private byte[] picture;
    
    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "IdP"),
            inverseJoinColumns = @JoinColumn(name = "IdCart"))
    private Collection<Cart> carts = new ArrayList<Cart>();
    
    //public void addCarts (Cart cart) {
    //	carts.add(cart);
    //}

    @ManyToOne
    @JoinColumn(name = "idCat")
    @Cascade(CascadeType.ALL)
    private Category category;
    
    public Product (String name,String description,int quantity,BigDecimal price,byte[] picture,Category category) {
    	this.name = name;
    	this.description = description;
    	this.quantity = quantity;
    	this.price = price;
    	this.picture = picture;
    	this.category = category;
    }
}
