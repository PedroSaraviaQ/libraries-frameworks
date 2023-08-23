package com.example.spring.relationships.onetoone;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "arabics")
public class ArabicNumeral extends SuperModel {

    //* We start with this model that will depend on the other one.

    //* The "@OneToOne" annotation will only take the lazy fetch type.
    @OneToOne(fetch = FetchType.LAZY)

    //* The "@JoinColumn" annotation will have the name of the column that will reference the other model.
    @JoinColumn(name = "roman_id")

    //* Then the field of the other model, its variable name will be referenced by the other model.
    private RomanNumeral roman;
}
