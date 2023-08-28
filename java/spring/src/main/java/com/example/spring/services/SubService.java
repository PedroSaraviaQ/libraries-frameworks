package com.example.spring.services;

import com.example.spring.models.SubModel;
import com.example.spring.repositories.SubRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//* The subclass will just extend the super class, and pass the model as parameter.
public class SubService extends SuperService<SubModel> {

    //* The repository is declared and then assigned in the constructor.
    private final SubRepository repository;

    //* The constructor will pass down the repository to the super class.
    public SubService(SubRepository repository) {
        super(repository);
        //* We downcast the repository to access later the specific methods.
        this.repository = repository;
    }

    //* Additionally; you can add specific methods to the subclass.
    public SubModel findByCode(String code) {
        Optional<SubModel> sub = repository.findByCode(code);
        if (sub.isPresent()) {
            return sub.get();
        } else {
            return null;
        }
    }
}
