package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Blob;
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
    @NotNull
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
    @ToString.Exclude
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "idP"),
            inverseJoinColumns = @JoinColumn(name = "idCart"))
    private Collection<Cart> carts = new ArrayList<Cart>();
    @ManyToOne
    @JoinColumn(name = "idCat")
    private Category category;
}
