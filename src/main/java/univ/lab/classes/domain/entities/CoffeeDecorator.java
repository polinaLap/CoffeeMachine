package univ.lab.classes.domain.entities;

import univ.lab.classes.domain.interfaces.ICoffee;

public abstract class CoffeeDecorator implements ICoffee {
    protected  Coffee _mainIngredient;

    public CoffeeDecorator(Coffee mainIngredient) {
        _mainIngredient = mainIngredient;
    }
}
