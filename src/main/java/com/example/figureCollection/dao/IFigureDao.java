package com.example.figureCollection.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.figureCollection.model.entity.Figure;

public interface IFigureDao extends CrudRepository<Figure, Long>{

	

}
