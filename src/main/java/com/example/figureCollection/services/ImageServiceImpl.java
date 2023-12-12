package com.example.figureCollection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.figureCollection.dao.IImageDao;
import com.example.figureCollection.model.entity.Image;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private IImageDao imageDao;

    @Override
    public void save(Image image) {
        imageDao.save(image);
    }
    
}
