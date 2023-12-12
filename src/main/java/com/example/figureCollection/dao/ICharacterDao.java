package com.example.figureCollection.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacterDao extends JpaRepository<com.example.figureCollection.model.entity.Character, Long> {
    
    public List<com.example.figureCollection.model.entity.Character> findAll();
}
