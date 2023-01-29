package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private List<String> ingredients;
    private List<String> instructions;
    private String other;

}
