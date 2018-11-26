package univ.lab.classes.domain.entities;

public class Ingredient {

    private String name;
    private double portionSize;
    private double pricePerPortion;


    public Ingredient(String name, double portionSize, double pricePerPortion) {
        this.name = name;
        this.portionSize = portionSize;
        this.pricePerPortion = pricePerPortion;
    }

    public String getName() {
        return name;
    }

    public double getPortionSize() {
        return portionSize;
    }

    public double getPricePerPortion() {
        return pricePerPortion;
    }

}
