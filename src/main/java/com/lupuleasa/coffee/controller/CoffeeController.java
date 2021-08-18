package com.lupuleasa.coffee.controller;

import com.lupuleasa.coffee.models.*;
import com.lupuleasa.coffee.repositories.*;
import com.lupuleasa.coffee.services.CheckStockService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class CoffeeController {


    @Autowired
    CheckStockService checkStockService;

    @Autowired
    AddressRepository addressRepo;

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

        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

       ModelAndView mv = new ModelAndView();
       mv.setViewName("index");

        mv.addObject("status",customerRepo.findByUserName(auth.getName()).getRoles());
        mv.addObject("stockStatus", checkStockService.checkStock());

       return mv;
    }

    @GetMapping("/admin")
    public ModelAndView admin()
    {
        ModelAndView mv = new ModelAndView("admin");

        return mv;
    }

    @GetMapping("/admin/ingredients")
    public ModelAndView ingredients()
    {
        ModelAndView mv = new ModelAndView("manageIngredients");

        mv.addObject("ingredientList",ingredientRepo.findAll());

        mv.addObject("status", checkStockService.checkStock());

        return mv;
    }

    @GetMapping("addIngredient")
    public ModelAndView addIngredient()
    {
        ModelAndView mv = new ModelAndView("addIngredient");

        return mv;
    }

    @PostMapping("addIngredient/addIngredient/{myId}")
    public ModelAndView addIngredient(String ingredientName, String ingredientPrice,String ingredientStock, @PathVariable String myId)
    {
        Ingredient ingredient;



                    ingredient= ingredientRepo.getById(Integer.parseInt(myId));
                    ingredient.setName(ingredientName);
                    ingredient.setPrice(Float.parseFloat(ingredientPrice));
                    ingredient.setStock(Integer.parseInt(ingredientStock));

                    ingredientRepo.save(ingredient);


        ModelAndView mv = new ModelAndView();
        mv.setViewName("customSuccessAdmin");

        return mv;

    }

    @PostMapping("addIngredient/")
    public ModelAndView addIngredient(String ingredientName, String ingredientPrice, String ingredientStock)
    {
        Ingredient ingredient = new Ingredient();


        ingredient.setName(ingredientName);
        ingredient.setPrice(Float.parseFloat(ingredientPrice));
        ingredient.setStock(Integer.parseInt(ingredientStock));

        ingredientRepo.save(ingredient);


        ModelAndView mv = new ModelAndView();
        mv.setViewName("customSuccessAdmin");

        return mv;

    }

    @GetMapping("addIngredient/{myId}")
    public ModelAndView addIngredient(@PathVariable String myId)
    {
        ModelAndView mv = new ModelAndView("addIngredient");
        mv.addObject("ingredient",ingredientRepo.getById(Integer.parseInt(myId)));

        return mv;
    }

    @GetMapping("/admin/ingredients/{i}")
    public ModelAndView deleteIngredient(@PathVariable String i)
    {


        ModelAndView mv = new ModelAndView("manageIngredients");


        for(Recipe r : recipeRepo.findAll() )
        {
            if(r.getIngredients().contains(ingredientRepo.getById(Integer.parseInt(i)))) {
                for (Coffee c : coffeRepo.findByRecipe(r))
                    coffeRepo.delete(c);
            }
        }

        ingredientRepo.delete(ingredientRepo.getById(Integer.parseInt(i)));

        mv.addObject("ingredientList",ingredientRepo.findAll());


        return mv;
    }

    @GetMapping("/admin/customers")
    public ModelAndView customers()
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView("manageCustomers");

        List<Customer> customers = customerRepo.findAll();

        customers.remove(customerRepo.findByUserName(auth.getName()));

        mv.addObject("customerList",customers);

        return mv;
    }

    @GetMapping("/admin/customers/{i}")
    public ModelAndView deleteCustomer(@PathVariable String i)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView("manageCustomers");

        customerRepo.delete(customerRepo.getById(Integer.parseInt(i)));

        List<Customer> customers = customerRepo.findAll();

        customers.remove(customerRepo.findByUserName(auth.getName()));

        mv.addObject("customerList",customers);


        return mv;
    }

    @GetMapping("addCustomer")
    public ModelAndView addCustomer()
    {
        ModelAndView mv = new ModelAndView("addCustomer");

        return mv;
    }

    @GetMapping("addCustomer/{myId}")
    public ModelAndView addCustomer(@PathVariable String myId)
    {
        ModelAndView mv = new ModelAndView("addCustomer");
        mv.addObject("customer",customerRepo.getById(Integer.parseInt(myId)));

        return mv;
    }


    @PostMapping("addCustomer")
    public ModelAndView addCustomer(String customerName, String customerPass, String customerStreet, String customerNumber,String customerRole)
    {

        Customer customer = new Customer();
        customer.setUserName(customerName);
        customer.setPassword(customerPass);

        Address address = new Address();
        address.setStreetName(customerStreet);
        address.setBuildingNumber(Integer.parseInt(customerNumber));

        addressRepo.save(address);

        customer.setAddress(address);

        Cart cart = new Cart();

        customer.setCart(cart);

        if(customerRole!=null)
        {
            customer.setRoles("ROLE_ADMIN");
        }
        else
            customer.setRoles("ROLE_USER");

        customerRepo.save(customer);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customSuccessAdmin");

        return mv;

    }

    @PostMapping("addCustomer/addCustomer/{myId}")
    public ModelAndView addCustomer(String customerName, String customerPass, String customerStreet, String customerNumber,String customerRole, @PathVariable String myId)
    {
        Customer customer;
        customer= customerRepo.getById(Integer.parseInt(myId));
        customer.setUserName(customerName);
        customer.setPassword(customerPass);

        Address address = new Address();
        address.setStreetName(customerStreet);
        address.setBuildingNumber(Integer.parseInt(customerNumber));

        addressRepo.save(address);

        customer.setAddress(address);

        Cart cart = new Cart();

        customer.setCart(cart);

        if(customerRole!=null)
        {
            customer.setRoles("ROLE_ADMIN");
        }
        else
            customer.setRoles("ROLE_USER");

        customerRepo.save(customer);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customSuccessAdmin");

        return mv;

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

    @GetMapping("admin/orders")
    public ModelAndView adminOrders()
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        float total =0;

        Date date = new Date();

        // Add to total all the dates that are on the same day
        for(Purchase p : purchaseRepo.findAll()) {
            if(DateUtils.isSameDay(p.getCreateDate(),date)) {
                total = total + p.getAmount() / 10;
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminOrders");
        mv.addObject("ordersList",purchaseRepo.findAll());
        mv.addObject("total",total);

        return mv;
    }

    @GetMapping("admin/orders{id}")
    public ModelAndView adminOrders(@PathVariable String id)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        ModelAndView mv = new ModelAndView();

        mv.setViewName("order");
        mv.addObject("order",purchaseRepo.getById(Integer.parseInt(id)));
        mv.addObject("address",customerRepo.findAll());

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
    public String cart(@RequestParam("mycoffee") String coffee , @RequestParam("myamount") String amount)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        Cart cart = customerRepo.findByUserName(auth.getName()).getCart();


           List<Ingredient> ingredients = coffeRepo.getById((Integer.parseInt(coffee))).getRecipe().getIngredients();

           if(!qcoffeRepo.existsByName(coffeRepo.getById((Integer.parseInt(coffee))).getName())){

            int min = 2500;
            int max = 100000000;
            QuantifiedCoffee qcoffee = new QuantifiedCoffee();
            qcoffee.setId(Integer.parseInt(coffee)+(int)(Math.random()*(max-min+1)+min));
            qcoffee.setName(coffeRepo.getById((Integer.parseInt(coffee))).getName());
            qcoffee.setAmount(Integer.parseInt(amount));
            qcoffee.setPrice(coffeRepo.getById((Integer.parseInt(coffee))).getPrice());
            qcoffee.setUid(customerRepo.findByUserName(auth.getName()).getId());
            qcoffee.setImagePath(coffeRepo.getById((Integer.parseInt(coffee))).getImagePath());


            if(checkStockService.checkAmount(ingredients, Integer.parseInt(amount)))
            {
                checkStockService.setStock(ingredients, Integer.parseInt(amount));
            }
            else
            {
                return "Stock insufficient!";
            }


            qcoffeRepo.save(qcoffee);


            cart.setCoffees(qcoffeRepo.findByCustomerId(customerRepo.findByUserName(auth.getName()).getId()));
            cart.setTotal( customerRepo.findByUserName(auth.getName()).getCart().getTotal() + qcoffee.getAmount()*qcoffee.getPrice());

            cartRepo.delete(customerRepo.findByUserName(auth.getName()).getCart());

            cartRepo.save(cart);}
           else
           {
               QuantifiedCoffee qcoffee = qcoffeRepo.getQuantifiedCoffeeByNameAndUid(coffeRepo.getById((Integer.parseInt(coffee))).getName(),customerRepo.findByUserName(auth.getName()).getId());
               if(qcoffee.getAmount()>=Integer.parseInt(amount))
               {
                   qcoffee.setAmount(qcoffee.getAmount()+Integer.parseInt(amount));
                   checkStockService.setStock(ingredients, Integer.parseInt(amount));
               }
               else
               {
                   return "Stock insufficient!";
               }

               qcoffeRepo.save(qcoffee);
           }


       return "Added to the cart!";
    }

    @PutMapping("/cart")
    public ModelAndView cartRemoveItem(@RequestParam("mycoffee") String coffee , @RequestParam("myamount") String amount)
    {
        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        int min = 2500;
        int max = 100000000;

        Cart cart = customerRepo.findByUserName(auth.getName()).getCart();

        if(qcoffeRepo.getByname(coffee).getAmount() <= Float.parseFloat(amount))
          {
              for (Ingredient i : coffeRepo.getByName(coffee).getRecipe().getIngredients())
              {
                  i.setStock(qcoffeRepo.getByname(coffee).getAmount()+i.getStock());
              }

              List<QuantifiedCoffee> qlist = cart.getCoffees();
              QuantifiedCoffee q =qcoffeRepo.getByname(coffee);
              qlist.remove(qcoffeRepo.getByname(coffee));

              cart.setCoffees(qlist);
              cartRepo.delete(customerRepo.findByUserName(auth.getName()).getCart());
              cartRepo.save(cart);
              q.setName(coffee + (int)(Math.random()*(max-min+1)+min));
              q.setUid(-1);
              qcoffeRepo.save(q);
              }
        else{
            QuantifiedCoffee qcoffee = qcoffeRepo.getByname(coffee);

            for (Ingredient i : coffeRepo.getByName(coffee).getRecipe().getIngredients())
            {
                i.setStock(Integer.parseInt(amount)+i.getStock());
                ingredientRepo.save(i);
            }

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

        for( QuantifiedCoffee q : cart.getCoffees() )
        {
            for(Ingredient i : coffeRepo.getByName(q.getName()).getRecipe().getIngredients())
            {
                i.setStock(i.getStock()+q.getAmount());
                ingredientRepo.save(i);
            }
        }

        cart.setCoffees(null);

        cartRepo.save(cart);

    }

    @GetMapping("/makePurchase")
    public void makePurchase()
    {

        // For user details
        Principal auth = SecurityContextHolder.getContext().getAuthentication();

        Cart cart = new Cart();
        Purchase purchase = new Purchase();

        int min = 2500;
        int max = 100000000;


        cart = customerRepo.findByUserName(auth.getName()).getCart();

         float total=0;

        List<QuantifiedCoffee> coffeeList = new ArrayList<QuantifiedCoffee>();

         for(QuantifiedCoffee c : customerRepo.findByUserName(auth.getName()).getCart().getCoffees())
         {
             total = total+ c.getPrice() * c.getAmount();
             coffeeList.add(c);
             c.setName("aa"+ (int)(Math.random()*(max-min+1)+min));
             c.setUid(-1);
             qcoffeRepo.save(c);
         }

        purchase.setAmount(total);
        purchase.setCustomer(customerRepo.findByUserName(auth.getName()));

        purchase.setCoffees(coffeeList);


      if(!coffeeList.isEmpty()) {
          purchaseRepo.save(purchase);
          cart.setCoffees(null);
          cartRepo.save(cart);
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

    @GetMapping("/checkout/{total}")
    public ModelAndView verify(@PathVariable String total)
    {


        ModelAndView mv= new ModelAndView("checkout");
        mv.addObject("total",total);

        return mv;
    }


}

