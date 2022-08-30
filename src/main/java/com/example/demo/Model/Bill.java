package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Bill")
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdBi")
    @Setter(value = AccessLevel.NONE)
    private long idBi;
    @Column(name = "payment_method")
    private Enum paymentMethod;
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "invoice_number")
    private long invoiceNumber;
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "idCO")
    private Customer_Order order;
}
