package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "regular_user")
public class User {

    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
        this.email = name+"@gmail.com";
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "food_id")
    @JsonIgnoreProperties("user")
    private List<Food> foodList;

}
