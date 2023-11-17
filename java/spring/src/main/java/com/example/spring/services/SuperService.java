package com.example.spring.services;

import com.example.spring.repositories.SuperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//* The super service will be for abstracting the logic of the default methods.

//! The super class does actually take the @Service annotation.
@Service

//* The class is abstract like the super model, and also takes a generic type like the super repository.
public abstract class SuperService<T> {

    //* We declare it as a super repository, but later it will be instantiated as a sub repository.
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

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
