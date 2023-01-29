package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "demo")
public class MainController {

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addnewFood(@RequestParam String name, @RequestParam String email) {

        Food food = new Food();
        food.setName("zacusca");
        foodRepository.save(food);

        return "success";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Food> getAllUsers() {
        return foodRepository.findAll();
    }

    @GetMapping(path = "/testDB")
    public Food testDBConnection() {

        System.out.println("Testing DB");

        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();

        food1.setName("dulceata");
        food2.setName("paste");
        food3.setName("friptura");

        foodRepository.save(food1);
        foodRepository.save(food2);
        foodRepository.save(food3);

        Optional<Food> ret = foodRepository.findById(1L);

        System.out.println("Finish testing DB");

        return ret.get();

    }

}
