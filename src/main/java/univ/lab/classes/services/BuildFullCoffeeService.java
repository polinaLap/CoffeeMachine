package univ.lab.classes.services;

import javafx.util.Pair;
import univ.lab.classes.domain.entities.*;
import univ.lab.classes.domain.interfaces.IBuildFullCoffeeService;
import univ.lab.classes.domain.interfaces.ICoffee;

import java.util.Dictionary;

public class BuildFullCoffeeService implements IBuildFullCoffeeService {

   @Override
   public ICoffee Build(Coffee baseCoffee, Dictionary<String, Pair<Ingredient, Integer>> additionalIngredients){
       ICoffee result = baseCoffee;

       Pair<Ingredient,Integer> coffeeWithPortions = additionalIngredients.get(IngredientNames.COFFEE);
       result = Decorate(result, coffeeWithPortions);

       Pair<Ingredient,Integer> waterWithPortions = additionalIngredients.get(IngredientNames.WATER);
       result = Decorate(result, waterWithPortions);

       Pair<Ingredient,Integer> milkWithPortions = additionalIngredients.get(IngredientNames.MILK);
       result = Decorate(result, milkWithPortions);

       Pair<Ingredient,Integer> sugarWithPortions = additionalIngredients.get(IngredientNames.SUGAR);
       result = Decorate(result, sugarWithPortions);

       return result;
   }

   private ICoffee Decorate(ICoffee coffee, Pair<Ingredient,Integer>  ingredientWithPortions){
       double price = ingredientWithPortions.getKey().getPricePerPortion()*ingredientWithPortions.getValue();
       CoffeeParameters coffeeParameters = new CoffeeParameters();
       coffeeParameters.set_coffeeAmount(ingredientWithPortions.getKey().getPortionSize()*ingredientWithPortions.getValue());
       return new CoffeeDecorator(coffee, coffeeParameters, price);
   }

}
