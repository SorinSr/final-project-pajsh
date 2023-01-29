package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Cocktail;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.CocktailRepository;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.FoodRepository;
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

    @PostMapping(path = "/addFood")
    public @ResponseBody String addnewFood(@RequestParam String name,
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
    public @ResponseBody String addnewCocktail(@RequestParam String name,@RequestParam int temperature,
                                               @RequestParam int alcoholic, @RequestParam String other) {

        Cocktail cocktail = new Cocktail();
        cocktail.setName(name);
        if (alcoholic == 1){
            cocktail.setAlcoholic(Boolean.TRUE);
        }else if (alcoholic == 0){
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

    @GetMapping(path = "/testDB")
    public Food testDBConnection() {

        System.out.println("Testing DB");

        Food food1 = new Food();
        food1.setName("pizza");
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
        food1.setDifficulty("easy");
        food1.setPreparationTime(30);
        food1.setDescription("Best served hot with a beer");
        food1.setInstructions(Arrays.asList("Make dough","Preheat oven at 220 degrees","Put ingredients","Cook 15 minutes"));


        Cocktail cocktail1 = new Cocktail();
        cocktail1.setName("Negroni");
        cocktail1.setIngredients(Arrays.asList("Campari","Gin","Vermouth","Ice"));
        cocktail1.setInstructions(Arrays.asList("Mix all the ingredients","Pour into the glass"));
        cocktail1.setTemperature(10);
        cocktail1.setAlcoholic(Boolean.TRUE);


        foodRepository.save(food1);
        cocktailRepository.save(cocktail1);

        Optional<Food> ret = foodRepository.findById(1L);

        System.out.println("Finish testing DB");

        return ret.get();

    }

}
