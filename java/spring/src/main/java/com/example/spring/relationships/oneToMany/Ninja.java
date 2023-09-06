package com.example.spring.relationships.oneToMany;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "ninjas")
public class Ninja extends SuperModel {

    //* "@ManyToOne" also takes the lazy fetch type, and precedes "@JoinColumn".
    @ManyToOne(fetch = FetchType.LAZY)

    //* Tne column name for the foreign key in the database.
    @JoinColumn(name = "dojo_id")

    //* The linked object of the other model.
    private Dojo dojo;

    public Dojo getDojo() {
        return dojo;
    }

    public void setDojo(Dojo dojo) {
        this.dojo = dojo;
    }
}
