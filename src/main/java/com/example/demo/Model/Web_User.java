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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Web_User")
@Entity
public class Web_User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="IdUser")
    @Setter(value = AccessLevel.NONE)
    private long idUser;
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
    @Column(name = "email", unique = true)
    @NotNull
    private String email;
    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;
    @Column(name = "address")
    @NotNull
    private String address;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "role")
    @NotNull
    private Role role;
    @OneToOne(mappedBy = "webUser")
    private Cart cart;

    public Web_User (String name, String surname, String email, String phoneNumber, String address, String password, Role role) {
        this.name = name;
        this.surname = surname;
    	this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    	this.password = password;
    	this.role = role;
    }
}
