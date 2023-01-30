package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Recipe {

    @Id
    @Column(name = "id_recipe", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private String other;

}
