package com.example.spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

//* These are the models that will be used later.

@Entity
@Table(name = "subtables")

//* Just extend the super model and add the new fields
public class SubModel extends SuperModel {

    @NotBlank(message = "Code is required")
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
