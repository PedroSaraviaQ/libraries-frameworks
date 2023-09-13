package com.example.spring.relationships.oneToOne;

import com.example.spring.services.SuperService;
import org.springframework.stereotype.Service;

@Service
public class RomanService extends SuperService<Roman> {
    public RomanService(RomanRepository romanRepository) {
        super(romanRepository);
    }
}
