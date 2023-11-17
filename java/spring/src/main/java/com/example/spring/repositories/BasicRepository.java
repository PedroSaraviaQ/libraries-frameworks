package com.example.spring.repositories;

import com.example.spring.models.Basic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//* They should be interfaces, and stored in the "repositories" package.

//* Repositories are used to interact with the database
//* And also provide advanced methods from JPA to interact with it.

//* Tells Spring that it's a repository
@Repository

//* They extend "CrudRepository" and use the model and the primary key's type as generics.
public interface BasicRepository extends CrudRepository<Basic, Integer> {

    //* Some basic methods are already provided by JPA, so they don't have to be implemented.
    //* findById, findAll, existsById, save, deleteById, deleteAll, count.

    //* However, you can still implement them to add more functionality.
    List<Basic> findAll();

    //* Advanced methods can be created using the "Query Creation" from JPA.
    //! Use "Optional" when returning a single element to avoid null pointer exceptions.
    Optional<Basic> findByName(String name);

    //* You can even use 2 or more fields to create a query.
    List<Basic> findAllByEmailContainingAndAgeGreaterThan(String email, Integer age);
}
