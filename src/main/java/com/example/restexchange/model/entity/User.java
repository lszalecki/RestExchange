package com.example.restexchange.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Getter
    @Setter
    private Long id;

    @Column(name="name",nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name="last_name", nullable = false)
    @Getter
    @Setter
    private String lastName;

    @Column(name="email")
    @Getter
    @Setter
    private String email;

    @Column(name="account_balance")
    @Getter
    @Setter
    private BigDecimal accountBalance;
}
