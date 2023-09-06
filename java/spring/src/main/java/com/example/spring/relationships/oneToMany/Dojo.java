package com.example.spring.relationships.oneToMany;

import com.example.spring.models.SuperModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "dojos")
public class Dojo extends SuperModel {

    //* "@OneToMany" doesn't include the cascade type, and precedes the collection.
    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)

    //* Collection of linked objects of the other model.
    private List<Ninja> ninjas;

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
}
