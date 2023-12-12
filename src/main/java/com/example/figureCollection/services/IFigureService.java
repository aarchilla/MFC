package com.example.figureCollection.services;

import java.util.List;

import com.example.figureCollection.model.entity.Figure;

public interface IFigureService {

	public List<Figure> findAll();

	public Figure findById(Long id);

	public List<Figure> findAllOrderByCreateAtDesc();

	public List<Figure> findAllOrderByRelease();

	public void save(Figure figure);

	public Figure saveAndFlush(Figure figure);
}
