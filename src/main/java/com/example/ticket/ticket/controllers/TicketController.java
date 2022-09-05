package com.example.ticket.ticket.controllers;

import com.example.ticket.ticket.models.Ticket;
import com.example.ticket.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Контроллер билета
 */
@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Вставка билета
     */
    @PostMapping(value = "/tickets")
    public ResponseEntity<?> create(@RequestParam("id") Integer id, @RequestParam("dateProviding") LocalDate dateProviding, @RequestParam("dateRefund") LocalDate dateRefund, @RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("price") Double price) {
        Ticket ticket = new Ticket(Long.valueOf(id), dateProviding, dateRefund, title, description, price);
        ticketService.create(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Получить все билеты
     */
    @GetMapping(value = "tickets")
    public ResponseEntity<List<Ticket>> readAll() {
        final List<Ticket> tickets = ticketService.readAll();
        return tickets != null && !tickets.isEmpty() ? new ResponseEntity<>(tickets, HttpStatus.OK) : new ResponseEntity<>(tickets, HttpStatus.NOT_FOUND);
    }

    /**
     * Получить билет по id
     */
    @GetMapping(value = "/tickets/{id}")
    public ResponseEntity<Ticket> read(@PathVariable(name="id") Long id) {
        final Ticket ticket = ticketService.read(id);
        return ticket != null ? new ResponseEntity<>(ticket, HttpStatus.OK) : new ResponseEntity<>(ticket, HttpStatus.NOT_FOUND);
    }

    /**
     * Обновить билет по id
     */
    @PutMapping(value = "/tickets/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") Long id, @RequestBody Ticket ticketOld) {
        final boolean updateTicket = ticketService.update(ticketOld, id);
        return updateTicket ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удалить билет по id
     */
    @DeleteMapping(value = "/tickets/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        Boolean answer = ticketService.delete(id);
        return answer ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
