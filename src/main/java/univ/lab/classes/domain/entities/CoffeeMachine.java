package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public class CoffeeMachine {

    private double _coffeeAmmount;
    private double _milkAmmount;
    private double _sugarAmmount;
    private double _waterAmmount;

    public CoffeeMachine() {}

    public ICoffee GetCoffee(CoffeeType type){
        if(!AbleToMake(type))
            return null;
        return null;
    }

    private boolean AbleToMake(CoffeeType type){
        return true;
    }

    public void set_coffeeAmmount(double _coffeeAmmount) {
        this._coffeeAmmount = _coffeeAmmount;
    }

    public void set_milkAmmount(double _milkAmmount) {
        this._milkAmmount = _milkAmmount;
    }

    public void set_sugarAmmount(double _sugarAmmount) {
        this._sugarAmmount = _sugarAmmount;
    }

    public void set_waterAmmount(double _waterAmmount) {
        this._waterAmmount = _waterAmmount;
    }
}
