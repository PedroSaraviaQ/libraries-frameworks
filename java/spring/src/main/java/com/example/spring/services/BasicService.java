package com.example.spring.services;

import com.example.spring.models.Basic;
import com.example.spring.repositories.BasicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//* They should be classes, and stored in the "services" package.

//* Services implement the business logic of the application and create
//* their own methods using those provided by the repository.

//* Tells Spring that it's a service
@Service

public class BasicService {

    //* To use the methods from the repository.
    private final BasicRepository basicRepository;

    //* The constructor ensures that the repository is assigned a value and is not null.
    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    //* To avoid creating a constructor, use "@Autowired" for the field.
    //! You can't use "final" though.
    // @Autowired private BasicRepository basicRepository;

    //* This will return a list of all the elements in the database.
    //! The methods don't have to match in name, but it's a good practice.
    public List<Basic> findAll() {
        //* Just use the repository to find all the elements.
        return basicRepository.findAll();
    }

    public Basic save(Basic basic) {
        //* Saves a new element in the database.
        return basicRepository.save(basic);
    }

    public Basic findById(Integer id) {
        //* Finds an element by its id.
        Optional<Basic> optionalBasic = basicRepository.findById(id);

        //* This code is used to return the element, or null if it's not found.
        if (optionalBasic.isPresent()) {
            return optionalBasic.get();
        } else {
            return null;
        }
    }

    public Basic update(Basic basic) {
        //* The "save" method can also be used to update an element.
        return basicRepository.save(basic);
    }

    public void deleteById(Integer id) {
        //* Deletes with the id.
        basicRepository.deleteById(id);
    }
}
