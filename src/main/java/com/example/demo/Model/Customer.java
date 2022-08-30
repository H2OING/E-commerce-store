package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdCu")
    @Setter(value = AccessLevel.NONE)
    private long idCu;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    
    @OneToOne
    @JoinColumn(name = "web_user_id", referencedColumnName = "idUser")
    private Web_User webUser;
    @OneToOne(mappedBy = "customer")
    private Cart cart;
}
