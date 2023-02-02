package com.bestrecipes.proiectfinalPAJSH.PAJ;

import com.bestrecipes.proiectfinalPAJSH.PAJ.Utils.ReportsMaker;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateReports {

    private ReportsMaker reportsMaker = new ReportsMaker();
    private Food food1 = new Food();
    private Food food2 = new Food();
    private Food food3 = new Food();
    private Food food4 = new Food();
    private Food food5 = new Food();
    private Food food6 = new Food();
    private Food food7 = new Food();
    private User user1 = new User();
    private User user2 = new User();
    private User user3 = new User();

    private void setup() {
        user1.setName("Gordon Ramsey");
        user2.setName("Sorin");
        user3.setName("Scarlatescu");

        food1.setName("Pizza");
        List<String> ingredientsList = new ArrayList<>();
        ingredientsList.add("flour");
        ingredientsList.add("water");
        ingredientsList.add("salt");
        ingredientsList.add("olive oil");
        ingredientsList.add("mozzarella");
        ingredientsList.add("pepper");
        ingredientsList.add("salami");
        ingredientsList.add("oregano");
        ingredientsList.add("olives");
        food1.setIngredients(ingredientsList);
        food1.setDifficulty("Medium");
        food1.setPreparationTime(30);
        food1.setDescription("Best served hot with a beer");
        food1.setInstructions(Arrays.asList("Make dough", "Preheat oven at 220 degrees", "Put ingredients", "Cook 15 minutes"));

        food2.setName("Omlet");
        food2.setIngredients(Arrays.asList("Eggs", "Butter", "salt and pepper"));
        food2.setInstructions(Arrays.asList("Mix ingredients", "Cook the mix"));
        food2.setDifficulty("Medium");
        food2.setPreparationTime(10);
        food2.setDescription("Best served hot with a salad");
        food2.setOther("Can be eaten every day");

        food3.setName("Prosciutto sandwich");
        food3.setIngredients(Arrays.asList("Bread", "Olive oil", "Prosciutto"));
        food3.setInstructions(List.of("Put ingredients between bread slices"));
        food3.setDifficulty("hard");
        food3.setPreparationTime(5);
        food3.setDescription("Ideal for quick snack");

        food4.setName("Schnitzel");
        food4.setIngredients(Arrays.asList("Bread crumbs", "veal", "eggs", "flour"));
        food4.setInstructions(Arrays.asList("Put veal slices into flour", "Put it into eggs", "Put it into bread crumbs", "Fry into hot oil"));
        food4.setDifficulty("medium");
        food4.setPreparationTime(25);

        food5.setName("Quattro formaggi pasta");
        food5.setIngredients(Arrays.asList("Multiple types of cheese", "pasta", "eggs", "sour cream"));
        food5.setInstructions(Arrays.asList("Boil pasta", "Mix cheese with eggs and cream into a pan", "Put put pasta into the pan"));
        food5.setDifficulty("medium");
        food5.setPreparationTime(20);

        food6.setName("Carbonara pasta");
        food6.setIngredients(Arrays.asList("Ham", "pasta", "eggs", "sour cream", "parmesan"));
        food6.setInstructions(Arrays.asList("Boil pasta", "Mix cheese with eggs and ham into a pan", "Put put pasta into the pan"));
        food6.setDifficulty("medium");
        food6.setPreparationTime(20);

        food7.setName("Caprese salad");
        food7.setIngredients(Arrays.asList("Mozzarella", "tomatoes", "olive oil"));
        food7.setInstructions(Arrays.asList("Cut in slices tomatoes and mozzarella", "put on a plate with olive oil"));
        food7.setDifficulty("easy");
        food7.setPreparationTime(10);

        reportsMaker.addUsersToList(user1);
        reportsMaker.addUsersToList(user2);
        reportsMaker.addUsersToList(user3);
        reportsMaker.addRecipesToGlossary(food1);
        reportsMaker.addRecipesToGlossary(food2);
        reportsMaker.addRecipesToGlossary(food3);
        reportsMaker.addRecipesToGlossary(food4);
        reportsMaker.addRecipesToGlossary(food5);
        reportsMaker.addRecipesToGlossary(food6);
        reportsMaker.addRecipesToGlossary(food7);

    }


    @Test
    public void testReportsIngredinets() {
        setup();
        System.out.println("testReportsIngredinets " + reportsMaker.numberOfIngredients());
        assertEquals(31, reportsMaker.numberOfIngredients());
    }

    @Test
    public void testReportsRecipes() {
        setup();
        System.out.println("testReportsRecipes " + reportsMaker.numberOfRecipes());
        assertEquals(7, reportsMaker.numberOfRecipes());
    }

    @Test
    public void testReportsUsers() {
        setup();
        System.out.println("testReportsUsers " + reportsMaker.numberOfUsers());
        assertEquals(3, reportsMaker.numberOfUsers());
    }

    @Test
    public void testReportsHardRecipes() {
        setup();
        System.out.println("testReportsHardRecipes " + reportsMaker.numberOfHardRecipes());
        assertEquals(1, reportsMaker.numberOfHardRecipes());
    }


}
