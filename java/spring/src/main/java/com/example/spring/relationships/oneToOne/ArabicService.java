package com.example.spring.relationships.oneToOne;

import com.example.spring.services.SuperService;
import org.springframework.stereotype.Service;

@Service
public class ArabicService extends SuperService<Arabic> {
    public ArabicService(ArabicRepository arabicRepository) {
        super(arabicRepository);
    }
}
