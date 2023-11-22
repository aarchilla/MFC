package com.example.figureCollection.model.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="figures")
public class Figure implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="company_id")
	private Company company;
	
	@OneToMany(mappedBy = "figure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Release> releases;
	
	@OneToMany(mappedBy = "figure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Image> images;

	@NotNull
	private int height;

	private String scale;

	@ManyToMany
	@JoinTable(
			name="figure_character",
			joinColumns=
            	@JoinColumn(name="figure_id", referencedColumnName="id"),
            inverseJoinColumns=
            	@JoinColumn(name="character_id", referencedColumnName="id"))
	List<Character> characterList;

	@OneToMany(mappedBy = "figure")
	private List<FigureUserOwned> listFiguresOwned;

	@ManyToMany
	@JoinTable(
			name="figure_user_like",
			joinColumns=
            	@JoinColumn(name="figure_id", referencedColumnName="id"),
            inverseJoinColumns=
            	@JoinColumn(name="user_id", referencedColumnName="id"))
	List<User> listFigureLiked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public List<Character> getCharacterList() {
		return characterList;
	}

	public void setCharacterList(List<Character> characterList) {
		this.characterList = characterList;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public List<FigureUserOwned> getListFiguresOwned() {
		return listFiguresOwned;
	}

	public void setListFiguresOwned(List<FigureUserOwned> listFiguresOwned) {
		this.listFiguresOwned = listFiguresOwned;
	}

	public List<User> getListFigureLiked() {
		return listFigureLiked;
	}

	public void setListFigureLiked(List<User> listFigureLiked) {
		this.listFigureLiked = listFigureLiked;
	}

	
	
}
