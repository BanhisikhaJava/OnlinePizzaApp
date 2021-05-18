package com.cg.onlinepizza.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.pizza.Exceptions.InvalidMinCostException;
import com.cg.onlinepizza.pizza.Exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.dto.Pizza;

/***************************************************************************************************************************
 * Interface: IPizzaRepository
 * Description: It specify all the business logic in the service layer
 * Created By-BANHISHIKA CHANDA
 * Created Date -  15-05-2021 
 * 
 ***************************************************************************************************************************/

public interface IPizzaRepository{
	Pizza addPizza(Pizza pizza);

	Pizza updatePizza(Pizza pizza) throws PizzaIdNotFoundException;

	String deletePizza(int pizzaId) throws PizzaIdNotFoundException; //throws PizzaIdNotFoundException;

	Optional<Pizza> viewPizza(int pizzaId) throws PizzaIdNotFoundException; //throws PizzaIdNotFoundException;

	List<Pizza> viewPizzaList();

	Optional<List<Pizza>> viewPizzaList(double minCost, double maxCost) throws InvalidMinCostException;//throws InvalidMinCostException;
}
