package com.example.ticket.ticket.repo;

import com.example.ticket.ticket.models.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
