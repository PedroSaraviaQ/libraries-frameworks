package com.example.spring.repositories;

import com.example.spring.models.Basic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//* This annotation tells Spring that this interface is a repository
@Repository

public interface BasicRepository extends CrudRepository<Basic, Integer> {

    //* This method is being overridden to return a list instead of an iterable.
    List<Basic> findAll();
}
