package com.example.ticket.ticket.service;

import com.example.ticket.ticket.models.Ticket;

import java.util.List;

/**
 * Операции билетов
 */
public interface TicketService {

    /**
     * Создание нового билета
     * @param ticket - билет
     */
    void create(Ticket ticket);

    /**
     * Получить все билеты
     * @return
     */
    List<Ticket> readAll();

    /**
     * Получить билет по id
     * @param id - идентификатор
     */
    Ticket read(Long id);

    /**
     * Обновить билет по id
     * @param id - идентификатор
     * @param ticket - билет
     */
    Boolean update(Ticket ticket, Long id);

    /**
     * Удалить билет по id
     * @param id - идентификатор
     */
    Boolean delete(Long id);

}
