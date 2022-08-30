package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull
    private long idCu;
    @Column(name = "name")
    @NotNull
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for name")
	@Size(min = 2, max = 30 ,message = "Invalid input length for name")
    private String name;
    @Column(name = "surname")
    @NotNull
	@Pattern(regexp = "[A-ZŽĶĻŅČĢŠĪĀĒŪ]{1}[a-zžšķļņģčīāūē\\s]+", message = "Invalid input for surname")
	@Size(min = 2, max = 30 ,message = "Invalid input length for surname")
    private String surname;
    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;
    @Column(name = "address")
    @NotNull
    private String address;
    @OneToOne
    @JoinColumn(name = "web_user_id", referencedColumnName = "idUser")
    private Web_User webUser;
    @OneToOne(mappedBy = "customer")
    private Cart cart;
}
