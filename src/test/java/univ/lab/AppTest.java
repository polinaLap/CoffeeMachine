package univ.lab;

import javafx.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import univ.lab.classes.domain.entities.*;
import univ.lab.classes.domain.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    IGetAssortimentService getAssortimentService;
    @Autowired
    IBuildFullCoffeeService buildFullCoffeeService;
    @Autowired
    IMakeCoffeeService makeCoffeeService;
    @Autowired
    ICoffeeMachineDAO coffeeMachineRepository;
    @Autowired
    IUserDAO userRepository;
    private int userId = 1;
    private int coffeeMachineId = 1;

    @Test
    public void BuyCoffeeSuccessTest() {
        CoffeeMachine coffeeMachine = coffeeMachineRepository.GetCoffeeMachine(coffeeMachineId);

        //getting assortiment
        getAssortimentService.Process(coffeeMachine);
        getAssortimentService.getCoffeeAssortiment();
        ArrayList<Coffee> allCoffees = getAssortimentService.getCoffeeAssortiment();
        ArrayList<Ingredient> additionalIngredients = getAssortimentService.getAdditionalIngredients();
        assertTrue("Should contain any coffee", !allCoffees.isEmpty());
        assertTrue("Should contain any adds", !additionalIngredients.isEmpty());

        //build and calculate coffee
        Coffee chosenCoffee = allCoffees.get(0);
        Ingredient chosenAdditionalIngredient = additionalIngredients.get(0);
        Dictionary<String, Pair<Ingredient, Integer>> addsWithPortion = new Hashtable<>();
        addsWithPortion.put(chosenAdditionalIngredient.getName(), new Pair<>(chosenAdditionalIngredient, 3));

        ICoffee madeCoffee = buildFullCoffeeService.Build(chosenCoffee, addsWithPortion);
        double cooffeeOutcomes = madeCoffee.getCoffeeAmount();
        if (chosenAdditionalIngredient.getName().equals(IngredientNames.COFFEE))
            cooffeeOutcomes += chosenAdditionalIngredient.getPortionSize() * 3;
        assertTrue("Should count price correctly",
                madeCoffee.getPrice() == chosenCoffee.getPrice()
                        + 3 * chosenAdditionalIngredient.getPricePerPortion());
        assertTrue("Should count coffee outcomes correctly",
                madeCoffee.getCoffeeAmount() == cooffeeOutcomes);

        //make coffee and save changes
        UserAccount userBefore = userRepository.GetUserAccount(userId);
        if (makeCoffeeService.MakeCoffee(madeCoffee, coffeeMachine, userId) != 1)
            assertTrue("Error during making coffee", false);

        UserAccount userAfter = userRepository.GetUserAccount(userId);
        double eps = 0.01;
        assertTrue("User outcomes should be correct", userBefore.get_money()
                - userAfter.get_money() - madeCoffee.getPrice() < eps);
        CoffeeMachine coffeeMachineAfter = coffeeMachineRepository.GetCoffeeMachine(coffeeMachineId);
        assertTrue("Coffee machine outcomes should be correct", coffeeMachine.get_coffeeAmount()
                - coffeeMachineAfter.get_coffeeAmount() - madeCoffee.getCoffeeAmount() < eps);
    }
}
