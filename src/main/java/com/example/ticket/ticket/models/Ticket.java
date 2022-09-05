package com.example.ticket.ticket.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Реализация модели "Залоговый билет"
 */
@Data
@AllArgsConstructor
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {

    /**
     * Номер (id) залогового билета
     */
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    /**
     * Дата предоставления займа
     */
    @Column(name = "date_providing")
    private LocalDate dateProviding;

    /**
     * Дата возврата займа
     */
    @Column(name = "date_refund")
    private LocalDate dateRefund;

    /**
     * Заголовок билета
     */
    @Column(name = "title")
    private String title;

    /**
     * Описание билета
     */
    @Column(name = "description")
    private String description;

    /**
     * Цена
     */
    @Column(name = "price")
    private Double price;

    public Ticket() {
    }
}
