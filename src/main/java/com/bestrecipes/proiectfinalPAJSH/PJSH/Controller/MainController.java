package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Aspects.TestDBAspect;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Exceptions.NoRecipeFoundException;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.*;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Autowired
    private TestDBAspect testDBAspect;

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
        Iterable<User> iter = userRepository.findAll();
//        reportHelper(iter);
        return iter;
    }

//    private List reportHelper(Iterable iterable){
//
//        List result = (List) StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
//        System.out.println(result + " results +++++++++++++++++");
//
//        return result;
//    }


    @GetMapping(path = "/superUser")
    public @ResponseBody SuperUser getAllSuperUser() {
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

        InitDemo initDemo = new InitDemo();

        initDemo.setCuisineRepository(cuisineRepository);
        initDemo.setFoodRepository(foodRepository);
        initDemo.setCocktailRepository(cocktailRepository);
        initDemo.setSuperUserRepository(superUserRepository);
        initDemo.setUserRepository(userRepository);
        initDemo.setSuperUser(superUser);

        return initDemo.initializeDB();
    }
}
