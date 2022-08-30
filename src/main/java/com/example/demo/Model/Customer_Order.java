package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "Customer_Order")
@Entity
@RequiredArgsConstructor
public class Customer_Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdCO")
    @Setter(value = AccessLevel.NONE)
    @NotNull
    private long idCO;
    @Column(name = "status")
    private Order_Status status;
    @Column(name = "ordered_date")
    private Date orderedDate;
    @Column(name = "shipped_date")
    private Date shippedDate;
    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "idCart")
    private Cart cart;
    @OneToOne(mappedBy = "order")
    private Bill bill;
}


