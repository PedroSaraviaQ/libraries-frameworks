package com.example.spring.relationships.oneToMany;

import com.example.spring.services.SuperService;
import org.springframework.stereotype.Service;

@Service
public class DojoService extends SuperService<Dojo> {
    public DojoService(DojoRepository repository) {
        super(repository);
    }
}
