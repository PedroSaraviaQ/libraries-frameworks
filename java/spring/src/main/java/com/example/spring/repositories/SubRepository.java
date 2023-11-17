package com.example.spring.repositories;

import com.example.spring.models.SubModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//* This repository will have the specific methods for the sub model.

@Repository

//* Just extend the super repository and pass the sub model.
public interface SubRepository extends SuperRepository<SubModel> {

    Optional<SubModel> findByCode(String code);

    boolean existsById(Long id);
}
