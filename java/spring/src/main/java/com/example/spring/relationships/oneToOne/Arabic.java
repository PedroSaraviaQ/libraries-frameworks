package com.example.spring.relationships.oneToOne;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(name = "arabics")
public class Arabic extends SuperModel {

    //* "@OneToOne" takes lazy "fetch" and all "cascade" (if deleted, delete the linked object).
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    //* "@JoinColumn" indicates that this entity owns the foreign key.
    //* The "name" attribute specifies the column name for the key in the database.
    @JoinColumn(name = "roman_id")

    //! This ensures the error messages are displayed for the linked object.
    @Valid

    //* This linked object will be the one Java will work with.
    private Roman roman;

    public Roman getRoman() {
        return roman;
    }

    public void setRoman(Roman roman) {
        this.roman = roman;
    }
}
