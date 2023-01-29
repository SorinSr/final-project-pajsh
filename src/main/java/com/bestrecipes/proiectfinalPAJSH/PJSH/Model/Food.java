package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FOOD")
@Data
public class Food extends Recipe {

    private String difficulty;
    private int preparationTime;
    private String description;
}