package com.example.spring.relationships.oneToOne;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "romans")
public class RomanNumeral extends SuperModel {

    //* "@OneToOne" here takes the lazy fetch type plus the cascade type.
    //* "mappedBy" will have the name of the linked object in the other model.
    @OneToOne(mappedBy = "roman", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    //* Then the linked object of the other model that Java will use.
    private ArabicNumeral arabic;
}
