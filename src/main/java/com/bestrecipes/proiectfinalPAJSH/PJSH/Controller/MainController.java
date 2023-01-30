package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Exceptions.NoRecipeFoundException;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.*;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "demo")
public class MainController {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SuperUserRepository superUserRepository;

    @Autowired
    private SuperUser superUser;

    @PostMapping(path = "/addFood")
    public @ResponseBody String addNewFood(@RequestParam String name,
                                           @RequestParam String difficulty, @RequestParam int prepTime,
                                           @RequestParam String description, @RequestParam String other) {

        Food food = new Food();
        food.setName(name);
        food.setDifficulty(difficulty);
        food.setPreparationTime(prepTime);
        food.setDescription(description);
        food.setOther(other);
        foodRepository.save(food);

        return "success";
    }

    @PostMapping(path = "/addCocktail")
    public @ResponseBody String addNewCocktail(@RequestParam String name, @RequestParam int temperature,
                                               @RequestParam int alcoholic, @RequestParam String other) {

        Cocktail cocktail = new Cocktail();
        cocktail.setName(name);
        if (alcoholic == 1) {
            cocktail.setAlcoholic(Boolean.TRUE);
        } else if (alcoholic == 0) {
            cocktail.setAlcoholic(Boolean.FALSE);
        }
        cocktail.setTemperature(temperature);

        return "success";
    }

    @GetMapping(path = "/allFood")
    public @ResponseBody Iterable<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @GetMapping(path = "/allCocktail")
    public @ResponseBody Iterable<Cocktail> getAllCocktail() {
        return cocktailRepository.findAll();
    }

    @GetMapping(path = "/allCuisine")
    public @ResponseBody Iterable<Cuisine> getAllCuisine() {
        return cuisineRepository.findAll();
    }

    @GetMapping(path = "/allUser")
    public @ResponseBody Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/superUser")
    public @ResponseBody SuperUser getSuperUser() {
        return superUserRepository.findById(1).get();
    }

    @GetMapping(path = "/getFood")
    public @ResponseBody Food getFood(@RequestParam Long id) {
        if (foodRepository.findById(id).isPresent()) {
            return foodRepository.findById(id).get();
        } else {
            throw new NoRecipeFoundException("No food found for id " + id);
        }
    }

    @GetMapping(path = "/getCocktail")
    public @ResponseBody Cocktail getCocktail(@RequestParam Long id) {
        if (cocktailRepository.findById(id).isPresent()) {
            return cocktailRepository.findById(id).get();
        } else {
            throw new NoRecipeFoundException("No cocktail found for id " + id);
        }
    }

    @GetMapping(path = "/testDB")
    public Food testDBConnection() {

        System.out.println("Testing DB");

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

        System.out.println("Finish testing DB \nSuccess");

        return ret.get();
    }
}
