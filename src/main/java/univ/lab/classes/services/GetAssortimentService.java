package univ.lab.classes.services;

import univ.lab.classes.domain.entities.*;
import univ.lab.classes.domain.interfaces.ICoffeeMachineDAO;
import univ.lab.classes.domain.interfaces.ICoffeeTypeDAO;
import univ.lab.classes.domain.interfaces.IIngredientPricesDAO;
import univ.lab.classes.domain.interfaces.IGetAssortimentService;

import java.util.ArrayList;
import java.util.Dictionary;

public class GetAssortimentService implements IGetAssortimentService {

    private IIngredientPricesDAO _ingredientRepository;
    private ICoffeeTypeDAO _coffeeTypeRepository;

    public GetAssortimentService(IIngredientPricesDAO _ingredientRepository, ICoffeeMachineDAO _coffeeMachineRepository, ICoffeeTypeDAO _coffeeTypeRepository) {
        this._ingredientRepository = _ingredientRepository;
        this._coffeeTypeRepository = _coffeeTypeRepository;
    }

    private ArrayList<Coffee> coffeeAssortiment;
    private ArrayList<Ingredient> additionalIngredients;

    @Override
    public boolean Process(CoffeeMachine coffeeMachine){
        if(coffeeMachine == null || !coffeeMachine.AbleToMakeAnyCoffee())
            return false;
        ArrayList<CoffeeType> availableCoffeeTypes = SelectAvailableCoffeeTypes(coffeeMachine);
        if(availableCoffeeTypes.isEmpty())
            return false;
        Dictionary<String, Ingredient> allIngredients = _ingredientRepository.getAllIngredients();
        additionalIngredients = (ArrayList<Ingredient>) allIngredients.elements();
        coffeeAssortiment = FormCoffeeAssortiment(availableCoffeeTypes, allIngredients);
        return true;
    }

    private ArrayList<Coffee> FormCoffeeAssortiment(ArrayList<CoffeeType> availableCoffeeTypes,
                                                    Dictionary<String, Ingredient> allIngredients) {
        ArrayList<Coffee> result = new ArrayList<>();
        for(CoffeeType coffeeType : availableCoffeeTypes) {
            Ingredient coffeeIngredient = allIngredients.get(IngredientNames.COFFEE);
            Ingredient waterIngredient = allIngredients.get(IngredientNames.WATER);
            Ingredient milkIngredient = allIngredients.get(IngredientNames.MILK);
            double price =
                    coffeeIngredient.getPricePerPortion() * coffeeType.getCoffeeAmount() / coffeeIngredient.getPortionSize() +
                            waterIngredient.getPricePerPortion() * coffeeType.getWaterAmount() / waterIngredient.getPortionSize() +
                            milkIngredient.getPricePerPortion() * coffeeType.getMilkAmount() / milkIngredient.getPortionSize();
            Coffee coffee = new Coffee(coffeeType.getName(),
                    price,
                    coffeeType.getCoffeeAmount(), coffeeType.getMilkAmount(),
                    coffeeType.getWaterAmount());
            result.add(coffee);
        }
        return result;
    }


    private ArrayList<CoffeeType> SelectAvailableCoffeeTypes(CoffeeMachine coffeeMachine) {
        ArrayList<CoffeeType> allCoffeeTypes = _coffeeTypeRepository.GetAllCoffeeTypes();
        ArrayList<CoffeeType> availableCoffeeTypes = new ArrayList<CoffeeType>();
        for(CoffeeType coffeeType: allCoffeeTypes)
        {
            if(coffeeMachine.AbleToMake(coffeeType))
                availableCoffeeTypes.add(coffeeType);
        }
        return availableCoffeeTypes;
    }

    public ArrayList<Coffee> getCoffeeAssortiment() {
        return coffeeAssortiment;
    }

    public ArrayList<Ingredient> getAdditionalIngredients() {
        return additionalIngredients;
    }
}
