package com.example.figureCollection.services;

import java.util.List;

import com.example.figureCollection.model.entity.Company;

public interface ICompanyService {
    
    public List<Company> findAll();

    public Company save(Company company);
}
