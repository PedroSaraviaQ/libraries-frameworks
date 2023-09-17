package com.example.spring.relationships.manyToMany;

import com.example.spring.services.SuperService;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService extends SuperService<Instrument> {
    public InstrumentService(InstrumentRepository repository) {
        super(repository);
    }
}
