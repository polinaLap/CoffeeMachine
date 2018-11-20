package univ.lab.classes.domain.entities;

public class UserAccount {

    private double _money;

    public UserAccount() {
        _money = 0;
    }

    public void addMoney(double plusCash){
        _money+=plusCash;
    }
    public void spendMoney(double minusCash){
        _money-=minusCash;
    }
    public double get_money() {
        return _money;
    }
}
