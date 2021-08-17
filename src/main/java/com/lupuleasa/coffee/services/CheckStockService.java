package com.lupuleasa.coffee.services;

import com.lupuleasa.coffee.models.Ingredient;
import com.lupuleasa.coffee.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public boolean checkAmount(List<Ingredient> ingredients, int amount)
    {

        for(Ingredient i: ingredients)
        {
            if(i.getStock()<amount)
                return false;
        }

        return true;
    }

    public void setStock(List<Ingredient> ingredients, int amount)
    {
        for(Ingredient i: ingredients)
        {
            i.setStock(i.getStock()-amount);
            ingredientRepo.save(i);
        }
    }

}
