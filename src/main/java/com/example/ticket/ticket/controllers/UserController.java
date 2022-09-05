package com.example.ticket.ticket.controllers;

import com.example.ticket.ticket.models.User;
import com.example.ticket.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер пользователя
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Вставка пользователя
     */
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestParam("id") Integer id, @RequestParam("login") String login, @RequestParam("password") String password) {
        User user = new User(Long.valueOf(id), login, password);
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Получить всех пользователей
     */
    @GetMapping(value = "users")
    public ResponseEntity<List<User>> readAll() {
        final List<User> users = userService.readAll();
        return users != null && !users.isEmpty() ? new ResponseEntity<>(users, HttpStatus.OK) : new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
    }

    /**
     * Получить пользователя по id
     */
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name="id") Long id) {
        final User user = userService.read(id);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }

    /**
     * Обновить пользователя по id
     */
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") Long id, @RequestBody User userOld) {
        final boolean updateUser = userService.update(userOld ,id);
        return updateUser ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удалить пользователя по id
     */
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        Boolean answer = userService.delete(id);
        return answer ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
