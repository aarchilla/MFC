package com.example.figureCollection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.figureCollection.model.entity.Figure;
import com.example.figureCollection.services.IFigureService;

@Controller
public class FigureController {
	
	@Autowired
	private IFigureService figureService;
	
	@GetMapping(path="/figures/{id}")
	public String figure(@PathVariable Long id, Model model) {
		Figure figure = figureService.findById(id);
		model.addAttribute("figure", figure);
		return "figures/figure";
	}


	@GetMapping(path="/figures/")
	public String listFigures(@PathVariable Long id, Model model) {
		List<Figure> figures = figureService.findAllOrderByCreateAtDesc();
		model.addAttribute("figure", figures);
		return "figure/list";
	}
}
