package com.lupuleasa.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoffeeController {



    @Autowired
    PurchaseRepository purchaseRepo;

    @Autowired
    QuantifiedCoffeeRepository qcoffeRepo;

    @Autowired
    CoffeeRepository coffeRepo;

    @Autowired
    RecipeRepository recipeRepo;

    @Autowired
    CartRepository cartRepo;

    @Autowired
    IngredientRepository ingredientRepo;

    @Autowired
    CustomerRepository customerRepo;

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

       mv.addObject("coffeeList",coffeRepo.findByIdGreaterThan(899));

       return mv;
    }

    @GetMapping("/custom")
    @ResponseBody
    public ModelAndView custom()
    {

        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView("custom");

        mv.addObject("coffeeList",coffeRepo.findByCustomer(customerRepo.findByUserName(auth.getName())));

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
    public ModelAndView addCustom(String coffeeName, String coffeeDesc, int[] ingredients)
    {

        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        // Setting the recipe

        Recipe recipe = new Recipe();
        recipe.setName(coffeeName);
        recipe.setIngredients(ingredientRepo.findByIds(ingredients));
        recipeRepo.save(recipe);

        // Setting the coffee

        Coffee coffee = new Coffee();
        coffee.setDescription(coffeeDesc);
        coffee.setImagePath("images/custom.png");
        coffee.setDescription(coffeeDesc);
        coffee.setName(coffeeName);
        coffee.setPrice(99);
        coffee.setCustomer(customerRepo.findByUserName(auth.getName()));
        coffee.setRecipe(recipe);
        coffeRepo.save(coffee);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customSuccess");

        return mv;

    }

    @GetMapping("/custom/{i}")
    public ModelAndView custom(@PathVariable String i)
    {

        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView("custom");

        coffeRepo.delete(coffeRepo.getById(Integer.parseInt(i)));
        mv.addObject("coffeeList",coffeRepo.findByCustomer(customerRepo.findByUserName(auth.getName())));

        return mv;
    }

    @GetMapping("/orders")
    public ModelAndView orders()
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders");
        mv.addObject("ordersList",purchaseRepo.findByCustomer(customerRepo.findByUserName(auth.getName())));

        return mv;
    }

    @GetMapping("/orders/{id}")
    public ModelAndView orders(@PathVariable String id)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView();

        mv.setViewName("order");
        mv.addObject("order",purchaseRepo.getById(Integer.parseInt(id)));
        mv.addObject("address",customerRepo.findByUserName(auth.getName()).getAddress());

        return mv;
    }

    @PostMapping("/cart")
    public ModelAndView cart(@RequestParam("mycoffee") String coffee , @RequestParam("myamount") String amount)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        Cart cart = customerRepo.findByUserName(auth.getName()).getCart();


           if(!qcoffeRepo.existsById(Integer.parseInt(coffee))){

            QuantifiedCoffee qcoffee = new QuantifiedCoffee();
            qcoffee.setId(Integer.parseInt(coffee));
            qcoffee.setName(coffeRepo.getById((Integer.parseInt(coffee))).getName());
            qcoffee.setAmount(Integer.parseInt(amount));
            qcoffee.setPrice(coffeRepo.getById((Integer.parseInt(coffee))).getPrice());
            qcoffee.setUser_id(customerRepo.findByUserName(auth.getName()).getId());
            qcoffee.setImagePath(coffeRepo.getById((Integer.parseInt(coffee))).getImagePath());

            qcoffeRepo.save(qcoffee);


            cart.setCoffees(qcoffeRepo.findByCustomerId(customerRepo.findByUserName(auth.getName()).getId()));
            cart.setTotal( customerRepo.findByUserName(auth.getName()).getCart().getTotal() + qcoffee.getAmount()*qcoffee.getPrice());

            cartRepo.delete(customerRepo.findByUserName(auth.getName()).getCart());

            cartRepo.save(cart);}
           else
           {
               QuantifiedCoffee qcoffee = qcoffeRepo.getById(Integer.parseInt(coffee));
               qcoffee.setAmount(qcoffee.getAmount()+Integer.parseInt(amount));
               qcoffeRepo.save(qcoffee);
           }


        ModelAndView mv = new ModelAndView();
        mv.setViewName("cart");

        return mv;
    }

    @PutMapping("/cart")
    public ModelAndView cartRemoveItem(@RequestParam("mycoffee") String coffee , @RequestParam("myamount") String amount)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();
        Cart cart = customerRepo.findByUserName(auth.getName()).getCart();

        if(qcoffeRepo.getByname(coffee).getAmount() <= Float.parseFloat(amount))
          {
              List<QuantifiedCoffee> qlist = cart.getCoffees();
              qlist.remove(qcoffeRepo.getByname(coffee));
              cart.setCoffees(qlist);
              cartRepo.delete(customerRepo.findByUserName(auth.getName()).getCart());
              cartRepo.save(cart);
          }
        else{
            QuantifiedCoffee qcoffee = qcoffeRepo.getByname(coffee);
            qcoffee.setAmount(qcoffeRepo.getByname(coffee).getAmount()-Integer.parseInt(amount));
            qcoffeRepo.save(qcoffee);
            }


        ModelAndView mv = new ModelAndView("cart");

        mv.addObject("coffeeList",qcoffeRepo.findByCustomerId(customerRepo.findByUserName(auth.getName()).getId()));

        return mv;

    }

    @GetMapping("/cart/")
    public void cartRemoveItems()
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();
        Cart cart = customerRepo.findByUserName(auth.getName()).getCart();

        cart.setCoffees(null);

        cartRepo.save(cart);

    }

    @GetMapping("/makePurchase")
    public void makePurchase()
    {

    // For user details
     Principal auth = SecurityContextHolder.getContext().getAuthentication();




        Purchase purchase = new Purchase();

         float total=0;

        List<QuantifiedCoffee> coffeeList = new ArrayList<QuantifiedCoffee>();

         for(QuantifiedCoffee c : customerRepo.findByUserName(auth.getName()).getCart().getCoffees())
         {
             total = total+ c.getPrice() * c.getAmount();
             coffeeList.add(c);
         }

        purchase.setAmount(total);
        purchase.setCustomer(customerRepo.findByUserName(auth.getName()));

        purchase.setCoffees(coffeeList);

      if(!coffeeList.isEmpty()) {
            purchaseRepo.save(purchase);
        }

    }

    @GetMapping("/cart")
    public ModelAndView cart()
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView("cart");

        float total=0;

        for(QuantifiedCoffee c : customerRepo.findByUserName(auth.getName()).getCart().getCoffees())
        {
            total = total+ c.getPrice() * c.getAmount();
        }

        mv.addObject("coffeeList",customerRepo.findByUserName(auth.getName()).getCart().getCoffees());
        mv.addObject("total",total);

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
