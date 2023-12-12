package com.example.figureCollection.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.figureCollection.model.entity.Company;

public interface ICompanyDao extends JpaRepository<Company, Long> {
    
    public List<Company> findAll();
}
