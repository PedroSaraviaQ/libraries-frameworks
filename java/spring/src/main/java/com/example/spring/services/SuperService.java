package com.example.spring.services;

import com.example.spring.repositories.SuperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//* Also for services, we can create a super class to avoid repeating code.

//! The super class takes the @Service annotation though.
@Service

//* The class should be abstract, and will take a generic type as parameter.
public abstract class SuperService<T> {

    //* Every reference to the model is replaced by the generic type.
    private final SuperRepository<T> repository;

    public SuperService(SuperRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T save(T object) {
        return repository.save(object);
    }

    public T findById(Long id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
}
