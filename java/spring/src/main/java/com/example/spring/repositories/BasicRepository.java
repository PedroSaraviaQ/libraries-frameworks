package com.example.spring.repositories;

import com.example.spring.models.Basic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//* They should be interfaces, and stored in the "repositories" package.

//* Repositories are used to interact with the database
//* And also provide advanced methods from JPA to interact with it.

//* Tells Spring that it's a repository
@Repository

//* They extend "CrudRepository" and use the model and the primary key's type as generics.
public interface BasicRepository extends CrudRepository<Basic, Integer> {

    //* Those methods can also be overridden to provide more functionality.
    List<Basic> findAll();
}
