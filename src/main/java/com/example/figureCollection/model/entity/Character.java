package com.example.figureCollection.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="characters")
public class Character implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "character")
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

	public List<CharacterFranchise> getCharacterFranchise() {
		return characterFranchise;
	}

	public void setCharacterFranchise(List<CharacterFranchise> characterFranchise) {
		this.characterFranchise = characterFranchise;
	}
	
	
	
}
