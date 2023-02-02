package com.bestrecipes.proiectfinalPAJSH.PJSH.Repository;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FoodRepository extends CrudRepository<Food,Long> {
}
