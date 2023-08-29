package com.example.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

//* You can create a super repository to abstract the default methods.

//* The "@NoRepositoryBean" tells Spring not to create a repository bean for this interface.
@NoRepositoryBean

//* Unlike a standard repository, a super repository uses a generic type for the model.
//! While we could directly assign the super model, OOP doesn't typically use general types.
public interface SuperRepository<T> extends CrudRepository<T, Long> {

    List<T> findAll();
}
