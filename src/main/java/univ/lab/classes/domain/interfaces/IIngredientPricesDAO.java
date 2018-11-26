package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.Ingredient;

import java.util.ArrayList;

public interface IIngredientPricesDAO {
    ArrayList<Ingredient> getAllIngredients();
}
