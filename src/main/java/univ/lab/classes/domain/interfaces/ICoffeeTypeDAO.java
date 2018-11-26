package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.CoffeeType;

import java.util.ArrayList;

public interface ICoffeeTypeDAO {
    CoffeeType GetCoffeeType (String name);
    boolean AddCoffeeType(CoffeeType type);
    ArrayList<CoffeeType> GetAllCoffeeTypes();
}
