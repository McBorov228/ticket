package com.example.ticket.ticket.service;

import com.example.ticket.ticket.models.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class TicketServiceImpl implements TicketService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public List<Ticket> readAll() {
        return entityManager.createQuery("from Ticket", Ticket.class).getResultList();
    }

    @Override
    public Ticket read(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public Boolean update(Ticket ticket, Long id) {
        try {
            Ticket ticketOld = entityManager.find(Ticket.class, id);
            ticketOld.setDateRefund(ticket.getDateRefund());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        try {
            entityManager.remove(ticket);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
