package com.lupuleasa.coffee.services;

import com.lupuleasa.coffee.models.Ingredient;
import com.lupuleasa.coffee.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckStockService {

    @Autowired
    IngredientRepository ingredientRepo;

    public boolean checkStock()
    {

        for (Ingredient i : ingredientRepo.findAll())
            if(i.getStock()<=3)
                return true;

            return false;
    }

}
