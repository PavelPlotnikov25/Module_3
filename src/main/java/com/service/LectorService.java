package com.service;

import com.model.Lector;
import com.repository.lector.LectorRepository;

import java.util.List;

public class LectorService {

    private static LectorService instance;
    private LectorRepository repository;

    public LectorService(LectorRepository repository) {
        this.repository = repository;
    }

    public static LectorService getInstance(){
        if (instance == null){
            instance = new LectorService(LectorRepository.getInstance());
        }
        return instance;
    }

    public List<Lector> findLectorByName(String name){
        return repository.findLectorByName(name);
    }
}
