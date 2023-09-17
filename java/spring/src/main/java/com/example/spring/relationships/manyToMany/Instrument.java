package com.example.spring.relationships.manyToMany;

import com.example.spring.models.SuperModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "instruments")
@Getter @Setter
public class Instrument extends SuperModel {
    @ManyToMany(mappedBy = "instruments", fetch = FetchType.LAZY)
    private Set<Musician> musicians;
}
