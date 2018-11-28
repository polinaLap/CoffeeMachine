package univ.lab.classes.services;

import univ.lab.classes.domain.entities.CoffeeMachine;
import univ.lab.classes.domain.entities.UserAccount;
import univ.lab.classes.domain.interfaces.ICoffee;
import univ.lab.classes.domain.interfaces.ICoffeeMachineDAO;
import univ.lab.classes.domain.interfaces.IMakeCoffeeService;
import univ.lab.classes.domain.interfaces.IUserDAO;

public class MakeCoffeeService implements IMakeCoffeeService {
    private ICoffeeMachineDAO _coffeeMachineRepository;
    private IUserDAO _userRepository;

    public MakeCoffeeService(ICoffeeMachineDAO _coffeeMachineRepository, IUserDAO _userRepository) {
        this._coffeeMachineRepository = _coffeeMachineRepository;
        this._userRepository = _userRepository;
    }

    @Override
    public int MakeCoffee(ICoffee coffee, CoffeeMachine coffeeMachine, int userId) {
        UserAccount userAccount = _userRepository.GetUserAccount(userId);
        if (userAccount.get_money() < coffee.getPrice())
            return -1;
        if (!coffeeMachine.AbleToMake(coffee))
            return 0;

        coffeeMachine.MakeCoffee(coffee);
        userAccount.spendMoney(coffee.getPrice());
        if(!_coffeeMachineRepository.UpdateCoffeeMachine(coffeeMachine.getCoffeeParameters()))
            return 0;
        if(!_userRepository.UpdateUserAccount(userAccount))
            return -2;
        return 1;
    }
}
