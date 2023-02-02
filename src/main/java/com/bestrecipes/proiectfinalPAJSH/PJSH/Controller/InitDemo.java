package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import com.bestrecipes.proiectfinalPAJSH.PAJ.Demo.DemoThread;
import com.bestrecipes.proiectfinalPAJSH.PAJ.Utils.ReportsMaker;
import com.bestrecipes.proiectfinalPAJSH.PAJ.Utils.ShowSuperUser;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.*;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class InitDemo {

    CuisineRepository cuisineRepository;
    FoodRepository foodRepository;
    UserRepository userRepository;
    CocktailRepository cocktailRepository;
    SuperUserRepository superUserRepository;
    SuperUser superUser;

    public Food initializeDB() {
        Cuisine cuisine1 = new Cuisine();
        cuisine1.setType("Italian");

        Cuisine cuisine2 = new Cuisine();
        cuisine2.setType("French");

        Cuisine cuisine3 = new Cuisine();
        cuisine2.setType("German");

        Food food1 = new Food();
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
        food1.setCuisine(cuisine1);

        Food food2 = new Food();
        food2.setName("Omlet");
        food2.setIngredients(Arrays.asList("Eggs", "Butter", "salt and pepper"));
        food2.setInstructions(Arrays.asList("Mix ingredients", "Cook the mix"));
        food2.setDifficulty("Medium");
        food2.setPreparationTime(10);
        food2.setDescription("Best served hot with a salad");
        food2.setOther("Can be eaten every day");
        food2.setCuisine(cuisine2);

        Food food3 = new Food();
        food3.setName("Prosciutto sandwich");
        food3.setIngredients(Arrays.asList("Bread", "Olive oil", "Prosciutto"));
        food3.setInstructions(List.of("Put ingredients between bread slices"));
        food3.setDifficulty("hard");
        food3.setPreparationTime(5);
        food3.setDescription("Ideal for quick snack");
        food3.setCuisine(cuisine1);

        Food food4 = new Food();
        food4.setName("Schnitzel");
        food4.setIngredients(Arrays.asList("Bread crumbs", "veal", "eggs", "flour"));
        food4.setInstructions(Arrays.asList("Put veal slices into flour", "Put it into eggs", "Put it into bread crumbs" ,"Fry into hot oil"));
        food4.setDifficulty("medium");
        food4.setPreparationTime(25);
        food4.setCuisine(cuisine3);

        Food food5 = new Food();
        food5.setName("Quattro formaggi pasta");
        food5.setIngredients(Arrays.asList("Multiple types of cheese", "pasta", "eggs", "sour cream"));
        food5.setInstructions(Arrays.asList("Boil pasta", "Mix cheese with eggs and cream into a pan", "Put put pasta into the pan"));
        food5.setDifficulty("medium");
        food5.setPreparationTime(20);
        food5.setCuisine(cuisine1);

        Food food6 = new Food();
        food6.setName("Carbonara pasta");
        food6.setIngredients(Arrays.asList("Ham", "pasta", "eggs", "sour cream", "parmesan"));
        food6.setInstructions(Arrays.asList("Boil pasta", "Mix cheese with eggs and ham into a pan", "Put put pasta into the pan"));
        food6.setDifficulty("medium");
        food6.setPreparationTime(20);
        food6.setCuisine(cuisine1);

        Food food7 = new Food();
        food7.setName("Caprese salad");
        food7.setIngredients(Arrays.asList("Mozzarella", "tomatoes", "olive oil"));
        food7.setInstructions(Arrays.asList("Cut in slices tomatoes and mozzarella", "put on a plate with olive oil"));
        food7.setDifficulty("easy");
        food7.setPreparationTime(10);
        food7.setCuisine(cuisine1);


        cuisine1.setFoodList(Arrays.asList(food1, food3, food5, food6, food7));
        cuisine2.setFoodList(List.of(food2));
        cuisine3.setFoodList(List.of(food4));

        User user1 = new User();
        user1.setName("Gordon Ramsey");     //No need to add email, is auto-generated from name

        User user2 = new User();
        user2.setName("Sorin");

        User user3 = new User();
        user3.setName("Scarlatescu");

        user1.setFoodList(List.of(food1));
        user2.setFoodList(List.of(food2));
        user3.setFoodList(List.of(food3));

        Cocktail cocktail1 = new Cocktail();
        cocktail1.setName("Negroni");
        cocktail1.setIngredients(Arrays.asList("Campari", "Gin", "Vermouth", "Ice"));
        cocktail1.setInstructions(Arrays.asList("Mix all the ingredients", "Pour into the glass"));
        cocktail1.setTemperature(10);
        cocktail1.setAlcoholic(Boolean.TRUE);
        cocktail1.setDifficulty("Hard");

        Cocktail cocktail2 = new Cocktail();
        cocktail2.setName("Beer");
        cocktail2.setIngredients(List.of("Beer"));
        cocktail2.setInstructions(List.of("Pour into the glass"));
        cocktail2.setTemperature(1);
        cocktail2.setAlcoholic(Boolean.TRUE);
        cocktail2.setDifficulty("Easy");

        cuisineRepository.save(cuisine1);
        cuisineRepository.save(cuisine2);
        cuisineRepository.save(cuisine3);
        foodRepository.save(food1);
        foodRepository.save(food2);
        foodRepository.save(food3);
        foodRepository.save(food4);
        foodRepository.save(food5);
        foodRepository.save(food6);
        foodRepository.save(food7);
        cocktailRepository.save(cocktail1);
        cocktailRepository.save(cocktail2);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        ShowSuperUser showSuperUser = (superUser) -> ("This is the new super user: " + superUser.toString());
        System.out.println(showSuperUser);

        superUserRepository.save(superUser);

        Optional<Food> ret = foodRepository.findById(1L);

        System.out.println("DB tests successfully done");

        ReportsMaker reportsMaker = new ReportsMaker();
        reportsMaker.addRecipesToGlossary(food1);
        reportsMaker.addRecipesToGlossary(food2);
        reportsMaker.addRecipesToGlossary(food3);
        reportsMaker.addRecipesToGlossary(cocktail1);

        reportsMaker.addUsersToList(user1);
        reportsMaker.addUsersToList(user2);
        reportsMaker.addUsersToList(user3);

        reportsMaker.showGlossary();
        reportsMaker.numberOfIngredients();
        reportsMaker.numberOfRecipes();
        reportsMaker.numberOfUsers();
        reportsMaker.numberOfHardRecipes();

         List <String> resultsList = new ArrayList<String>();

        DemoThread demoThread = new DemoThread(reportsMaker.getSynchronizedRecipesMap(), Collections.synchronizedList(resultsList));

        Thread thread1 = new Thread(demoThread, "Thread 1");
        Thread thread2 = new Thread(demoThread, "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result after threads :\n"+ resultsList);

        return ret.get();
    }
}
