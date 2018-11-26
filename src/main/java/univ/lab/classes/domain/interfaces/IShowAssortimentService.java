package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.Coffee;
import univ.lab.classes.domain.entities.Ingredient;

import java.util.ArrayList;

public interface IShowAssortimentService {
    boolean Process(int machineId);
    ArrayList<Coffee> getCoffeeAssortiment();
    ArrayList<Ingredient> getAdditionalIngredients();
}
