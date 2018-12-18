package univ.lab.classes.domain.entities;

public class CoffeeParameters {
    private double _coffeeAmount;
    private double _milkAmount;
    private double _sugarAmount;
    private double _waterAmount;

    public double get_coffeeAmount() {
        return _coffeeAmount;
    }

    public void set_coffeeAmount(double _coffeeAmount) {
        this._coffeeAmount = _coffeeAmount;
    }

    public double get_milkAmount() {
        return _milkAmount;
    }

    public void set_milkAmount(double _milkAmount) {
        this._milkAmount = _milkAmount;
    }

    public double get_sugarAmount() {
        return _sugarAmount;
    }

    public void set_sugarAmount(double _sugarAmount) {
        this._sugarAmount = _sugarAmount;
    }

    public double get_waterAmount() {
        return _waterAmount;
    }

    public void set_waterAmount(double _waterAmount) {
        this._waterAmount = _waterAmount;
    }

    public void set_AnyAmount(String ingredientName, double amount) {
        switch (ingredientName){
            case "coffee": set_coffeeAmount(amount);
            break;
            case "water": set_waterAmount(amount);
                break;
            case "milk": set_milkAmount(amount);
                break;
            case "sugar": set_sugarAmount(amount);
                break;
        }
    }
}
