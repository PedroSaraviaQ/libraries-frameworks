package com.example.spring.relations.onetomany;

import com.example.spring.models.SuperModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "dojos")
public class Dojo extends SuperModel {

    //* Here we change the one-to-one to the "@OneToMany" annotation, and don't include the cascade type.
    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)

    //* And instead of only one field, we have a list of the other model.
    private List<Ninja> ninjas;
}
