package com.example.demo.Model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "Customer_Order")
@Entity
public class Customer_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "status")
    private Enum status;
    @Column(name = "ordered_date")
    private Date orderedDate;
    @Column(name = "shipped_date")
    private Date shippedDate;
    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
    @OneToOne(mappedBy = "order")
    private Bill bill;
}


