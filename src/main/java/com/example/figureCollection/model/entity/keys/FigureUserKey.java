package com.example.figureCollection.model.entity.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FigureUserKey implements Serializable {
    
    @Column(name="figure_id")
	private Long figureId;
	
	@Column(name="user_id")
	private Long userId;

    public Long getFigureId() {
        return figureId;
    }

    public void setFigureId(Long figureId) {
        this.figureId = figureId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
