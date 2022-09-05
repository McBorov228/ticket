package com.example.ticket.ticket.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Реализация модели "Пользователь"
 */
@Data
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "user")
public class User {

    /**
     * id пользователя
     */
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    /**
     * Логин пользователя
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    private String password;

    public User() {
    }
}
