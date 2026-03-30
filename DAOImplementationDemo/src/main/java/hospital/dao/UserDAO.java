package hospital.dao;

import hospital.model.User;

public interface UserDAO {

    boolean loginUnsafe(String username,String password);
    boolean loginSafe(String username,String password);
    User getUserByUsername(String username);
}
