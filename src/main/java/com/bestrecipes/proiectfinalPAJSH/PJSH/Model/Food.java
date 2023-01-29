package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "FOOD")
@Setter @Getter @NoArgsConstructor @ToString
public class Food extends Recipe {

    private String difficulty;
    private int preparationTime;
    private String description;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    @JsonIgnoreProperties("foodList")
    private Cuisine cuisine;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

}