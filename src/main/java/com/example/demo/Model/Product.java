package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Set;

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
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "picture")
    private Blob picture;
    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "idP"),
            inverseJoinColumns = @JoinColumn(name = "idCart"))
    Set<Cart> carts;
    @ManyToOne
    @JoinColumn(name = "idCat")
    Category category;
}
