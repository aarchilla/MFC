package com.example.figureCollection.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.figureCollection.model.entity.Company;
import com.example.figureCollection.services.ICompanyService;

@RequestMapping("/company")
@Controller
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    String PATH_IMG = "images/company/";

    @GetMapping(path="/create")
	public String create (Model model, RedirectAttributes flash) {
		model.addAttribute("titulo", "Creación Company");
		return "company/create";
	}

    @PostMapping(path="/create", consumes = {"multipart/form-data"})
	public String save(Company company, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status, 
		@RequestPart("files") MultipartFile file ) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Creación Figura");
			return "company/create";
		}
        company.setLink(file.getOriginalFilename());
		company = this.companyService.save(company);

        Path resourceDirectory = Paths.get("src","main","resources", "images" ,"static","company" ,company.getId().toString() );
        Path resourceFile = Paths.get("src","main","resources", "static", "images","company" ,company.getId().toString(), file.getOriginalFilename());
        try {
            Files.createDirectories(resourceDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(resourceFile);
            Files.write(resourceFile, file.getBytes());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "redirect:/company/list";
	}


    @GetMapping(path="")
	public String listFigures(Model model) {
		List<Company> companyies = companyService.findAll();
        model.addAttribute("companyies", companyies);
		model.addAttribute("path", PATH_IMG);
		return "company/list";
	}
    
}
