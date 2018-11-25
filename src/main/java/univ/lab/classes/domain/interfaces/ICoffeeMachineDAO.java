package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.CoffeeMachine;
import univ.lab.classes.domain.entities.CoffeeParameters;

public interface ICoffeeMachineDAO {
    CoffeeMachine GetCoffeeMachine (int id);
    boolean updateCoffeeMachine (int id, CoffeeParameters parameters);
}
