package com.example.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//* Models are like Java Beans. They should be in the "models" package of the project.
//! First design the schema of the database and then create the models.

//* "@Entity": The class is a model.
@Entity
//* @Table: Name of the table in the database.
@Table(name = "basics")

public class Basic {

    //* "@Id": Primary key.
    @Id
    //* "@GeneratedValue": Auto-incremented.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //* "@NotNull": Not null.
    @NotNull
    private String name;

    //* "@NotEmpty": @NotNull and not empty.
    //! The "message" attribute is shown when the validation fails in the view.
    @NotEmpty(message = "Email must not be empty")

    //* "@Email": Valid email.
    @Email

    //* "@Column(unique = true)": Unique value.
    @Column(unique = true)
    private String email;

    //* "@NotBlank": @NotEmpty and no whitespaces ("  ").
    @NotBlank

    //* "@Size": Size for arrays-like objects.
    @Size(min = 8)
    private String password;

    //* "@Min" and "@Max": Range for numbers.
    //* "@Range": With "min" and "max" attributes.
    @Min(18)
    private Integer age;

    //* @Column(updatable = false): Can't be updated.
    @Column(updatable = false)

    //* "@DateTimeFormat": Format of date.
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    //! An empty constructor is needed for the model.
    //* Since we don't have other constructors, we don't need to create the empty one.

    public Integer getId() {
        return id;
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

    public Integer getAge() {
        return age;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //* "@PrePersist": Executed before object is created.
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    //* "@PreUpdate": Executed before object is updated.
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
