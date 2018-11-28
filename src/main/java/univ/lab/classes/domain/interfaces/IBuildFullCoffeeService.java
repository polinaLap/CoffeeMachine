package univ.lab.classes.domain.interfaces;

import javafx.util.Pair;
import univ.lab.classes.domain.entities.Coffee;
import univ.lab.classes.domain.entities.Ingredient;

import java.util.Dictionary;

public interface IBuildFullCoffeeService {
    ICoffee Build (Coffee baseCoffee, Dictionary<String, Pair<Ingredient, Integer>> additionalIngredients);
}
