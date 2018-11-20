package univ.lab.classes.domain.entities;

public class CoffeeType {
    private int _Id;
    private double _coffeeAmount;
    private double _milkAmount;
    private double _waterAmount;
    private boolean _waterBeforeMilk;

    public int getId() {
        return _Id;
    }

    public void setId(int _Id) {
        this._Id = _Id;
    }

    public double getCoffeeAmount() {
        return _coffeeAmount;
    }

    public void setCoffeeAmount(double _coffeAmount) {
        this._coffeeAmount = _coffeAmount;
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

    public boolean isWaterBeforeMilk() {
        return _waterBeforeMilk;
    }

    public void setWaterBeforeMilk(boolean _waterBeforeMilk) {
        this._waterBeforeMilk = _waterBeforeMilk;
    }
}
