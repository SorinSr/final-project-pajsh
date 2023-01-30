package com.bestrecipes.proiectfinalPAJSH.PJSH.Exceptions;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.CocktailRepository;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NoRecipeFoundException extends NullPointerException {



    public NoRecipeFoundException(String message) {
        super(message);

    }

}
