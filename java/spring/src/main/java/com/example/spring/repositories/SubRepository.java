package com.example.spring.repositories;

import com.example.spring.models.SubModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//* The interface will just inherit the methods from the superclass, and pass the model to it.
public interface SubRepository extends SuperRepository<SubModel> {

    //* You can also create some custom methods in your repositories, Spring will implement them.

    Optional<SubModel> findByCode(String code);

    boolean existsById(Long id);
}
