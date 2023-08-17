package com.example.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

//* The same way when you have common methods, you can create a more general interface.

//* This annotation tells Spring that this interface is not a repository
@NoRepositoryBean

//* The interface will take a generic type parameter that will be the model type
public interface SuperRepository<T> extends CrudRepository<T, Long> {
    List<T> findAll();
}
