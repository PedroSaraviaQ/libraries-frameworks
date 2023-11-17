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
    
    //* "@ManyToMany" also only takes the lazy fetch.
    @ManyToMany(fetch = FetchType.LAZY)
    
    //* "@JoinTable" is used to specify and create the join table with its "name".
    //* "joinColumns" and "inverseJoinColumns" are used for linking the owning and non-owning sides respectively,
    //*  and have "@JoinColumn" inside them with their ids as in previous relationships.
    @JoinTable(
        name = "musicians_instruments",
        joinColumns = @JoinColumn(name = "musician_id"),
        inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    
    //* Instead of a list, we have a set to avoid duplicates.
    private Set<Instrument> instruments;
}
