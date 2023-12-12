package com.example.figureCollection.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.figureCollection.model.entity.Release;

public interface IReleaseDao extends JpaRepository<Release, Long>{
    
}
