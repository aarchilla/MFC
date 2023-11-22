package com.example.figureCollection.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.figureCollection.model.entity.Figure;

public interface IFigureDao extends JpaRepository<Figure, Long>{

	List<Figure> findAllByOrderByCreateAtDesc();

    @Query("select figure f from Figure f inner join Release r order by r.releaseDate DESC")
    List<Figure> findAllByOrderByReleaseDesc();
}
