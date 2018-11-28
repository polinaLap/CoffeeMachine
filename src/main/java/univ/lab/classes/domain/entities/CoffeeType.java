package univ.lab.classes.domain.entities;

public class CoffeeType {


    private String _name;
    private double _coffeeAmount;
    private double _milkAmount;
    private double _waterAmount;

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public double getCoffeeAmount() {
        return _coffeeAmount;
    }

    public void setCoffeeAmount(double _coffeeAmount) {
        this._coffeeAmount = _coffeeAmount;
    }

    public double getMilkAmount() {
        return _milkAmount;
    }

    public void setMilkAmount(double _milkAmount) {
        this._milkAmount = _milkAmount;
    }

    public double getWaterAmount() {
        return _waterAmount;
    }

    public void setWaterAmount(double _waterAmount) {
        this._waterAmount = _waterAmount;
    }
}
