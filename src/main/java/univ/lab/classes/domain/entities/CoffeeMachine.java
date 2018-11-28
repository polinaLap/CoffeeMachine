package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public class CoffeeMachine {

    private CoffeeParameters coffeeParameters;

    public CoffeeMachine() {
        coffeeParameters = new CoffeeParameters();
    }

    public boolean AbleToMakeAnyCoffee() {
        return coffeeParameters.get_waterAmount() > 0 && coffeeParameters.get_coffeeAmount() > 0;
    }

    public  boolean AbleToMake(CoffeeType type) {
        return coffeeParameters.get_coffeeAmount() > type.getCoffeeAmount()
                && coffeeParameters.get_waterAmount() > type.getWaterAmount()
                && coffeeParameters.get_milkAmount() > type.getMilkAmount();
    }

    public  boolean AbleToMake(ICoffee coffee) {
        return coffeeParameters.get_coffeeAmount() > coffee.getCoffeeAmount()
                && coffeeParameters.get_waterAmount() > coffee.getWaterAmount()
                && coffeeParameters.get_milkAmount() > coffee.getMilkAmount()
                && coffeeParameters.get_sugarAmount() > coffee.getSugarAmount();
    }

    public  void MakeCoffee(ICoffee coffee) {
        set_coffeeAmount(get_coffeeAmount() - coffee.getCoffeeAmount());
        set_waterAmount(get_waterAmount() - coffee.getWaterAmount());
        set_milkAmount(get_milkAmount() - coffee.getMilkAmount());
        set_sugarAmount(get_sugarAmount() - coffee.getSugarAmount());
    }

    public CoffeeParameters getCoffeeParameters() {
        return coffeeParameters;
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
    }

    public double get_sugarAmount() {
        return coffeeParameters.get_sugarAmount();
    }

    public double get_waterAmount() {
        return coffeeParameters.get_waterAmount();
    }
}
