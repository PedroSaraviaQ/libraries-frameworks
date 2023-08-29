package com.example.spring.services;

import com.example.spring.models.SubModel;
import com.example.spring.repositories.SubRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//* This service will implement the logic for the specific methods of the sub repository.

//* "@Service" is required here too.
@Service

//* Extend the super service and pass the sub model, just like with the sub repository.
public class SubService extends SuperService<SubModel> {

    //* We declare the sub repository to use its specific methods.
    private final SubRepository repository;

    public SubService(SubRepository repository) {

        //* Unlike a standard service, this one calls "super" because the super constructor needs an argument.
        super(repository);

        this.repository = repository;
    }

    public SubModel findByCode(String code) {
        Optional<SubModel> sub = repository.findByCode(code);
        if (sub.isPresent()) {
            return sub.get();
        } else {
            return null;
        }
    }
}
