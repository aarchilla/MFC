package com.example.figureCollection.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.figureCollection.model.entity.Figure;
import com.example.figureCollection.model.entity.Image;
import com.example.figureCollection.model.entity.Release;
import com.example.figureCollection.services.ICharacterService;
import com.example.figureCollection.services.ICompanyService;
import com.example.figureCollection.services.IFigureService;
import com.example.figureCollection.services.IImageService;
import com.example.figureCollection.services.IReleaseService;

import jakarta.validation.Valid;


@Controller
public class FigureController {
	
	String PATH_IMG = "images/figures/";

	@Autowired
	private IFigureService figureService;

	@Autowired
	private ICompanyService companyService;
	
	@Autowired
	private ICharacterService characterService;
	
	@Autowired
	private IImageService imageService;

	@Autowired
	private IReleaseService releaseService;

	@GetMapping(path="/figures/{id}")
	public String figure(@PathVariable Long id, Model model) {
		Figure figure = figureService.findById(id);
		model.addAttribute("figure", figure);
		return "figures/figure";
	}

	@GetMapping(path="/figures")
	public String listFigures(Model model) {
		List<Figure> figures = figureService.findAllOrderByRelease();
		model.addAttribute("path", PATH_IMG);
		model.addAttribute("figures", figures);
		return "figures/list";
	}

	@GetMapping(path="/figures/create")
	public String create (Model model, RedirectAttributes flash) {
		model.addAttribute("listCompany", this.companyService.findAll());
		model.addAttribute("listCharacter", this.characterService.findAll());
		model.addAttribute("titulo", "Creación Figura");
		return "figures/create";
	}

	@PostMapping(path="/figures/create", consumes = {"multipart/form-data"})
	public String save(@Valid Figure figure, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status, 
		@RequestPart("files[]") List<MultipartFile> images, @RequestParam("price") Double price,
		@RequestParam("releaseDate") @DateTimeFormat(pattern= "yyyy-MM-dd") Date releaseDate ) {

		if (result.hasErrors()) {
			model.addAttribute("listCompany", this.companyService.findAll());
			model.addAttribute("listCharacter", this.characterService.findAll());
			model.addAttribute("titulo", "Creación Figura");
			return "figures/create";
		}
		figure = this.figureService.saveAndFlush(figure);
		Release release = new Release(releaseDate, price, figure);
		releaseService.save(release);

		for(MultipartFile file : images) {
			//String filePath = request.getServletContext().getRealPath("files/figures");
			Path resourceDirectory = Paths.get("src","main","resources", "static", "images","figures" ,figure.getId().toString() );
			Path resourceFile = Paths.get("src","main","resources", "static", "images","figures" ,figure.getId().toString(), file.getOriginalFilename());

			try {
				Files.createDirectories(resourceDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(resourceFile);
				Files.write(resourceFile, file.getBytes());
				Image image = new Image();
				image.setLink(file.getOriginalFilename());
				image.setFigure(figure);
				imageService.save(image);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		this.figureService.save(figure);
		return "figures/list";
	}
}
