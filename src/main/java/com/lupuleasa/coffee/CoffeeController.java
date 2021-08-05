package com.lupuleasa.coffee;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {

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
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu");

        return mv;
    }

    @GetMapping("/custom")
    public ModelAndView custom()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("custom");

        return mv;
    }

    @GetMapping("/orders")
    public ModelAndView orders()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders");

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
