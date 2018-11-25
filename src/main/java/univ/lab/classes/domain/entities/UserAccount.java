package univ.lab.classes.domain.entities;

public class UserAccount
{
    private int _id;
    private double _money;

    public UserAccount(int id) {
        _money = 0;
        _id = id;
    }

    public int get_id() {
        return _id;
    }
    public void addMoney(double plusCash) {
        _money += plusCash;
    }
    public void spendMoney(double minusCash) {
        _money -= minusCash;
    }
    public double get_money() {
        return _money;
    }
}
