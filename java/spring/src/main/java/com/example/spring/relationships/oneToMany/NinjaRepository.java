package com.example.spring.relationships.oneToMany;

import com.example.spring.repositories.SuperRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends SuperRepository<Ninja> {
}
