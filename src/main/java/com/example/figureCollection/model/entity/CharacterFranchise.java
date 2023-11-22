package com.example.figureCollection.model.entity;

import com.example.figureCollection.model.entity.keys.CharacterFranchiseKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;

@Entity
public class CharacterFranchise {

	@EmbeddedId
	CharacterFranchiseKey id;
	
    @ManyToOne
    @MapsId("characterId")
    @JoinColumn(name = "character_id")
    Character character;
    
    @ManyToOne
    @MapsId("franchiseId")
    @JoinColumn(name = "franchise_id")
    Franchise franchise;
    
    @NotNull
    private String rol;

	public CharacterFranchiseKey getId() {
		return id;
	}

	public void setId(CharacterFranchiseKey id) {
		this.id = id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Franchise getFranchise() {
		return franchise;
	}

	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
    
    
    
}
