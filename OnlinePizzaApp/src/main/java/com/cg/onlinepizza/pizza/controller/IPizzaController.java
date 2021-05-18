package com.cg.onlinepizza.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizza.pizza.Exceptions.InvalidMinCostException;
import com.cg.onlinepizza.pizza.Exceptions.PizzaIdNotFoundException;
import com.cg.onlinepizza.pizza.dto.Pizza;
import com.cg.onlinepizza.pizza.service.IPizzaRepositoryImpl;

@RestController
@RequestMapping("/pizza")

public class IPizzaController {
	@Autowired
	private IPizzaRepositoryImpl serviceobj;

	@PostMapping("/add")

	public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
		Pizza p = serviceobj.addPizza(pizza);
		if (p == null) {
			return new ResponseEntity("Pizza Not Found!!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pizza>(p, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) throws PizzaIdNotFoundException {
		return serviceobj.deletePizza(id);
	}

	@GetMapping("/viewAllPizza")
	public List<Pizza> viewAllPizza() {
		return serviceobj.viewPizzaList();
	}

	@GetMapping("/viewpizza/{id}")
	public Optional<Pizza> getEmployee(@PathVariable("id") int id) throws PizzaIdNotFoundException {
		return serviceobj.viewPizza(id);
	}

	@PutMapping("/UpdatePizza")
	public String UpdatePizza(@RequestBody Pizza pizza) {
		Pizza p= serviceobj.updatePizza(pizza);
		if(p== null)
		return "Not Update";
		else
		return "Updated";

	}

	@GetMapping("/viewPizzaList/{minCost}/{maxCost}")
	public Optional<List<Pizza>> viewPizzaList(@PathVariable("minCost") double minCost,
			@PathVariable("maxCost") double maxCost) throws InvalidMinCostException {
		return serviceobj.viewPizzaList(minCost, maxCost);

	}

}
