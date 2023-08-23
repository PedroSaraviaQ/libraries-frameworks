package com.example.spring.relationships.onetomany;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;

@Entity
@Table(name = "ninjas")
public class Ninja extends SuperModel {

    //* We're also stating with the one that will depend on the other model.

    //* Instead of one-to-one, we use the "@ManyToOne" annotation.
    @ManyToOne(fetch = FetchType.LAZY)

    //* Then the rest is the same as the one-to-one relationship.
    @JoinColumn(name = "dojo_id")
    private Dojo dojo;
}
