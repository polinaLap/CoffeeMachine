package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public class Coffee implements ICoffee {
    private String _name;
    private double _price;
    private double _coffeeAmmount;
    private double _milkAmmount;
    private double _waterAmount;

    public Coffee(String _name, double _price, double _coffeeAmmount, double _milkAmmount, double _waterAmount) {
        this._name = _name;
        this._price = _price;
        this._coffeeAmmount = _coffeeAmmount;
        this._milkAmmount = _milkAmmount;
        this._waterAmount = _waterAmount;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public double getPrice() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    public double getCoffeeAmmount() {
        return _coffeeAmmount;
    }

    public void set_coffeeAmmount(double _coffeeAmmount) {
        this._coffeeAmmount = _coffeeAmmount;
    }

    public double getMilkAmmount() {
        return _milkAmmount;
    }

    public void set_milkAmmount(double _milkAmmount) {
        this._milkAmmount = _milkAmmount;
    }

    public double get_waterAmount() {
        return _waterAmount;
    }

    public void set_waterAmount(double _waterAmount) {
        this._waterAmount = _waterAmount;
    }


}
