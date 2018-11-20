package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.CoffeeType;

public interface ICoffeeTypeDAO {
    CoffeeType GetCoffeeType (int id);
    boolean AddCoffeeType(CoffeeType type);
}
