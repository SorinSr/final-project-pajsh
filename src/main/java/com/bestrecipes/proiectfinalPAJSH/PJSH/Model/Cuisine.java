package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cuisine")
    private List<Food> foodList;

}
