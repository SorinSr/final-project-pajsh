package com.bestrecipes.proiectfinalPAJSH.PAJ.Demo;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Recipe;

import java.util.List;
import java.util.Map;

public class DemoThread implements Runnable {

    private Map<String, Recipe> recipesMap;
    private List<String> modifiedRecipesList;

    private final Object monitor = new Object();

    public DemoThread(Map<String, Recipe> recipesMap, List<String> modifiedRecipesMap) {
        this.recipesMap = recipesMap;
        this.modifiedRecipesList = modifiedRecipesMap;
    }

    @Override
    public void run() {
        System.out.println("Current thread name is: " + Thread.currentThread().getName());

        synchronized (monitor) {
            try {
                monitor.wait(100);
                for (Recipe recipe : recipesMap.values()) {
                    monitor.wait(100);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(Thread.currentThread().getName()).append("  ->  ").append(recipe.getName()).append("  ::  ");
                    for (String ingredient : recipe.getIngredients()) {
                        stringBuffer.append(ingredient);
                    }
                    stringBuffer.append("\n");
                    modifiedRecipesList.add(stringBuffer.toString());
//            getModifiedRecipesMap();
                    recipesMap.remove(recipe.getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> getModifiedRecipesMap() {
        System.out.println("Modified recipes list is: " + modifiedRecipesList);
        return modifiedRecipesList;
    }
}
