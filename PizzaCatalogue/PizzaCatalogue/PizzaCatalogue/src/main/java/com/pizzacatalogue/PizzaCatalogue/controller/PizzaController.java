package com.pizzacatalogue.PizzaCatalogue.controller;

import com.pizzacatalogue.PizzaCatalogue.entity.Pizza;
import com.pizzacatalogue.PizzaCatalogue.service.PizzaService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("")
    public String home(){
        return "This is Pizza Catalogue API";
    }

    @RequestMapping("/pizza/pizzas")
    public List<Pizza> getAllPizzas(){
        return this.pizzaService.getAllPizzas();
    }

    @RequestMapping("/pizza/pizzas/{pid}")
    public Pizza getPizzaById(@PathVariable Long pid){
        return this.pizzaService.getPizzaById(pid);
    }

    @RequestMapping(value = "/pizza/pizzas", method = RequestMethod.POST)
    public Pizza addPizza(@RequestBody Pizza pizza){
        return this.pizzaService.addPizza(pizza);
    }

    @RequestMapping(value = "/pizza/pizzas",method = RequestMethod.PUT)
    public Pizza updatePizza(@RequestBody Pizza pizza){
        return this.pizzaService.updatePizza(pizza);
    }

    @RequestMapping(value = "/pizza/pizzas/{pid}" , method = RequestMethod.DELETE)
    public String deletePizza(@PathVariable Long pid){
        return this.pizzaService.deletePizza(pid);
    }

    @RequestMapping("/pizza/validate/{pid}")
    public boolean validatePizzaById(@PathVariable Long pid){
        return this.pizzaService.validatePizzaId(pid);
    }
}
