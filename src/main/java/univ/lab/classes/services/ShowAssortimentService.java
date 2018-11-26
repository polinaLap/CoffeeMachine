package univ.lab.classes.services;

import univ.lab.classes.domain.entities.Coffee;
import univ.lab.classes.domain.entities.CoffeeMachine;
import univ.lab.classes.domain.entities.CoffeeType;
import univ.lab.classes.domain.entities.Ingredient;
import univ.lab.classes.domain.interfaces.ICoffeeMachineDAO;
import univ.lab.classes.domain.interfaces.ICoffeeTypeDAO;
import univ.lab.classes.domain.interfaces.IIngredientPricesDAO;
import univ.lab.classes.domain.interfaces.IShowAssortimentService;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ShowAssortimentService implements IShowAssortimentService {

    private IIngredientPricesDAO _ingredientRepository;
    private ICoffeeMachineDAO _coffeeMachineRepository;
    private ICoffeeTypeDAO _coffeTypeRepository;


    private ArrayList<Coffee> coffeeAssortiment;
    private ArrayList<Ingredient> additionalIngredients;

    public ShowAssortimentService(IIngredientPricesDAO _ingredientRepository, ICoffeeMachineDAO _coffeeMachineRepository,
                                  ICoffeeTypeDAO _coffeTypeRepository) {
        this._ingredientRepository = _ingredientRepository;
        this._coffeeMachineRepository = _coffeeMachineRepository;
        this._coffeTypeRepository = _coffeTypeRepository;
    }
    public boolean Process(int machineId){
        CoffeeMachine coffeeMachine = _coffeeMachineRepository.GetCoffeeMachine(machineId);
        if(coffeeMachine == null || !coffeeMachine.AbleToMakeAnyCoffee())
            return false;
        ArrayList<CoffeeType> availableCoffeeTypes = SelectAvailableCoffeeTypes(coffeeMachine);
        if(availableCoffeeTypes.isEmpty())
            return false;
        ArrayList<Ingredient> allIngredients = _ingredientRepository.getAllIngredients();
        additionalIngredients = allIngredients;
        coffeeAssortiment = FormCoffeeAssortiment(availableCoffeeTypes, allIngredients);
        return true;
    }

    private ArrayList<Coffee> FormCoffeeAssortiment(ArrayList<CoffeeType> availableCoffeeTypes, ArrayList<Ingredient> allIngredients) {
        ArrayList<Coffee> result = new ArrayList<Coffee>();
        Stream<Ingredient> ingredientStream = allIngredients.stream();
        for(CoffeeType coffeeType : availableCoffeeTypes) {
            Coffee coffee = new Coffee(coffeeType.getName(),
                    ingredientStream.filter(ingredient ->
                            ingredient.getName().equals(coffeeType.getName()))
                            .findFirst().get().getPricePerPortion(),
                    coffeeType.getCoffeeAmount(), coffeeType.getMilkAmount(),
                    coffeeType.getWaterAmount());
            result.add(coffee);
        }
        return result;
    }


    private ArrayList<CoffeeType> SelectAvailableCoffeeTypes(CoffeeMachine coffeeMachine) {
        ArrayList<CoffeeType> allCoffeeTypes = _coffeTypeRepository.GetAllCoffeeTypes();
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
