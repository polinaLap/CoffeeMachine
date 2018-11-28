package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public class Coffee implements ICoffee {
    private String _name;
    private double _price;
    private double _coffeeAmount;
    private double _milkAmount;
    private double _waterAmount;
    private double _sugarAmount;

    public Coffee(String _name, double _price, double _coffeeAmount, double _milkAmount, double _waterAmount) {
        this._name = _name;
        this._price = _price;
        this._coffeeAmount = _coffeeAmount;
        this._milkAmount = _milkAmount;
        this._waterAmount = _waterAmount;
        this._sugarAmount = 0;
    }

    public String getName() {
        return _name;
    }

    public double getPrice() {
        return _price;
    }

    public double getCoffeeAmount() {
        return _coffeeAmount;
    }

    public double getMilkAmount() {
        return _milkAmount;
    }

    public double getWaterAmount() {
        return _waterAmount;
    }

    public double getSugarAmount() {
        return _sugarAmount;
    }
}
