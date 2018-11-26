package univ.lab.classes.domain.interfaces;

import univ.lab.classes.domain.entities.UserAccount;

public interface IUserDAO {
    UserAccount GetUserAccount(int id);
    boolean UpdateUserAccount (int id, double money);
}
