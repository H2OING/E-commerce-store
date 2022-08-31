package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "role")
    @NotNull
    private Role role;
    @OneToOne(mappedBy = "webUser")
  //  @Cascade(CascadeType.ALL)
    private Customer customer;
    
    public Web_User (String email,String password,Role role) {
    	this.email = email;
    	this.password = password;
    	this.role = role;
    }
}
