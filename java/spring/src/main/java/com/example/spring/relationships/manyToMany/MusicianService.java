package com.example.spring.relationships.manyToMany;

import com.example.spring.services.SuperService;
import org.springframework.stereotype.Service;

@Service
public class MusicianService extends SuperService<Musician> {
    public MusicianService(MusicianRepository repository) {
        super(repository);
    }
}
