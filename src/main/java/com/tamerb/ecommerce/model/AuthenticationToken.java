package com.tamerb.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class AuthenticationToken {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String token;

    @Column(name = "created_date")
    private Date createdDate;


    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn( name = "user_id")
    private User user;



}
