package com.example.spring.relationships.oneToOne;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "arabics")
public class ArabicNumeral extends SuperModel {

    //* "@OneToOne" will only take the lazy fetch type.
    @OneToOne(fetch = FetchType.LAZY)

    //* "@JoinColumn" indicates that this entity owns the foreign key.
    //* The "name" attribute specifies the column name for the key in the database.
    @JoinColumn(name = "roman_id")

    //* This linked object will be the one Java will work with.
    private RomanNumeral roman;
}
