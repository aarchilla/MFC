package com.example.figureCollection.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.figureCollection.model.entity.User;
import java.util.Optional;


public interface IUserDao extends CrudRepository<User, Long> {
    
    public Optional<User> findById(Long id);

    public Optional<User> findByUsername(String username);

}
