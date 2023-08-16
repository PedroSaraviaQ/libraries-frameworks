package com.example.spring.services;

import com.example.spring.models.Basic;
import com.example.spring.repositories.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//* This annotation tells Spring that this class is a service
@Service

public class BasicService {

    //* This is a dependency injection of the repository
    private final BasicRepository basicRepository;

    //* The constructor is used to inject the repository
    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    //* This method will return a list of all the elements in the database.
    //! The methods doesn't have to match in name, but it's a good practice.
    public List<Basic> findAll() {
        //* Just use the repository to find all the elements
        return basicRepository.findAll();
    }

    //* This method will save a new element in the database.
    public Basic save(Basic basic) {
        return basicRepository.save(basic);
    }

    //* This method will find an element by its id.
    public Basic findById(Integer id) {

        //* "Optional" is used to avoid null pointer exceptions.
        Optional<Basic> optionalBasic = basicRepository.findById(id);
        
        if (optionalBasic.isPresent()) {
            return optionalBasic.get();
        } else {
            return null;
        }
    }
}
