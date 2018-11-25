package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public class CoffeeMachine {

    private int id;
    private CoffeeParameters coffeeParameters;

    public CoffeeMachine( int id) {
        this.id = id;
        coffeeParameters = new CoffeeParameters();
    }

    public ICoffee GetCoffee(CoffeeType type){
        if(!AbleToMake(type))
            return null;
        return null;
    }

    private boolean AbleToMake(CoffeeType type){
        return true;
    }

    public int getId() {
        return id;
    }

    public void set_coffeeAmount(double _coffeeAmount) {
        coffeeParameters.set_coffeeAmount(_coffeeAmount);
    }

    public void set_milkAmount(double _milkAmount) {
        coffeeParameters.set_milkAmount(_milkAmount);
    }

    public void set_sugarAmount(double _sugarAmount) {
        coffeeParameters.set_sugarAmount(_sugarAmount);
    }

    public void set_waterAmount(double _waterAmount) {
        coffeeParameters.set_waterAmount(_waterAmount);
    }

    public double get_coffeeAmount() {
        return coffeeParameters.get_coffeeAmount();
    }
    public double get_milkAmount() {
        return coffeeParameters.get_milkAmount();
    }public double get_sugarAmount() {
        return coffeeParameters.get_sugarAmount();
    }public double get_waterAmount() {
        return coffeeParameters.get_waterAmount();
    }
}
