package com.pizzacatalogue.PizzaCatalogue.service;

import com.pizzacatalogue.PizzaCatalogue.entity.Pizza;

import java.util.List;

public interface PizzaService {
    public List<Pizza> getAllPizzas();
    public Pizza getPizzaById(Long pid);
    public Pizza addPizza(Pizza pizza);
    public Pizza updatePizza(Pizza pizza);
    public String deletePizza(Long pid);
    public boolean validatePizzaId(Long pid);
}
