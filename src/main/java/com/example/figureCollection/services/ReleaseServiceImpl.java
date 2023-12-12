package com.example.figureCollection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.figureCollection.dao.IReleaseDao;
import com.example.figureCollection.model.entity.Release;

@Service
public class ReleaseServiceImpl implements IReleaseService {

    @Autowired
    private IReleaseDao releaseDao;

    @Override
    public void save(Release release) {
        releaseDao.save(release);
    }
    
}


