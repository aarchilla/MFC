package com.example.figureCollection.services;

import java.util.List;

import com.example.figureCollection.model.entity.Figure;

public interface IFigureService {

	public List<Figure> findAll();

	public Figure findById(Long id);
}
