package com.example.figureCollection.model.entity.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CharacterFranchiseKey implements Serializable {

	@Column(name="character_id")
	private Long characterId;
	
	@Column(name="franchise_id")
	private Long franchiseId;

	public Long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public Long getFranchiseId() {
		return franchiseId;
	}

	public void setFranchiseId(Long franchiseId) {
		this.franchiseId = franchiseId;
	}
	
	
	
}
