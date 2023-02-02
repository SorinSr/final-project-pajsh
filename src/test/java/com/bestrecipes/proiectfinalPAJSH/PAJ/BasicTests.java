package com.bestrecipes.proiectfinalPAJSH.PAJ;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Cocktail;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Cuisine;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BasicTests {

    @Test
    public void testFood()  {
        Food food = new Food();

        food.setName("Omlet");
        food.setDifficulty("Medium");
        food.setPreparationTime(10);

        assertEquals("Omlet", food.getName());
        assertEquals("Medium", food.getDifficulty());
        assertEquals(10, food.getPreparationTime());
        assertNull(food.getDescription());
        assertNull(food.getIngredients());
        assertNull(food.getInstructions());
        assertNull(food.getOther());
        System.out.println("Test succeeded");
    }

    @Test
    public void testUser()  {
        User user = new User();

        user.setName("John");

        assertEquals("John", user.getName());
        assertNull(user.getFoodList());
        System.out.println("Test succeeded");
    }

    @Test
    public void testCuisine()  {
        Cuisine cuisine = new Cuisine();
        cuisine.setType("Romanian");

        assertEquals("Romanian", cuisine.getType());
        assertNull(cuisine.getFoodList());
        System.out.println("Test succeeded");

    }

    @Test
    public void testCocktail()  {
        Cocktail cocktail = new Cocktail();

        cocktail.setAlcoholic(Boolean.TRUE);
        cocktail.setDifficulty("Easy");
        cocktail.setName("Sprit");
        cocktail.setTemperature(9);

        assertEquals(Boolean.TRUE, cocktail.isAlcoholic());
        assertEquals("Sprit", cocktail.getName());
        assertEquals("Easy", cocktail.getDifficulty());
        assertEquals(9, cocktail.getTemperature());
        assertNull(cocktail.getIngredients());
        assertNull(cocktail.getInstructions());
        System.out.println("Test succeeded");

    }


}
