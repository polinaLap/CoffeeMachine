package univ.lab.classes.domain.entities;

import java.util.UUID;

public class User{
    private UUID _id;
    private String _name;
    private UserAccount _userAccount;

    public User(UUID id, String name, UserAccount userAccount){
        _id = id;
        _name = name;
        _userAccount = userAccount;
    }

    public UUID get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
