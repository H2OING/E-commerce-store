package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdCat")
    @Setter(value = AccessLevel.NONE)
    @NotNull
    private long idCat;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products = new ArrayList<Product>();
}
