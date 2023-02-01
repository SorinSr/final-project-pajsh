package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.*;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.*;
import lombok.Data;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        food3.setDifficulty("easy");
        food3.setPreparationTime(5);
        food3.setDescription("Ideal for quick snack");
        food3.setCuisine(cuisine1);

        cuisine1.setFoodList(Arrays.asList(food1, food3));
        cuisine2.setFoodList(List.of(food2));

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

        cuisineRepository.save(cuisine1);
        cuisineRepository.save(cuisine2);
        foodRepository.save(food1);
        foodRepository.save(food2);
        foodRepository.save(food3);
        cocktailRepository.save(cocktail1);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        System.out.println("This is the new super user: " + superUser.toString());
        superUserRepository.save(superUser);

        Optional<Food> ret = foodRepository.findById(1L);

        System.out.println("DB tests successfully done");

        return ret.get();
    }
}
