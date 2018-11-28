package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.Ingredient;

import java.util.ArrayList;
import java.util.Dictionary;

public interface IIngredientPricesDAO {
    Dictionary<String, Ingredient> getAllIngredients();
}
