package com.example.spring.relationships.onetoone;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "romans")
public class RomanNumeral extends SuperModel {

    //* The "@OneToOne" annotation here will take the lazy fetch type and the cascade type.
    //* And the "mappedBy" that will have the name of the variable that was set in the other model.
    @OneToOne(mappedBy = "roman", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    //* Then the field of the other model, its variable name doesn't matter much.
    private ArabicNumeral arabic;
}
