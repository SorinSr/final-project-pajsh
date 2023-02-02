package com.bestrecipes.proiectfinalPAJSH.PAJ.Utils;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Recipe;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class ReportsMaker {

    private Map<String, Recipe> allRecipesGlossary = new LinkedHashMap<>();
    private Map<String, List<String>> allIngredientsGlossary = new LinkedHashMap<>();
    private List<User> userList = new ArrayList<>();

    public void addUsersToList(User users) {
        userList.add(users);
    }

    public void addRecipesToGlossary(Recipe recipe) {
        allRecipesGlossary.put(recipe.getName(), recipe);
        addIngredientToGlossary(recipe);
    }

    public void addIngredientToGlossary(Recipe recipe) {
        allIngredientsGlossary.put(recipe.getName(), recipe.getIngredients());
    }

    public Map<String, List<String>> getAllIngredientsGlossary() {
        return allIngredientsGlossary;
    }

    public void showGlossary() {
        System.out.println("*** STREAMS: That is the glossary !");
        for (String x : allIngredientsGlossary.keySet()) {
            System.out.println(x + " -- > " + allIngredientsGlossary.get(x));
        }
    }

    public void numberOfIngredients() {
        System.out.println("*** STREAMS: Number of all ingredients : ");
        System.out.println(allIngredientsGlossary.values().stream().mapToInt(strings -> strings.size()).sum());
    }

    public void numberOfRecipes() {
        System.out.println("*** STREAMS: List of recipes : ");
        Consumer<? super java.util.Set<java.lang.String>> c = System.out::println;
        Stream.of(allIngredientsGlossary.keySet()).forEach(c);
        System.out.println("*** STREAMS: Number of all recipes : ");
        System.out.println(allIngredientsGlossary.keySet().stream().count());
    }

    public void numberOfUsers() {
        System.out.println("*** STREAMS: Number of all users : ");
        System.out.println((long) userList.size());
    }

    public void numberOfHardRecipes() {
        System.out.println("*** STREAMS: Number of hard recipes : " );
        Predicate<String> p = i -> i.equals("hard");
        long nr = 0;
        for (String x : allRecipesGlossary.keySet()) {
            nr = nr + Stream.of(allRecipesGlossary.get(x).getDifficulty().toLowerCase(Locale.ROOT)).filter(p).count();
        }
        System.out.println(nr);
    }




    public synchronized Map<String, Recipe> getSynchronizedRecipesMap() {
        return Collections.synchronizedMap(allRecipesGlossary);
    }
}
