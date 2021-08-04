package com.lupuleasa.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {

    @RequestMapping("")
    public ModelAndView home()
    {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("index");

       return mv;
    }

    @RequestMapping("/menu")
    public ModelAndView menu()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("menu");

        return mv;
    }

    @RequestMapping("/custom")
    public ModelAndView custom()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("custom");

        return mv;
    }

    @RequestMapping("/orders")
    public ModelAndView orders()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders");

        return mv;
    }

}
