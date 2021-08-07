package com.lupuleasa.coffee;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository coffeRepo;

    @Autowired
    IngredientRepository ingredientRepo;

    @GetMapping("")
    public ModelAndView home()
    {

       ModelAndView mv = new ModelAndView();
       mv.setViewName("index");

       return mv;
    }

    @GetMapping("/user")
    public String user()
    {
        return "custom";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "menu";
    }

    @GetMapping("/menu")
    public ModelAndView menu()
    {

       ModelAndView mv = new ModelAndView("menu");

       mv.addObject("coffeeList",coffeRepo.findByIdIsLessThan(5));

       return mv;
    }

    @GetMapping("/custom")
    public ModelAndView custom()
    {
        ModelAndView mv = new ModelAndView("custom");


        return mv;
    }

    @GetMapping("addCustom")
    public ModelAndView addCustom()
    {
        ModelAndView mv = new ModelAndView("addCustom");

        mv.addObject("ingredientList",ingredientRepo.findAll());

        return mv;
    }

    @PostMapping("addCustom")
    public ModelAndView addCustom(Coffee coffee)
    {

        // You need to put here the logic


        ModelAndView mv = new ModelAndView();
        mv.setViewName("customSuccess");

        return mv;

    }

    @GetMapping("/orders")
    public ModelAndView orders()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders");

        return mv;
    }

    @GetMapping("/cart")
    public ModelAndView cart()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cart");

        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("");

        SecurityContextHolder.getContext().setAuthentication(null);

        return mv;
    }




}
