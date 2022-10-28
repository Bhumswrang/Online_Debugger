package com.pizzacatalogue.PizzaCatalogue.service;

import com.pizzacatalogue.PizzaCatalogue.entity.Pizza;
import com.pizzacatalogue.PizzaCatalogue.exception.DuplicateEntryInDBException;
import com.pizzacatalogue.PizzaCatalogue.exception.EmptyInputException;
import com.pizzacatalogue.PizzaCatalogue.exception.PizzaNotFoundException;
import com.pizzacatalogue.PizzaCatalogue.exception.PizzaWithIdAlreadyExistException;
import com.pizzacatalogue.PizzaCatalogue.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService{

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzaRepository.findAll().forEach(pizzas::add);
        return pizzas;
    }

    @Override
    public Pizza getPizzaById(Long pid) {
//        Optional<Pizza> pizza = pizzaRepository.findById(pid);
//        return pizza.get();
        return pizzaRepository.findById(pid).orElseThrow(()->new PizzaNotFoundException());
    }

    @Override
    public Pizza addPizza(Pizza pizza) {
//        pizzaRepository.save(pizza);
//        return pizza;
        if(pizza.getP_name().isEmpty() || pizza.getP_name().length()==0 || pizza.getPrice().isEmpty() || pizza.getType().isEmpty())
            throw new EmptyInputException();

        Optional<Pizza> p = pizzaRepository.findById(pizza.getPid());
        if (p.isPresent()){
            throw new PizzaWithIdAlreadyExistException();
        }

        List<Pizza> users = new ArrayList<>();
        pizzaRepository.findAll().forEach(users::add);
        for(Pizza pp : users){
            if ((pp.getP_name().equals(pizza.getP_name())) && (pp.getType().equals(pizza.getType())) && (pp.getPrice().equals(pp.getPrice())))
            {
                throw new DuplicateEntryInDBException();
            }
        }

        pizzaRepository.save(pizza);
        return pizza;
    }

    @Override
    public Pizza updatePizza(Pizza pizza) {
        if(pizzaRepository.existsById(pizza.getPid())){
            pizzaRepository.save(pizza);
            return pizza;
        }
        else throw  new PizzaNotFoundException();
    }

    @Override
    public String deletePizza(Long pid) {
//        Optional<Pizza> pizza = pizzaRepository.findById(pid);
//        if(pizza.isPresent()){
//            pizzaRepository.delete(pizza.get());
//            return "Pizza Item deleted successfully";
//        }
//        return "Pizza Item don't exist";

        Optional<Pizza> pizza = pizzaRepository.findById(pid);
        if (pizza.isPresent()){
            pizzaRepository.delete(pizza.get());
            return "Deleted the User Successfully";
        }
        else throw new PizzaNotFoundException();
    }

    @Override
    public boolean validatePizzaId(Long pid) {
        if(pizzaRepository.existsById(pid))return true;
        return false;
    }
}
