package com.example.figureCollection.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="franchises")
public class Franchise implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@OneToMany(mappedBy = "franchise")
    List<CharacterFranchise> characterFranchise;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CharacterFranchise> getCharacterFranchise() {
		return characterFranchise;
	}

	public void setCharacterFranchise(List<CharacterFranchise> characterFranchise) {
		this.characterFranchise = characterFranchise;
	}
	
	
	
}
