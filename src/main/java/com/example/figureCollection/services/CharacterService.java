package com.example.figureCollection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.figureCollection.dao.ICharacterDao;
import com.example.figureCollection.model.entity.Character;

@Service
public class CharacterService implements ICharacterService{

    @Autowired
    private ICharacterDao characterDao;

    @Override
    public List<Character> findAll() {
        return characterDao.findAll();
    }
    
}
