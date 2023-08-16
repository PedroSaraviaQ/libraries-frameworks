package com.example.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//* Basic representation of a model, they should be in the "models" package.

//* "@Entity" indicates that the class is a model.
@Entity
//* @Table indicates the name of the table in the database with its attribute.
@Table(name = "basics")

public class Basic {

    //* "@Id" indicates that the attribute is the primary key.
    @Id
    //* "@GeneratedValue" indicates that the attribute is auto-incremented.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //* "@NotNull": cannot be null.
    @NotNull
    private String name;

    //* "@NotEmpty": includes @NotNull and cannot be empty.
    @NotEmpty

    //* "@Email": must be a valid email.
    @Email
    private String email;

    //* "@NotBlank": includes @NotEmpty and cannot be blank (only whitespaces).
    @NotBlank

    //* "@Size": Their "min" and "max" attributes indicate the valid size, works with arrays-like objects.
    @Size(min = 8)
    private String password;

    //* "@Min" and "@Max": Their values indicate the valid range, works with numbers.
    @Min(18)
    private Integer age;

    //* @Column(updatable = false): cannot be updated.
    @Column(updatable = false)

    //* "@DateTimeFormat": lets you specify the format of the date.
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Basic() {
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //* "@PrePersist": It is executed before the object is created.
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    //* "@PreUpdate": It is executed before the object is updated.
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
