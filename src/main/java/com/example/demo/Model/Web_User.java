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
    @Column(name = "email")
    @Pattern (regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,10}$")
    @Size(min=5, max=30)
    @NotNull
    private String email;

    @Column(name = "password")
    @Pattern (regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    //atleast 1 capital letter, 1 number and 1 speacial character (Password must be atleast 8 character)
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
