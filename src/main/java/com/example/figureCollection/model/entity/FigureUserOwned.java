package com.example.figureCollection.model.entity;

import java.util.Date;
import com.example.figureCollection.model.entity.keys.FigureUserKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;


@Entity
public class FigureUserOwned {
    
    @EmbeddedId
	FigureUserKey id;
	
    @ManyToOne
    @MapsId("figureId")
    @JoinColumn(name = "figure_id")
    Figure figure;
    
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @NotNull
    private Date ownedDate;

    private int Score;

    private String shop;

    public FigureUserKey getId() {
        return id;
    }

    public void setId(FigureUserKey id) {
        this.id = id;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOwnedDate() {
        return ownedDate;
    }

    public void setOwnedDate(Date ownedDate) {
        this.ownedDate = ownedDate;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    
}
