package com.example.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "subtables")
//* The subclass will just inherit the fields from the superclass.
public class SubModel extends SuperModel {
    @NotBlank
    private String code;

    public SubModel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
