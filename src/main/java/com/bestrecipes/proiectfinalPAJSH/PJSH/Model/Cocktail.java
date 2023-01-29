package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;//package com.bestrecipes.proiectfinalPAJSH.PJSH.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COCKTAIL")
@Data
public class Cocktail extends Recipe {

    private int temperature;
    private boolean alcoholic;
}
