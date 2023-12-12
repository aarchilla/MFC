package com.example.figureCollection.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.figureCollection.model.entity.Image;

public interface IImageDao extends JpaRepository<Image, Long> {
    
}
