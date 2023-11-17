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
    
    //* "@OneToMany" works the same as "@OneToOne" for the non-owning side.
    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
    
    //* And instead of a single linked object, we have a list of them.
    private List<Ninja> ninjas;
    
    public List<Ninja> getNinjas() {
        return ninjas;
    }
    
    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
}
