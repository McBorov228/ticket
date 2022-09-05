package com.example.ticket.ticket.service;

import com.example.ticket.ticket.models.User;

import java.util.List;

/**
 * Операции пользователя
 */
public interface UserService {

    /**
     * Создание нового пользователя
     * @param user - пользователь
     */
    void create(User user);

    /**
     * Получить всех пользователей
     * @return
     */
    List<User> readAll();

    /**
     * Получить пользователя по id
     * @param id - идентификатор
     */
    User read(Long id);

    /**
     * Обновить пользователя по id
     * @param id - идентификатор
     * @param user - пользователь
     */
    Boolean update(User user, Long id);

    /**
     * Удалить пользователя по id
     * @param id - идентификатор
     */
    Boolean delete(Long id);

}
