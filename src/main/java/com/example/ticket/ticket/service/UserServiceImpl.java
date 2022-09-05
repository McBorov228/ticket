package com.example.ticket.ticket.service;

import com.example.ticket.ticket.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> readAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User read(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Boolean update(User user, Long id) {
        try {
            User userOld = entityManager.find(User.class, id);
            userOld.setId(user.getId());
            userOld.setLogin(user.getLogin());
            userOld.setPassword(user.getPassword());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id) {
        User user = entityManager.find(User.class, id);
        try {
            entityManager.remove(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
