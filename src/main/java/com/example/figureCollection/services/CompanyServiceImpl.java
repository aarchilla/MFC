package com.example.figureCollection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.figureCollection.dao.ICompanyDao;
import com.example.figureCollection.model.entity.Company;

@Service
public class CompanyServiceImpl implements ICompanyService{

    @Autowired
    private ICompanyDao companyDao;

    @Override
    public List<Company> findAll() {
        return this.companyDao.findAll();
    }

    @Override
    public Company save(Company company) {
        return this.companyDao.saveAndFlush(company);
    }
    
    
}
