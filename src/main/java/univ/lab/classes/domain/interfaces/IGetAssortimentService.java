package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.Coffee;
import univ.lab.classes.domain.entities.CoffeeMachine;
import univ.lab.classes.domain.entities.Ingredient;

import java.util.ArrayList;

public interface IGetAssortimentService {
    boolean Process(CoffeeMachine coffeeMachine);
    ArrayList<Coffee> getCoffeeAssortiment();
    ArrayList<Ingredient> getAdditionalIngredients();
}
