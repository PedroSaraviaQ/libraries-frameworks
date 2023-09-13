package com.example.spring.relationships.oneToOne;

import com.example.spring.repositories.SuperRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomanRepository extends SuperRepository<Roman> {
}
