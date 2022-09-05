package com.example.ticket.ticket.repo;

import com.example.ticket.ticket.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
