package com.pizzacatalogue.PizzaCatalogue.repository;

import com.pizzacatalogue.PizzaCatalogue.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {
}
