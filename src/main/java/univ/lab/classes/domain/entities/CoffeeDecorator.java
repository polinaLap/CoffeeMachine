package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public class CoffeeDecorator implements ICoffee {
    private  ICoffee _mainIngredient;
    private CoffeeParameters _coffeeParameters;
    private double _price;

    public CoffeeDecorator(ICoffee mainIngredient, CoffeeParameters parameters, double price) {
        _mainIngredient = mainIngredient;
        _coffeeParameters = parameters;
        _price = price;
    }

    public double getPrice() {
        return _price + _mainIngredient.getPrice();
    }

    public double getCoffeeAmount() {
        return _coffeeParameters.get_coffeeAmount() + _mainIngredient.getCoffeeAmount();
    }
    public double getWaterAmount() {
        return _coffeeParameters.get_waterAmount() + _mainIngredient.getWaterAmount();
    }
    public double getMilkAmount() {
        return _coffeeParameters.get_milkAmount() + _mainIngredient.getMilkAmount();
    }

    public double getSugarAmount() {
        return _coffeeParameters.get_sugarAmount()+_mainIngredient.getSugarAmount();
    }
}
