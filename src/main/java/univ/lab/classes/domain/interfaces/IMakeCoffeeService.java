package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.CoffeeMachine;

public interface IMakeCoffeeService {
    int MakeCoffee(ICoffee coffee, CoffeeMachine coffeeMachine, int userId);
}
