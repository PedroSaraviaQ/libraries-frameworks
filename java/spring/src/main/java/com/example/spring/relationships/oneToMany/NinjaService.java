package com.example.spring.relationships.oneToMany;

import com.example.spring.services.SuperService;
import org.springframework.stereotype.Service;

@Service
public class NinjaService extends SuperService<Ninja> {
    public NinjaService(NinjaRepository repository) {
        super(repository);
    }
}
