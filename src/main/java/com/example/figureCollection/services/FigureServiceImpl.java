package com.example.figureCollection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.figureCollection.dao.IFigureDao;
import com.example.figureCollection.model.entity.Figure;

@Service
public class FigureServiceImpl implements IFigureService {

	@Autowired
	private IFigureDao figureDao;
	
	@Override
	public List<Figure> findAll() {
		return (List<Figure>) figureDao.findAll();
	}

	@Override
	public Figure findById(Long id) {
		return figureDao.findById(id).orElseThrow();
	}

	@Override
	public List<Figure> findAllOrderByCreateAtDesc() {
		return figureDao.findAllByOrderByCreateAtDesc();
	}

	@Override
	public List<Figure> findAllOrderByRelease() {
		return figureDao.findAllByOrderByReleaseDesc();
	}

	@Override
	@Transactional
	public void save(Figure figure) {
		figureDao.save(figure);

	}

	@Override
	public Figure saveAndFlush(Figure figure) {
		return figureDao.saveAndFlush(figure);
	}

	
	
}
