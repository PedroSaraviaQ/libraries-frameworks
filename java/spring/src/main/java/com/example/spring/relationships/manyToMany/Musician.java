package com.example.spring.relationships.manyToMany;

import com.example.spring.models.SuperModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "musicians")
@Getter @Setter
public class Musician extends SuperModel {
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "musicians_instruments",
        joinColumns = @JoinColumn(name = "musician_id"),
        inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    private Set<Instrument> instruments;
}
